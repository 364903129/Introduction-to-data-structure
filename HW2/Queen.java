//Haofan Wang
//hwang108

public class Queen extends ChessPiece{
	public Queen(int column, int row, char TypePiece) {
		super(column, row, TypePiece);
	}
	public boolean Attack(ChessPiece enemy) {
		if(this.column == enemy.column && this.row == enemy.row)
			return false;
		if(this.column == enemy.column ||
				this.row == enemy.row || 
				Math.abs(this.column - enemy.column) == 1 && Math.abs(this.row - enemy.row) == 1)
			return true;
		else
			return false;
	}
}
