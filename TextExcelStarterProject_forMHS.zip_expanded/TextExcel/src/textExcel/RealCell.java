package textExcel;

public class RealCell implements Cell {
	private String value;

	public RealCell(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return (this.getDoubleValue() + "          ").substring(0, 10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public double getDoubleValue() {
		return Double.valueOf(value);
	}

}
