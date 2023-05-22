import java.util.Arrays;

/*
 * Max Ghislain
 * Nov. 1, 2022
 * Practice Using the split method from String Class
 */

public class Split {
	public static void main(String[] args) {

// Your task Part 0

//String.split();

//It's a method that acts on a string, <StringName>.split(<sp>);

//Where sp is the string where the string splits

//And it returns an array
		String[] ex1 = "I like apples!".split(" ");
		//System.out.println(Arrays.toString(ex1));

// it will split at spaces and return an array of ["I","like","apples!"]

// Example 2: "I really like really red apples!".split("really")
		String[] ex2 = "I really like really red apples!".split("really");
		//System.out.println(Arrays.toString(ex2));

// it will split at the word "really" and return an array of ["I "," like ","red apples!"]

//play around with String.split!

//What happens if you "I reallyreally likeapples".split("really") ?
		String[] ex2a = "I reallyreally likeapples!".split("really");
		//System.out.println(Arrays.toString(ex2a));

//Your task Part 1:

/*Write a method that take in a string like

* "applespineapplesbreadlettucetomatobaconmayohambreadcheese"

* describing a sandwich.

* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of

* the sandwich and ignores what's on the outside

* What if it's a fancy sandwich with multiple pieces of bread?

*/
		
//		String str = "applespineapplesbreadlettucetomatobaconmayohambreadcheese";
//		System.out.println(getFilling(str));
		
		//Part 1 Tests:
		System.out.println(getFilling("applespineapplesbreadmayohambreadcheese"));
	    System.out.println(getFilling("breadmayobread"));
	    System.out.println(getFilling("applesbreadmayobread"));
	    System.out.println(getFilling("breadhambreadcheese"));
	    System.out.println(getFilling("breadbread"));
	    System.out.println(getFilling("breadcheese"));
	    System.out.println(getFilling("hamcheesebread"));
	    System.out.println(getFilling("cheese"));
	    System.out.println(getFilling("breadcheesebreadhambread"));
	    System.out.println(getFilling("hambreadmayobaconbreadavocadobread"));
	    
	    //Part 2 Tests
	    System.out.println(getFilling2("apples bread mayo bread"));
	    System.out.println(getFilling2("bread ham bread cheese"));
	    System.out.println(getFilling2("bread bread"));
	    System.out.println(getFilling2("bread cheese"));
	    System.out.println(getFilling2("ham bread mayo bacon bread avocado bread"));
	}
		
	public static String getFilling(String str) {
		int breadIndex = str.indexOf("bread");
		int startIndex = breadIndex;
		int endIndex = 0;
		while(breadIndex!=-1) {
			endIndex = breadIndex;
			breadIndex = str.indexOf("bread", breadIndex+1);
		}
		if(startIndex == -1 || endIndex == -1)
			return "No Sandwich";
		String substring = str.substring(startIndex, endIndex+"bread".length());
		
		//System.out.println("substring: " +substring);
		
		int numBread = substring.split("bread", -1).length-1;
		
		if(numBread<2)
			return "No Sandwich";
		else {
			return substring.substring("bread".length(),substring.length()-"bread".length());
		}
	}
		
		
		

//Your task pt 2:

/*Write a method that take in a string like

* "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"

* describing a sandwich

* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of

* the sandwich and ignores what's on the outside.

*The output for the example above should be lettucetomatobaconmayoham

* You should call the method from part one in order to increase your reuse of code and reduce

*the complexity of part 2.

*/
	
	
	public static String getFilling2(String str) {
		String[] parts = getFilling(str).split(" ");
		String output = "";
		for(String part : parts)
			output+=part;
		
		return output;
	}
}