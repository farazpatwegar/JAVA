package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDao;
import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

import static com.app.utils.DBUtils.*;

/**
 * Servlet implementation class AdminServlet
 */
//@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CandidateDaoImpl candidateDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		System.out.println("in init of " + getClass()+" cofig "+config);//not null
		try {
			//open db connection once
			openConnection(config.getInitParameter("db_url"),
					config.getInitParameter("user_name"),
					config.getInitParameter("password"));
			candidateDao=new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init - " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			candidateDao.cleanUp();
		} catch (Exception e) {
			System.out.println("error in destroy of admin servlet" + e);
		}
		;
		System.out.println("in destroy of:" + getClass());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();
			candidateDao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
			
			pw.print("<form action='logout' method='post'>");
			pw.write("<h3><b>Top 2 Candidates</b></h3>");
			List<Candidate> candidateList = candidateDao.getTop2Candidates();
			for (Candidate c : candidateList) {
				pw.print("<h4>"+c+"</h4>");
			}
			
			pw.write("<h3><b> Displaying Votes Analysis</b></h3>");
			Map<String,Integer> map = candidateDao.getPartyWiseVotes();
			map.forEach((k,v) -> pw.print("<h4>"+k+"  has  "+v+"  votes</h4>"));
			
			pw.write("<h4><input type='submit' value='adminlogout'></h4>");
			
			pw.write("</form>");
			
			
			
		} catch (Exception e) {
			throw new ServletException("error in do get of admin servlet", e);
		}
		System.out.println("in do get of : " + getClass());
	}

}
