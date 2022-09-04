/**
 * this driver program implements the SocSecException to create
 * a program which throws an exception whenever a social security
 * number is entered incorrectly
 * @author Christopher Perez Lebron
 */
import java.util.Scanner; 

public class SocSecProcessor {
	
	public static void main(String[] args) {
		String repeatAnswer; 
		Scanner keyboard = new Scanner(System.in);
		do
		{
			
			
			System.out.print("Input your full name: ");
			String name = keyboard.nextLine();
			
			System.out.print("Input your social security number: "
					+ "(Format: 999-99-9999 ): "); 
			String ssnNo = keyboard.nextLine();
			
			try
			{
				if(isValid(ssnNo)) {
					System.out.println("Your Social Security Number was entered successfully. "
							+ "\nHere is the information you enered:");
					System.out.println("\t" + name);
					System.out.println("\t" + ssnNo);
				}
			}
			catch (SocSecException e)
			{
				System.out.println(e.getMessage());
				System.out.println("\nYou entered the following information:");
				System.out.println("\t" + name);
				System.out.println("\t" + ssnNo);
				System.out.println("");
				
				
			}
			
			System.out.print("Would you like to try again? (Y/N): ");
			repeatAnswer = keyboard.nextLine();
			
			//remove any leading or trailing accidental spaces
			repeatAnswer.trim();
		} while (repeatAnswer.equalsIgnoreCase("y"));
		
		keyboard.close();
	}
	
	/**
	 * this method tests a social security number to see if it 
	 * is a valid entry
	 * @param ssn a String object representing the social security number entered
	 * @return true if the string is valid 
	 * @throws SocSecException whenever the social security number is invalid
	 */
	public static boolean isValid(String ssn) throws SocSecException {
		//trim any leading or trailing zeros the user may accidentally put in
		ssn.trim();
		
		//throw error if ssn string provided is not of the correct length
		if(ssn.length() != 11) {
			throw new SocSecException("ERROR: The length of your Social"
					+ " Security Number does not"
					+ "\nequal 11. Please double"
					+ " check your entry and try again.");
		}
		for(int count = 0; count < ssn.length(); count++) {
			if(count == 3 || count == 6) {
				if(ssn.charAt(count) != '-') {
					throw new SocSecException("ERROR: it looks like "
							+ "your Social Security Number does"
							+ "\nnot include dashes in the correct location."
							+ "Please ensure you follow the specified "
							+ "format. "
							+ "\n(123-45-5678)");
				}
			}
			else {
				if(!Character.isDigit(ssn.charAt(count))) {
					throw new SocSecException("ERROR: your Social Secutiry Number conatins"
							+ "\nunexpected alphabetical "
							+ "or special characters. Please check your "
							+ "response and try again"); 
				}
			}
		}
		return true;
	}
}
