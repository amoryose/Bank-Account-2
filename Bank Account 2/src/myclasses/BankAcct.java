//Avraham Moryosef
//CS 420
//7/17/15

package myclasses;

import java.text.DecimalFormat;

public abstract class BankAcct
{
	DecimalFormat twoDigits = new DecimalFormat("0.00");
	
	private int acctNbr;
	private double balance;
	
	public BankAcct(int AcctNbr, double Balance)
	{
		this.acctNbr = AcctNbr;
		this.balance = Balance;
	}

	protected void setAcctNbr(int acctNbr)
	{
		this.acctNbr = acctNbr;
	}

	protected void setBalance(double balance)
	{
		this.balance = balance;
	}

	public double getBalance()
	{
		return balance;
	}

	public int getAcctNbr()
	{
		return acctNbr;
	}
	
	public void deposit(double deposit)
	{
		balance = getBalance() + deposit;
	}
	
	public void withdraw(double withdraw)
	{
		balance = getBalance() - withdraw;
	}
	
	public abstract void monthEnd();
	
	public String toString()
	{
		return "Acct nbr " + getAcctNbr() + " " + "has balance $" + 
					twoDigits.format(getBalance());
	}
}
