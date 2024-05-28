package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

import static com.app.utils.DBUtils.*;;

/**
 * Servlet implementation class VoterRegistrationServlet
 */
//@WebServlet("/voter_register")
public class VoterRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userdao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("init of reg ser");
		try {
			ServletConfig config = getServletConfig();

			openConnection(config.getInitParameter("db_url"), config.getInitParameter("user_name"),
					config.getInitParameter("password"));
			userdao=new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException("error in init method of: " + getClass(), e);
		}

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userdao.cleanUp();
			closeConnection();
			System.out.println("destroy of reg ser");
		} catch (Exception e) {
			System.out.println("error in destroy of :" + getClass());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("do post of reg ser");

		// 1.set content type
		// 2. get the printwriter
		// 2.get the http session
		// 2.get the request parameters
		// 3.create user instance to store the details get from the form
		// 4. check if age is above 21 years if okay proceed
		// 4. call user dao's voter registration method String voterRegistration(User
		// newVoter) throws SQLException; to register the the voter
		// 5. print the message to the client and redirect him/her to login page to
		// again login
		// 6. if age is invalid print message to client and redirect him/her to voter
		// registration page
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			
			HttpSession hs = request.getSession();
			
			String fName = request.getParameter("fn");
			String lName = request.getParameter("ln");
			String email = request.getParameter("em");
			String pass = request.getParameter("pass");
			LocalDate birthdate = LocalDate.parse(request.getParameter("dob"));

			int age = Period.between(birthdate, LocalDate.now()).getYears();

			if (age >= 21) {
				User newVoter1 = new User(fName, lName, email, pass, Date.valueOf(birthdate));
//					System.out.println(newVoter);
				System.out.println("Voter reg before method call");
				String voterRegistration = userdao.voterRegistration(newVoter1);
				System.out.println("Voter reg after method call");
//					System.out.println(registrationStatus);
//					System.out.println(userdao.voterRegistration(newVoter));
				pw.print("<h5>" + voterRegistration + "</h5>");
				hs.invalidate();
				pw.print("<h5><a href='login.html'>ReLogin</a></h5>");
			} else {
				pw.print("Voter registration failed!!\nIvlalid age");
				pw.print("<h5><a href='voter_registration.html'>Retry</a></h5>");
			}

		}
//			catch(Exception e)
//			{
//				throw new ServletException("err in dopost of: "+getClass(),e);
//			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
