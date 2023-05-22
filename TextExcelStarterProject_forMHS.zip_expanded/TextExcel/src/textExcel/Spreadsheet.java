/*
 * Max Ghislain
 * 2/21/2023
 * Defines the spreadsheet class
 */

package textExcel;

import java.util.Arrays;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cellArray = new Cell[this.getRows()][this.getCols()];
	
	public Spreadsheet() {
		for(Cell[] column : cellArray) {
			for(int i=0; i<column.length;i++) {
				column[i] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		String[] split = command.split(" ", 3); // limit to 3 elements in the split list array ye
		
		//System.out.println(Arrays.toString(split));
		if(split.length == 1) {
			split[0] = split[0].toUpperCase();
			
			if(split[0].equals("CLEAR"))
				return clearSheet();
			else
				return cellInspect(split[0]);
		}
		
		if(split.length == 2) {
			for(int i=0; i<split.length; i++) {
				split[i] = split[i].toUpperCase();
			}
			
			if(split[0].equalsIgnoreCase("CLEAR"))
				return clearCell(split[1]);
		}
		
		if(split[1].equals("=")) {
			split[0] = split[0].toUpperCase();
			//split[2] = split[2].replace("\"", "");
			Location loc = new SpreadsheetLocation(split[0]);
			
			if(split[2].endsWith("%")) {
				this.cellArray[loc.getRow()][loc.getCol()] = new PercentCell(split[2]);
			}
			
			if(split[2].startsWith("(")) {
				this.cellArray[loc.getRow()][loc.getCol()] = new FormulaCell(split[2], this);
			}
			
			if(split[2].startsWith("\"")) {
				this.cellArray[loc.getRow()][loc.getCol()] = new TextCell(split[2]);
			}
			
			if(isNumeric(split[2])) {
				this.cellArray[loc.getRow()][loc.getCol()] = new ValueCell(split[2]);
			}
			
			
			
			return getGridText();
		}
		
		
		
		//cell inspection
		
		//string value assignment
		
		//clear sheet
		
		//clear cell
		
		return "";
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}


	public String cellInspect(String coord) {
		Location loc = new SpreadsheetLocation(coord);
		return getCell(loc).fullCellText();
	}
	
	public String setCell(Location loc, String s) { //cell assign
		
		
		return getGridText();
	}
	
	public String clearSheet() {
		for(Cell[] column : cellArray) {
			for(int i=0; i<column.length;i++) {
				column[i] = new EmptyCell();
			}
		}
		
		return getGridText();
	}
	
	public String clearCell(String coord) {
		Location loc = new SpreadsheetLocation(coord);
		this.cellArray[loc.getRow()][loc.getCol()] = new EmptyCell();
		
		return getGridText();
	}
	
	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return this.cellArray[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		String output = "";
		String columnheader = "   |";
		
		for(int i=0; i<getCols(); i++) {
			Cell header = new TextCell(String.valueOf((char)(int)(i+65))); // change to char here
			columnheader += header.abbreviatedCellText() + "|";
		}
		output += columnheader + "\n";
		
		for(int i=0; i<getRows(); i++) {
			String row = "";
			row += (i+1) + "   ".substring(Integer.toString(i+1).length()) + "|";
			
			for(int j=0; j<getCols(); j++) {
				Cell cell = cellArray[i][j];
				row += cell.abbreviatedCellText() + "|";
			}
			
			output += row + "\n";
		}
		
		return output;
	}

}
