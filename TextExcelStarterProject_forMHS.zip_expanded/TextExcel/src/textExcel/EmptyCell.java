/*
 * Max Ghislain
 * 2/23/2023
 * Empty Cell Code
 */

package textExcel;

public class EmptyCell implements Cell {
	public EmptyCell() {
		
	}
	
	@Override
	public String abbreviatedCellText() {
		return "          ";
	}

	@Override
	public String fullCellText() {
		return "";
		//return "\"\"";
	}

}
