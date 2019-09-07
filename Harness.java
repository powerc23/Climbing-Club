
public class Harness
{

	private String make;
	private int modelNumber;
	private int numberOfUses;
	private String safetyChecker;
	private boolean onLoan;
	private String borrower;

	public Harness(String m, int modNumber, int numOfUses, String checker, boolean loan, String member)
	{
		make = m;
		modelNumber = modNumber;
		numberOfUses = numOfUses;
		safetyChecker = checker;
		onLoan = loan;
		if(onLoan)
		{
			borrower = member;
		}
		else borrower = null;
	}

	public Harness(String m, int modNumber, String checker)
	{
		make = m;
		modelNumber = modNumber;
		safetyChecker = checker;
		numberOfUses = 0;
		onLoan = false;
		borrower = null;
	}

	public void checkHarness(String checker)
	{
		if(!onLoan)
		{
			numberOfUses = 0;
			safetyChecker = checker;
		}
	}

	public boolean isHarnessOnLoan()
	{
		return onLoan;
	}

	public boolean canHarnessBeLoaned()
	{
		if(!onLoan && numberOfUses < 25)
		{
			return true;
		}
		else return false;
	}

	public void loanHarness(String member){
		if(canHarnessBeLoaned())
		{
			borrower = member;
			onLoan = true;
		}
	}

	public String toString ()
	{
		String harnessDetails = "Make: " + make + "\nModel number: " + Integer.toString(modelNumber) + "\nNumber of Uses: " +
				Integer.toString(numberOfUses) + "\nLast checked by: " + this.safetyChecker + "\nOn loan to: " +
				borrower;
		return harnessDetails;
	}

	public String getMake()
	{
		return make;
	}

	public int getModelNumber()
	{
		return modelNumber;
	}

	public int getNumberOfUses()
	{
		return numberOfUses;
	}

	public String getSafetyChecker()
	{
		return safetyChecker;
	}

	public boolean getLoanStatus()
	{
		return onLoan;
	}

	public String getBorrower()
	{
		return borrower;
	}
}





