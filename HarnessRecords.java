
import java.util.ArrayList;

public class HarnessRecords 
{
	private ArrayList<Harness> harnessList;

	public HarnessRecords()
	{
		ArrayList<Harness> harnessList = new ArrayList<Harness>();
	}

	public HarnessRecords(In harnessRecords)
	{
		boolean onLoan;
		String listOfHarnesses = harnessRecords.readAll();
		String[] harnessDetails = listOfHarnesses.split("\n");
		String make = harnessDetails[0];
		int modNumber = harnessRecords.readInt();
		int numOfUses = harnessRecords.readInt();
		String safetyChecker = harnessDetails[3];
		String loanStatus = harnessDetails[4];
		String borrower = harnessDetails[5];
		if(loanStatus.equals("yes"))
		{
			onLoan = true;
		}
		else onLoan = false;
		Harness harness = new Harness(make, modNumber, numOfUses, safetyChecker, onLoan, borrower);
		ArrayList<Harness> harnessList = new ArrayList<Harness>();
		addHarness(harness);
	}

	public boolean isEmpty(){
		if(harnessList == null)
		{
			return true;
		}
		else return false;
	}

	public void addHarness(Harness harness)
	{
		harnessList.add(harness);
	}

	public Harness findHarness(String make, int modelNumber)
	{
		for(int i = 0; i < harnessList.lastIndexOf(harnessList) + 1; i++)
		{
			if(harnessList.get(i).getMake().equals(make) && harnessList.get(i).getModelNumber() == modelNumber){
				return harnessList.get(i);
			}
		}
		return null;
	}

	public Harness checkHarness(String safetyChecker, String make, int modelNumber)
	{
		Harness harness = findHarness(make, modelNumber);

		if(harness != null && !harness.isHarnessOnLoan())
		{
			harness.checkHarness(safetyChecker);
		}
		return harness;
	}

	public Harness loanHarness(String borrower)
	{
		for(int i = 0; i < harnessList.lastIndexOf(harnessList) + 1; i++)
		{
			Harness h = findHarness(harnessList.get(i).getMake(), harnessList.get(i).getModelNumber());
			if(h != null && h.canHarnessBeLoaned())
			{
				h.loanHarness(borrower);
				return h;
			}		
		}
		return null;
	}

	public Harness returnHarness (String make, int modelNumber)
	{
		Harness h = findHarness(make, modelNumber);
		h = new Harness(h.getMake(), h.getModelNumber(), h.getNumberOfUses(), h.getSafetyChecker(), false, null);
		return h;
	}

	public Harness removeHarness(String make, int modelNumber)
	{
		Harness h = findHarness(make, modelNumber);
		if(h != null)
		{
			harnessList.remove(h);
			return h;
		}
		else return null;
	}
}
