/*
 *  @author Max Ghislain
 *  @version 9/22/2022
 *  
 *  Client code -- gets input from user with is snet to quadratic class with is then prompted to the user.
 */

import java.util.Scanner;

public class QuadraticClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		while(run) {
			Scanner input = new Scanner (System.in);
			
			//Greeting
			System.out.println("Welcome to Quadratic Describer\nProvide values for coefficients a, b, and c");
			
			//get input
			System.out.print("a: ");
			double a = input.nextDouble();
			
			System.out.print("b: ");
			double b = input.nextDouble();
			
			System.out.print("c: ");
			double c = input.nextDouble();
			
			//call quadrDescriber
			String description = Quadratic.quadrDescriber(a, b, c);
			
			//Print Results
			System.out.println(description);
			
			//Check for exit
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			String quit = input.next();
			if(quit.equals("quit")) run = false;
		}
	}

}
