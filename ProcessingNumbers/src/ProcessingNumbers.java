import java.util.Scanner;

public class ProcessingNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean firstIteration = true;
		int num = 0;
		
		int smallestNum = 0;
		int largestNum = 0;
		
		int evenSum = 0;
		int largestEven = 0;
		
		while(true) {
			System.out.print("num (type quit if quit): ");
			try {
				num = input.nextInt();
			} catch (java.util.InputMismatchException e) {
				break;
			}
			System.out.println("num: " + num);
			
			if(firstIteration) {
				smallestNum = num;
				largestNum = num;
				
				if(num%2 == 0) {
					largestEven = num;
				}
				
				firstIteration = false;
			}
			
			if(num < smallestNum)
				smallestNum = num;
			if(num > largestNum)
				largestNum = num;
			
			if(num%2 == 0) {
				evenSum += num;
				if(num > largestEven)
					largestEven = num;
			}
		}
		
		input.close();
		
		System.out.println("Smallest Num: " + smallestNum);
		System.out.println("Largest Num: " + largestNum);
		System.out.println("Even Sum: " + evenSum);
		System.out.println("Largest Even: " + largestEven);
	}
}
