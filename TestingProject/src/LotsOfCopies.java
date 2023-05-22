import java.util.Arrays;

public class LotsOfCopies {

	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		
		changeMe(num, strMain, arrMain);
		System.out.println("num: " + num);
		System.out.println("strMain: " + strMain);
		System.out.println("arrMain: " + Arrays.toString(arrMain));
		
	}
	
	public static void changeMe(int x, String str, int[] arr) {
		x*=x;
		str=str+" is great";
		arr[0] = 7;
	}

}
