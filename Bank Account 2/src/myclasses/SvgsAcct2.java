//Avraham Moryosef
//CS 420
//7/17/15

package myclasses;

public class SvgsAcct2 extends BankAcct
{
	private static double interestRate = 0.04;
	private int count = 0;
	
	public SvgsAcct2(int acctNbr, double balance)
	{
		super(acctNbr, balance);
	}

	public static double getInterestRate()
	{
		return interestRate;
	}

	public static void setInterestRate(double InterestRate)
	{
		SvgsAcct2.interestRate = InterestRate;
	}
	
	@Override
	public void withdraw(double withdraw)
	{
		setBalance(getBalance() - withdraw);
		count++;
	}

	@Override
	public void monthEnd()
	{
		double svgsBal;
		if(count > 1)
		{
			count = (count - 1) * 3;
			svgsBal = getBalance() - count;
			svgsBal = svgsBal + (svgsBal * (getInterestRate() / 12));
			svgsBal = Math.round(svgsBal * 100) / 100.0;
		}
		
		else
		{
			svgsBal = getBalance() + (getBalance() * (getInterestRate() / 12)); 
		}
		
		setBalance(svgsBal);
		count = 0;
		
	}
}
