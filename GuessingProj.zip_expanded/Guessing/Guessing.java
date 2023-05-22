import java.util.*;

public class Guessing 
{

	public static int getRandomNumber(int low, int high)
	{
		// Math.random() returns a decimal in the range [0, 1)
		// Pick a low and high value and test this out.  Can the 
		// computer choose the low and high bounds as its number?
		int rand = (int) (Math.random() * (high - low + 1)) + low;
		return rand;
	}
	
	public static String compareToSecret(int guessedNum, int secretNum)
	{
		String guessIs = "";
		if (guessedNum < secretNum)
			guessIs = "low";
		else
			guessIs = "high";
		return guessIs;
	}
	
	public static boolean inRange(int low, int high, int num)
	{
		if (low <= num && num <= high)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner (System.in);
		
		System.out.println("Name: ");
		String name = input.nextLine();
		System.out.println("Hi "+name);
		
		System.out.print("Lower bound: ");
		int lowest = input.nextInt();
		
		System.out.print("Upper bound: ");
		int highest = input.nextInt();
		
		while(lowest>highest) {
			System.out.println("The lower bound has to be lower than the upper bound.");
			
			System.out.print("Lower bound: ");
			lowest = input.nextInt();
			
			System.out.print("Upper bound: ");
			highest = input.nextInt();
		}
		
		int secret = getRandomNumber(lowest, highest);
		
		System.out.println("Guess: ");
		int guess = input.nextInt();
		
		while(secret!=guess) {
			String lowHigh = compareToSecret(guess, secret);
			System.out.println("Nope. " + guess + " is too " + lowHigh);
			System.out.println("Guess again!");
			
			System.out.println("Guess: ");
			guess = input.nextInt();			
		}
		
		System.out.println("You guessed right!");
		System.out.println("My number was " + secret + "!");
		
		input.close();
	}

}
