/*
 * @author Max Ghislain
 * @version August 25,2022
 * 
 * Library of math methods
 */
public class Calculate {
	//Part 1
	public static int square(int n) { //returns square of input
		return(n*n); // multiplies the number twice
	}
	
	public static int cube(int n) { //returns cube of input
		return(n*n*n); // multiplies the number thrice
	}
	
	public static double average(double n, double m) { // returns average of two inputs
		return((n+m)/2); // adds the two numbers together and divides it by 2
	}
	
	public static double average(double n, double m, double o) { // returns the average of three inputs
		return((n+m+o)/3); // adds the three numbers together and divides it by 3
	}
	
	public static double toDegrees(double radians) { // returns radians as degrees
		return(radians * 180/3.14159); //pi radians = 180 degrees, 1 radian = 180/pi degrees (conversion factor)
	}
	
	public static double toRadians(double degrees) { // returns the conversion from degrees to radians
		return(degrees * 3.14159/180); // multiplies degrees by the conversion factor to get radians
	}
	
	public static double discriminant(double a, double b, double c) { // returns the discriminant from the inputed equation
		return(b*b-4*a*c); // discriminant expression from quadratic formula
	}
	
	public static String toImproperFrac(int wholeNum, int numerator, int denominator) { // Returns an improper fraction from the proper fraction format
		
		return(wholeNum * denominator+numerator+"/"+ denominator); // multiplies the whole number with the denominator and adds it with the numerator to get the new numerator, then appends it into a string with the denominator 
	}
	
	public static String toMixedNum(int numerator, int denominator) { // Returns the proper fraction from an improper fraction
		int remainder = numerator % denominator; // Finds the whole number by finding how many of the denominator can fit into the numerator
		if(remainder == 0) {
			return(numerator+"/"+denominator);
		}
		int wholeNumber = (numerator-remainder)/denominator;
		
		return(wholeNumber+"_"+remainder+"/"+denominator);
	}
	
	public static String foil(int a, int b, int c, int d, String var) { // Returns the expansion of a factored quadratic
		/*
		 * (ax+b)(cx+d) => ax^2+bx+c
		 * = ax*cx + ax*d + b*cx + b*d
		 * = a*c*(x^2) + (a*d+b*c)*(x) + b*d  // expanded form from foil to standard form
		 * 
		 */
		
		return(a*c+var+"^2 + "+(a*d+b*c)+var+" + " + b*d);
	}
	
	//Part 2
	public static boolean isDivisibleBy(int a, int b) { // Checks if a number is divisible
		if(a%b == 0) { //If there is no remainder while dividing
			return true;
		}
		return false;
	}
	
	public static double absValue(double num) { //Returns the positive version of a number
		if(num < 0) {
			return num*-1;
		}
		return num;
	}
	
	public static int absValue(int num) { //Returns the positive version of a number
		if(num < 0) {
			return num*-1;
		}
		return num;
	}
	
	public static double max(double a, double b) { //Returns the greater number of the two inputed
		if(a>b) {
			return a;
		}
		return b;
	}
	
	public static int max(int a, int b) { //Returns the greater number of the two inputed int ver
		if(a>b) {
			return a;
		}
		return b;
	}
	
	public static double max(double a, double b, double c) { //Returns the greater number of the three inputed
		if(a>b) {
			if(a>c) {
				return a;
			} else {
				return c;
			}
		} else if(b>c) {
			return b;
		} else {
			return c;
		}
	}
	
	public static int min(int a, int b) { // Returns the smallest number of the two
		if(a<b) {
			return a;
		}
		return b;
	}
	
	public static double min(double a, double b) { // Returns the smallest number of the two double ver
		if(a<b) {
			return a;
		}
		return b;
	}
	
	public static double round2(double a) { // Returns the rounded version of a number to two decimal places
		int neg = 1;
		if(a<0) {
			a*=-1;
			neg = -1;
		}
		int intNum = (int)(a*100); //converts the input into an int and multiplies it by 100
		//System.out.println("int" + intNum);
		double doubleNum = a*100; //multiplies the input by 100
		double decimal = doubleNum-intNum; //finds the decimal places of the input
		//System.out.println("decimal" + decimal);
		if(decimal>=0.5) { // if the decimal is greater than 0.5
			return neg*(double)(intNum+1)/100; // return with decimal +1
		}
		return neg*(double)intNum/100; // else return the rounded number
		// 1.11 -> 111, 1.116 -> 111.6 = 
		//(double)((int)(a*100))/100;
	}
	
	//Part 3
	public static double exponent(double x, int n) { // Returns the exponent of the inputed numbers 
		if(n==0 && x==0)
			return (Double) null;
		if(n==0)
			return 1;
		if(x==0)
			return 0;
		double ans=x;
		while(n>1) { // while the exponent is greater than 1
			ans*=x; // multiply the number by itself
			n--; // decrement the exponent by 1
		}
		return ans; // return number
	}
	
	public static int factorial(int n) { // Returns the factorial of a number
		int ans = n; // create ans variable
		while(n>1) { // while the num is greater than 1
			ans*=(n-1); // multiply the ans with the number -1
			n--; // decrement the number
		}
		return ans;
	}
	
	public static boolean isPrime(int n) { // Returns whether a number is prime
		/*
		if(n>1) {
			//n%2, n%3, n%5
			for(int i=2;i!=n;i++) {
				for(int j=2;j!=n;j++) {
					if(i*j==n) {
						return true;
					}
				}
			}
		}
		*/
		
		if(n>1) {
			for(int i=2; i<n;i++) { //finds all possible factors for int n
				if(n%i==0) { // if there is a factor return true
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static int gcf(int n, int m) { // Returns the greatest common factor of two numbers
		n = absValue(n); // makes both nums positive
		m = absValue(m);
		int gcf = 1;
		int lesserNum = min(n, m);
		
		if(n>1 && m>1) {
			for(int i=1; i<lesserNum+1; i++) {
				if(n%i == 0 && m%i == 0) { // if the numbers both factor with i
					gcf = i;
				}
			}
		}
		
		if(n==0)
			gcf=m;
		if(m==0)
			gcf=n;
		
		return gcf;
	}
	
	public static double sqrt(double n /*original num*/) { //Takes the square root of int n using a, a guessing variable
		//guess
		double a=n;
		//square root func formula
		double sqrtFormula = (0.5)*(((n/a) + a)); //0.5*(4/4+4) = 0.5(1+4)=2.5
		
		while(absValue(sqrtFormula*sqrtFormula-n)>0.005) { //difference between original input and result squared is less than 0.5
			a=sqrtFormula;
			sqrtFormula = (0.5)*(((n/a) + a));
		}
		
		return round2(sqrtFormula);
	}
	
	// Part 4
	public static String quadForm(int a, int b, int c) {  // Finds the roots of a quadratic equation
		double discriminant = Calculate.discriminant(a, b, c);
		if(discriminant<0) {
				return ("no real roots");
		}
		
		double formPlus = (-b + sqrt(discriminant))/(2*a); // pos ver of quadratic formula
		double formMinus = (-b - sqrt(discriminant))/(2*a); // neg ver of quadratic formula
		
		if(formPlus == formMinus) {
			return round2(formPlus) + "";
		}
		
		return (round2(Calculate.min(formPlus, formMinus)) + ", " + round2(Calculate.max(formPlus, formMinus))); // return the rounded min and max roots
	}
	
	
	// Part 5
	
}
