public class Quadratic {
	
	public static String quadrDescriber (double a, double b, double c) {
		String formula = a+" x^2 + " + b+" x + " +c;
		String description = "Description of the graph of: \n" + formula + "\n";
		
		
		String opens = "Opens: ";
		if(a>0)
			opens += "Up";
		else if(a<0)
			opens += "Down";
		else
			opens += "Line";
		
		String axis = "Axis of Symmetry: ";
		
		
		double xv = (-1*b)/(2*a);
		if(xv==0) //so there is no -0
			xv=0;
		
		double yv = a*xv*xv+b*xv+c;
		
		axis+=xv;
		
		String vertex = "vertex: " + "("+xv + ", " + yv+")";
		
		
		String xint = "x-intercepts(s): " + quadForm(a, b, c);
		
		String yint = "y-intercept: " + c; //a*(0)^2 + b(0) + c = c
		
		return description+"\n" + opens+"\n" + axis+"\n" + vertex+"\n" + xint+"\n" + yint+"\n";
	}
	/*
	 * quadForm();
	 * discriminant();
	 * sqrt();
	 * round2();
	 * min();	
	 * max();
	 */
	
	public static String quadForm(double a, double b, double c) {  // Finds the roots of a quadratic equation
		double discriminant = discriminant(a, b, c);
		if(discriminant<0) {
				return ("no real roots");
		}
		
		double formPlus = (-b + sqrt(discriminant))/(2*a); // pos ver of quadratic formula
		double formMinus = (-b - sqrt(discriminant))/(2*a); // neg ver of quadratic formula
		
		if(formPlus == formMinus) {
			return round2(formPlus) + "";
		}
		
		return (round2(min(formPlus, formMinus)) + ", " + round2(max(formPlus, formMinus))); // return the rounded min and max roots
	}
	
	public static double discriminant(double a, double b, double c) { // returns the discriminant from the inputed equation
		return(b*b-4*a*c); // discriminant expression from quadratic formula
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
	
	public static double absValue(double num) { //Returns the positive version of a number
		if(num < 0) {
			return num*-1;
		}
		return num;
	}
	
	public static double min(double a, double b) { // Returns the smallest number of the two double ver
		if(a<b) {
			return a;
		}
		return b;
	}
	
	public static double max(double a, double b) { //Returns the greater number of the two inputed
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
}
