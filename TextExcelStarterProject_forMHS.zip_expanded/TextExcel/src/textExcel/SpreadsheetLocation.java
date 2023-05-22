package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int column;
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return column;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	cellName = cellName.toUpperCase();
    	this.row = Integer.parseInt(cellName.substring(1))-1; // from 1 based indexing to 0 based indexing
    	this.column = (int)cellName.charAt(0)-65; // shift to 0 based indexing using ascii character values, A = 65. A-65 = 0
    	
    	//System.out.println(row + "," + column);
    }
    
    public SpreadsheetLocation(int i, int j) {
    	this.column = i;
    	this.row = j;
    }
    
    public String getFullLoc() {
    	return "" + (char)(column+65) + (row+1);
    }

}
