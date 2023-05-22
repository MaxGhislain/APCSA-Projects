package textExcel;

public class PercentCell extends RealCell {

	public PercentCell(String value) {
		// TODO Auto-generated constructor stub
		super(value.replace("%", ""));
	}

	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String percent = String.valueOf((int) getDoubleValue()) + "%";
		return (percent + "          ").substring(0, 10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return String.valueOf(this.getDoubleValue()/100);
	}
	
}
