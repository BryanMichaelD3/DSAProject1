import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class DSAProject1 
{	
	public static void main(String[] args)
	{		
		List<AreaCode> areaCodeList = new LinkedList<>();	// A linked list of all the area codes
		
		// Open input file from same directory as .jar file
		String inputFile = "./names.csv";					// String of the location of the input file
		boolean continueProgram = true;						// Boolean telling whether program should continue or not
		List<String> fileContents = new ArrayList<>();		// Array list holding each line of the input file
		
		try 
		{
			// Store file contents in an array
			BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));	// A file reader that takes an input file as a parameter
			String fileLine = "";														// String of the current line of the file being read
			boolean fileEnd = false;													// Boolean telling the program that it has reached the file's end
			
			while(fileEnd != true)
			{
				fileLine = fileReader.readLine();
				
				if(fileLine != null)
				{
					fileContents.add(fileLine);
				}
				
				else
				{
					fileEnd = true;
				}
			}
			
			fileReader.close();
		} catch (IOException e) 
		{
			System.out.println("File read failed. Exiting program...");
			continueProgram = false;
		}
		
		// If file input worked correctly...
		if(continueProgram)
		{		
			// Add the file contents to a linked list of linked lists
			areaCodeList = ReverseLookup.createList(fileContents);
		}
		
		// While user wants to search for a number in the phone book...	
		Scanner scan = new Scanner(System.in);
		
		while(continueProgram)
		{
			// Ask user for number to look up
			String userInput = "";
			
			System.out.println("Enter the number you would like to look up.");
			System.out.println("Format: 000-0000");
			System.out.println("Enter in 'Q' to quit.");
			System.out.print(">> ");
			userInput = scan.nextLine();
			System.out.println();
			
			if(userInput.equalsIgnoreCase("Q"))
			{
				continueProgram = false;
				System.out.println("Thank you for using this program. Have a nice day!\n");
			}
			
			else
			{
				// Search for that number in linked lists; return all names associated with that number
				List<String> results = ReverseLookup.lookUp(userInput, areaCodeList);
				
				// Print out results of search
				if(results.size() > 0)
				{
					System.out.println("Results of search: ");
					
					for(int i = 0; i < results.size(); i++)
					{
						System.out.println("  " + results.get(i));
					}
					
					System.out.println();
				}
				
				else
				{
					System.out.println("No results found.\n");
				}
			}
		}
		
		scan.close();
	}
}