//Haofan Wang
//hwang108

public class King extends ChessPiece{
	public King(int column, int row, char TypePiece) {
		super(column, row, TypePiece);
	}
	public boolean Attack(ChessPiece enemy) {
		if(this.column == enemy.column && this.row == enemy.row)
			return false;
		if(
				Math.abs(this.column - enemy.column) == 1 && this.row == enemy.row ||
				Math.abs(this.row - enemy.row) == 1 && this.column == enemy.column ||
				Math.abs(this.row - enemy.row) == 1 && Math.abs(this.column - enemy.column) == 1) {
			return true;
		}else {
				return false;
		}
	}
}
