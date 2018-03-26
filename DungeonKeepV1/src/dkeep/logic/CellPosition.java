package dkeep.logic;



public class CellPosition {

	private int i, j;
	
	public CellPosition(int j, int i) 
	{
		this.i = i;
		this.j = j;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CellPosition)) {
			return false;
		}
		CellPosition other = (CellPosition) obj;
		if (i != other.i) {
			return false;
		}
		if (j != other.j) {
			return false;
		}
		return true;
	}

	

}
