import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.concurrent.atomic.LongAccumulator;

public class ClimbingClubInput {

	public static void main(String[] args)
	{
		try
		{
			In harnessRecords = new In("harnessRecordsFile");
			HarnessRecords records = new HarnessRecords();
			boolean finished = false;
			while(!finished)
			{
				String optionInput = JOptionPane.showInputDialog(null, "What would you like to do?\nType:\n-'add' to "
						+ "add a harness\n-'remove' to remove a harness\n-'check' to check a harness\n-'loan' to loan a "
						+ "harness\n-'return' to return a harness\n-'quit' to exit");
				if(optionInput.equals("add"))
				{
					addHarness(records);
				}
				else if(optionInput.equals("remove"))
				{
					removeHarness(records);
				}
				else if(optionInput.equals("check"))
				{
					checkHarness(records);
				}
				else if(optionInput.equals("loan"))
				{
					loanHarness(records);
				}
				else if(optionInput.equals("return"))
				{
					returnHarness(records);
				}
				else if(optionInput.equals("quit"))
				{
					JOptionPane.showMessageDialog(null, "Goodbye!");
					finished = true;
				}
				else JOptionPane.showMessageDialog(null, "Input invalid!");
			}
		}
		catch(Exception NullPointerException)
		{

		}
	}

	public static void addHarness(HarnessRecords records)
	{
		String makeInput = JOptionPane.showInputDialog(null, "Enter harness make: ");
		String make = makeInput;
		String modelNumberInput = JOptionPane.showInputDialog(null, "Enter the model number: ");
		Scanner inputScanner1 = new Scanner(modelNumberInput);
		if(inputScanner1.hasNextInt())
		{
			int modelNumber = inputScanner1.nextInt();
			String safetyChecker = JOptionPane.showInputDialog(null, "Who checked the safety of this harness?");
			Harness harness = new Harness(make, modelNumber, safetyChecker);
			records.addHarness(harness);
		}
		else JOptionPane.showMessageDialog(null, "Input invalid!");
	}

	public static void removeHarness(HarnessRecords records)
	{
		String makeInput = JOptionPane.showInputDialog(null, "Enter harness make: ");
		String make = makeInput;
		String modelNumberInput = JOptionPane.showInputDialog(null, "Enter the model number: ");
		Scanner inputScanner1 = new Scanner(modelNumberInput);
		if(inputScanner1.hasNextInt()){
			int modelNumber = inputScanner1.nextInt();
			records.removeHarness(make, modelNumber);
		}
		else JOptionPane.showMessageDialog(null, "Input invalid!");
	}

	public static void checkHarness(HarnessRecords records)
	{
		String makeInput = JOptionPane.showInputDialog(null, "Enter harness make: ");
		String make = makeInput;
		String modelNumberInput = JOptionPane.showInputDialog(null, "Enter the model number: ");
		Scanner inputScanner1 = new Scanner(modelNumberInput);
		if(inputScanner1.hasNextInt()){
			int modelNumber = inputScanner1.nextInt();
			String safetyChecker = JOptionPane.showInputDialog(null, "Who checked the safety of this harness?");
			records.checkHarness(safetyChecker, make, modelNumber);
		}
		else JOptionPane.showMessageDialog(null, "Input invalid!");
	}

	public static void loanHarness(HarnessRecords records)
	{
		String harnessLoanDialog = JOptionPane.showInputDialog(null, "Would you like to loan a harness?\n"
				+ "(Enter 'y' or 'n')");
		if(harnessLoanDialog.equals("y"))
		{
			String borrower = JOptionPane.showInputDialog(null, "Enter borrower's name: ");
			records.loanHarness(borrower);
			JOptionPane.showMessageDialog(null, "A harness has been loaned.");
		}
		else if(harnessLoanDialog.equals("n"))
		{
		}
	}

	public static void returnHarness(HarnessRecords records)
	{
		String makeInput = JOptionPane.showInputDialog(null, "Enter harness make: ");
		String make = makeInput;
		String modelNumberInput = JOptionPane.showInputDialog(null, "Enter the model number: ");
		Scanner inputScanner1 = new Scanner(modelNumberInput);
		if(inputScanner1.hasNextInt()){
			int modelNumber = inputScanner1.nextInt();
			records.removeHarness(make, modelNumber);
			JOptionPane.showMessageDialog(null, "The harness has been returned.");
		}
		else JOptionPane.showMessageDialog(null, "Input invalid!");
	}
}






