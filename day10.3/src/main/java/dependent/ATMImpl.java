package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private long cash;//mandatory
	private Transport myTransport;// optional
	public ATMImpl(long cash1) {
		this.cash=cash1;
		System.out.println("in cnstr of " + getClass() + " " + cash + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}
	

	// custom init method
	public void anyInit() {
		System.out.println("in init " + myTransport);
	}

	// custom destroy method
	public void anyDestroy() {
		System.out.println("in destroy " + myTransport);
	}


	/**
	 * @param myTransport the myTransport to set
	 */
	public void setMyTransport(Transport myTransport) {
		System.out.println("in settor of: "+getClass());
		this.myTransport = myTransport;
	}
	

}
