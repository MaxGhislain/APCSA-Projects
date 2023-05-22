/*
 * Max Ghislain
 * Hourglass code - Prints a hourglass
 * 10/13/2022
 */

public class Hourglass {
	public static void main(String[] args) {
		/*System.out.println("|””””””””””|\r\n"
				+ " \\::::::::/\r\n"
				+ "  \\::::::/\r\n"
				+ "   \\::::/\r\n"
				+ "    \\::/\r\n"
				+ "     ||\r\n"
				+ "    /::\\\r\n"
				+ "   /::::\\\r\n"
				+ "  /::::::\\\r\n"
				+ " /::::::::\\\r\n"
				+ "|””””””””””|\r\n"
				+ "");
		*/
		
		int size = 420;
		String output = base(size) + topBody(size) + neck(size) + bottomBody(size) + base(size);
	
		System.out.println(output);
	}
	
	public static String base(int size) {
		String output = "|";
		for(int i=0; i<size*2;i++) {
			output+="\"";
		}
		output += "\"\"|" + "\n";
		return output;
	}
	
	public static String topBody(int size) {
		String output = "";
		for(int i=size; i>0; i--) {
			for(int j=0; j<size-i+1;j++) {
				output+=" ";
			}
			output += "\\";
			
			for(int k=0; k<i; k++) {
				output += "::";
			}
			output += "/" + "\n";
		}
		return output;
	}

	public static String bottomBody(int size) {
		String output = "";
		for(int i=0;i<size;i++) {
			for(int j=0; j<size-i;j++) {
				output += " ";
			}
			output += "/";
			
			for(int k=0; k<i+1; k++) {
				output += "::";
			}
			output += "\\" + "\n";
		}
 		return output;
	}

	public static String neck(int size) {
		String output = "";
		for(int i=0; i<size+1; i++) {
			output += " ";
		}
		
		output += "||";
		return output + "\n";
	}
}
