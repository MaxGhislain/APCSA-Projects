import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListPracticeLab 
{
	// printMe is just a quick tool to check your work.  Use it in conjunction with the test cases in main
	public static void printMe(ArrayList<String> theList)
	{
		for (String str : theList)
			System.out.print(str + ", ");
			// I know, it prints an extra comma... live with it.  
		System.out.println();
		
	}
	
	/* 
	 * convertArrayToList
	 * 
	 * Write a method called convertArrayToList that accepts one parameter, an array of Strings, and returns 
	 * an ArrayList containing those Strings
	 */
	
	public static ArrayList<String> convertArrayToList(String[] array) {
		ArrayList<String> output = new ArrayList<String>();
		for(String s : array)
			output.add(s);
		
		return output;
	}
	
	
	/*
	 * maxLength
	 * 
	 * Write a method maxLength that accepts one parameter, an ArrayList of Strings, and 
	 * returns an int, the length of the longest string in the list. If your method is passed an 
	 * empty list, it should return 0.
	 */
	
	public static int maxLength(ArrayList<String> list) {
		int m = 0;
		for(String s : list) {
			if(s.length()>m)
				m=s.length();
		}
		
		return m;
	}
	
	
	
	/*
	 * swapPairs
	 * 
	 *  Write a method named swapPairs that switches the order of values in an ArrayList of Strings
	 *  in a pairwise fashion. Your method should switch the order of the first two values, 
	 *  then switch the order of the next two, switch the order of the next two, and so on.  
	 *  swapPairs accepts one parameter, an ArrayList of Strings, and returns an ArrayList of Strings.
	 *  swapPairs should not change the input ArrayList.
	 *  
	 *  For example, if the input list stores these values: {"four", "score", "and", "seven", "years", "ago"}
	 *   your method should switch the first pair, "four", "score", the second pair, "and", "seven", 
	 *   and the third pair, "years", "ago", and the returned list should contain: {"score", "four", "seven", "and", "ago", "years"}
	 *   
	 *  If there are an odd number of values in the input list, the final element is not moved. 
	 *  For example, if the input list is: {"to", "be", "or", "not", "to", "be", "hamlet"} 
	 *  The returned list should contain {"be", "to", "not", "or", "be", "to", "hamlet"}
	 */
	
	public static ArrayList<String> swapPairs(ArrayList<String> list) {
		ArrayList<String> output = new ArrayList<>(list);
		for(int i=0; i<=output.size()-1; i+=2) { // word size = 4, max i = 3
			if(!(i+1>output.size()-1)) {
				String word1 = output.get(i);
				String word2 = output.get(i+1);
				
				output.set(i, word2);
				output.set(i+1, word1);
			}
		}
		
		return list;
	}
	
	
	
	/*
	 * removeEvenLength
	 * 
	 * Write a method named removeEvenLength that accepts one parameter, an ArrayList of Strings, 
	 * and returns an ArrayList of Strings.
	 * The ArrayList returned by removeEvenLength contains all elements from the input parameter minus
	 * any Strings of even length.
	 * removeEvenLength should not change the input ArrayList.
	 */
	
	public static ArrayList<String> removeEvenLength(ArrayList<String> list) {
		ArrayList<String> newList = new ArrayList<>(list);
		for(int i=0; i<newList.size();i++) {
			if(newList.get(i).length()%2==0) {
				newList.remove(i);
				i--;
			}
		}
		
		return newList;
	}
	
	
	
	/*
	 * doubleList
	 * 
	 * Write a method named doubleList that accepts one parameter, an ArrayList of Strings, and does not return anything.
	 * For each element in the input ArrayList, doubleList creates another element containing that same String. 
	 * 
	 * For example, if the input ArrayList contains the values {"how", "are", "you?"} before the method 
	 * is called, it should contain the values {"how", "how", "are", "are", "you?", "you?"} 
	 * after the method finishes executing.
	 */
	
	public static void doubleList(ArrayList<String> list) {
		for(int i=0; i<list.size(); i+=2) {
			list.add(i+1, list.get(i));
		}
		
		printMe(list);
	}
	
	
	
	public static void main(String[] args) 
	{
		// Declare an ArrayList of String named myList.  Then fill it with: "this", "is", "it".  Print myList using printMe().
		ArrayList<String> myList = new ArrayList<String>(Arrays.asList("this", "is", "it"));
		
		printMe(myList);
		
		
		
		

		// To test your maxLength method, convert the following to ArrayLists of Strings and 
		// pass them into your maxLength method.  (You'll want to complete the convertArrayToList method first.)
		// Expected output:  6, 27, 0
		String[] test_max_1 = {"to", "be", "or", "not", "to", "be", "hamlet"};  
		String[] test_max_2 = {"Only one really long string"};
		String[] test_max_3 = {};
		
		System.out.println( maxLength( convertArrayToList(test_max_1) ) );
		System.out.println( maxLength( convertArrayToList(test_max_2) ) );
		System.out.println( maxLength( convertArrayToList(test_max_3) ) );
		
		
		
		// To test your swapPairs method, convert the following to ArrayLists of Strings and 
		// pass them into your swapPairs method.  
		// Expected output:  
		//    score, four, seven, and, ago, years
		//    love, I, programming!
		//    don't move me
		//    <blank>
		String[] test_swap_1 = {"four", "score", "and", "seven", "years", "ago"};
		String[] test_swap_2 = {"I", "love", "programming!"};
		String[] test_swap_3 = {"don't move me"};
		String[] test_swap_4 = {};

		System.out.println(swapPairs(convertArrayToList(test_swap_1)));
		System.out.println(swapPairs(convertArrayToList(test_swap_2)));
		System.out.println(swapPairs(convertArrayToList(test_swap_3)));
		System.out.println(swapPairs(convertArrayToList(test_swap_4)));
		

		// To test your removeEvenLength method, convert the following to ArrayLists of Strings and 
		// pass them into your removeEvenLength method.  
		// Expected output:  
		//    a
		//    Did, you, solve, what?
		//    <blank>
		String[] test_rem_1 = {"This", "is", "a", "test"};
		String[] test_rem_2 = {"Did", "you", "solve", "it", "or", "what?"};
		String[] test_rem_3 = {};
				
		System.out.println(removeEvenLength(convertArrayToList(test_rem_1)));
		System.out.println(removeEvenLength(convertArrayToList(test_rem_2)));
		System.out.println(removeEvenLength(convertArrayToList(test_rem_3)));
		
		
		// To test your doubleList method, convert the following to ArrayLists of Strings and 
		// pass them into your doubleList method.  
		// Expected output:  
		//    [how, how, are, are, you?, you?]
		//    [One string only, One string only]
		//    <blank>
		String[] test_doub_1 = {"how", "are", "you?"};
		String[] test_doub_2 = {"One string only"};		
		String[] test_doub_3 = {};		
		
		doubleList(convertArrayToList(test_doub_1));
		doubleList(convertArrayToList(test_doub_2));
		doubleList(convertArrayToList(test_doub_3));
		
	}
		
		


}
