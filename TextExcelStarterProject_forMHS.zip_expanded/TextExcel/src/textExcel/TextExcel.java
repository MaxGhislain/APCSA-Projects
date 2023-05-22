/*
 * Max Ghislain
 * 2/21/2023
 * Main code
 */

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		/*
		 * Scanner
		 * generate spreadsheet
		 * print spreadsheet
		 * loop
		 * 	get command
		 * 	process and run command
		 * 	print result or updated worksheet
		 * until "quit"
		 */
		
		//testing
		
		Scanner input = new Scanner(System.in);
		Spreadsheet spread = new Spreadsheet();
		System.out.println(spread.getGridText());
		String command = input.nextLine();
		
		while(!command.equalsIgnoreCase("quit")) {
			System.out.println(spread.processCommand(command));
			
			command = input.nextLine();
		}
	}
}
