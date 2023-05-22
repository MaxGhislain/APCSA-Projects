package textExcel;

import java.util.Arrays;

import com.sun.tools.javac.Main;

public class FormulaCell extends RealCell {
	private Spreadsheet spread;

	public FormulaCell(String value, Spreadsheet spread) {
		// TODO Auto-generated constructor stub
		super(value);
		this.spread = spread;
	}
	
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return (this.getDoubleValue() + "          ").substring(0, 10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return super.fullCellText();
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}
	
	/*
	public static boolean isLoc(String str) {
		System.out.println(str);
		try {
		if(str.charAt(0) >= 65 && str.charAt(0)<=90 && Integer.parseInt(str.substring(1))>=1 && Integer.parseInt(str.substring(1))<=20) {
			System.out.println("true");
			return true;
		}
		} catch(StringIndexOutOfBoundsException e) {
			System.out.println("false");
		}
		System.out.println("false");
		return false;
	}
	*/
	
	public double getDoubleValue() {
		String expression = super.fullCellText().replace("(", "").replace(")", "").trim().toUpperCase();
		
		String[] split = expression.split(" ");
		//System.out.println(Arrays.toString(split));
		
		double ans = 0;
		
		
		
		// subsitute coordinate cells with their values
		
		for(int i =0; i < split.length; i++) {
			
			if(split[i].matches(".*[a-zA-Z].*") && !split[i].contains("-") && !split[i].equals("AVG") && !split[i].equals("SUM")) { //checks if there is character in string
				//System.out.println(split[i]);
				Location loc = new SpreadsheetLocation(split[i]);
				split[i] = String.valueOf(((RealCell)spread.getCell(loc)).getDoubleValue()); //instanceof
			}
		}
		
		// Check for AVG and SUM operators
		
		
		if(split[0].equalsIgnoreCase("SUM") || split[0].equalsIgnoreCase("AVG")) { // adds all values in bounds together
			String[] bounds = split[1].split("-");
			//System.out.println(Arrays.toString(bounds));
			Location startLoc = new SpreadsheetLocation(bounds[0]);
			Location endLoc = new SpreadsheetLocation(bounds[1]);
			
			int numCells = 0;

			for(int i = startLoc.getCol(); i <= endLoc.getCol(); i++) { // makes like a box between the two corners of points on the spreadsheet
				for(int j = startLoc.getRow(); j <= endLoc.getRow(); j++) {
					
					Location currentLoc = new SpreadsheetLocation(i, j);
					//System.out.println(((SpreadsheetLocation) currentLoc).getFullLoc());
					//System.out.println("i: " + i + ", j: " + j);
					Cell currentCell = spread.getCell(currentLoc);
					
					if(!(currentCell instanceof EmptyCell))
						ans += ((RealCell) currentCell).getDoubleValue();
					
					numCells++;
				}
			}
			
			if(split[0].equalsIgnoreCase("AVG")) { // adds all values in bounds together and divides by their amount
				ans /= numCells;
			}
			
			return ans;
		}
		
		ans = Double.valueOf(split[0]);
		
		for(int i = 0; i < split.length; i++) {
			if(!isNumeric(split[i])) {
				switch(split[i]) {
				//basic operators
				case "+": 
					//add
					//System.out.println("add: " + ans + " + " + split[i+1]);
					ans += Double.valueOf(split[i+1]);
							
					break;
				case "-": 
					//subtract
					//System.out.println("subtract: " + ans + " - " + split[i+1]);
					ans -= Double.valueOf(split[i+1]);
					
					break;
				case "*": 
					//multiply
					//System.out.println("multiply: " + ans + " * " + split[i+1]);
					ans *= Double.valueOf(split[i+1]);
					
					break;
				case "/": 
					//divide
					//System.out.println("divide: " + ans + " / " + split[i+1]);
					ans /= Double.valueOf(split[i+1]);
					
					break;
				}
				
			}
			
		}
			
			
		
		
		return ans;
	}

}
	