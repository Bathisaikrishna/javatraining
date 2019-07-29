package com.visa.prj.entity;

/**
 * This is a class to represent account business data.
 * It allows to credit and debit amount.
 * @author root
 *
 */
public class Account {
	private double balance; //state of object -->instance variables
	
	private static int count;
	public Account() {
		count++;
	}

	public static int getCount() {
		return count;
	}

	

	/**
	 * method to credit amount into account
	 * 
	 * @param amt amount to be credited
	 */
	public void deposit(double amt) // -->instance methods
	{//public void deposit(Account this, double amt) this.balance += amt;
		balance += amt;
	}
	
	/**
	 * 
	 * @return the current balance
	 */
	public double getBalance()
	{
		return this.balance;
	}

	

}
