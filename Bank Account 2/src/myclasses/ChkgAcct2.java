//Avraham Moryosef
//CS 420
//7/17/15

package myclasses;

public class ChkgAcct2 extends BankAcct
{
	private static double monthlyFee = 3.00;
	private static double perCheckFee = 0.15;
	private int nbrOfChecks = 0;
	
	private void setNbrOfChecks(int NbrOfChecks)
	{
		this.nbrOfChecks = NbrOfChecks;
	}

	public int getNbrOfChecks()
	{
		return nbrOfChecks;
	}

	public static double getPerCheckFee()
	{
		return perCheckFee;
	}

	public static void setPerCheckFee(double PerCheckFee)
	{
		ChkgAcct2.perCheckFee = PerCheckFee;
	}

	public ChkgAcct2(int acctNbr, double balance)
	{
		super(acctNbr, balance);
	}

	public static double getMonthlyFee()
	{
		return monthlyFee;
	}

	public static void setMonthlyFee(double MonthlyFee)
	{
		ChkgAcct2.monthlyFee = MonthlyFee;
	}
	
	@Override
	public void withdraw(double withdraw)
	{
		setBalance(getBalance() - withdraw);
		nbrOfChecks++;
		
		if(getBalance() < 500)
		{
			setBalance(getBalance() - (nbrOfChecks * perCheckFee));
		}
	}

	@Override
	public void monthEnd()
	{
		if(getBalance() >= 500)
		{
			setBalance(getBalance() + (getBalance() * (0.02 / 12)));
		}
		
		else if(nbrOfChecks > 0)
		{
			setBalance(getBalance() - monthlyFee);
		}

		setBalance(getBalance());
		setNbrOfChecks(0);
	}
}
