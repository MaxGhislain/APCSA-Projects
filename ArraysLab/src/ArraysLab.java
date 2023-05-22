import java.util.Arrays;

/*
 * Max Ghislain
 * 10/25/2022
 * Arrays Lab
 */

public class ArraysLab {

	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		
		int sumOfEvens = sumEven(appendArr);
		//System.out.println("a1" + Arrays.toString(a1));
		//rotateRight(a1);
		
		
		System.out.println("Sum: "+ Arrays.toString(sumArr));
		System.out.println("Append: "+ Arrays.toString(appendArr));
		System.out.println("Remove: "+ Arrays.toString(removeArr));
		System.out.println("Sum of Evens: "+ sumOfEvens);
		System.out.print("a1: "); rotateRight(a1);//Arrays.toString(a1));

	}

	public static int[] sum(int[] arr1, int[] arr2) { // arrays are same length
		int[] output = arr1;
		for(int i=0; i<arr2.length;i++) {
			output[i] += arr2[i];
		}
		
		return output;
	}
	
	public static int[] append(int[] arr, int num) {
		int[] output = new int[arr.length+1];
		for(int i = 0; i<arr.length; i++) {
			output[i] = arr[i];
		}
		output[output.length-1] = num;
		
		return output;
	}
	
	public static int[] remove(int[] arr, int idx) {
		int[] output = new int[arr.length-1];
		for(int i=0; i<output.length; i++) {
			if(i >= idx)
				output[i] = arr[i+1];
			else
				output[i] = arr[i];
		}
		
		return output;
	}
	
	public static int sumEven(int[] arr) {
		int output = 0;
		for(int i=0; i<arr.length; i+=2) {
			output+=arr[i];
		}
		
		return output;
	}
	
	public static void rotateRight(int[] arr) {
		int[] output = new int[arr.length];
		int lastElement = arr[arr.length-1];
		for(int i=0; i<arr.length-1; i++) {
			if(i==arr.length) {
				output[0] = arr[arr.length];
			}
				
			output[i+1] = arr[i];
		}
		output[0] = lastElement;
		System.out.println(Arrays.toString(output));
	}
	
	
}
