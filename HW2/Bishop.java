//Haofan Wang
//hwang108

public class Bishop extends ChessPiece{
	public Bishop(int column, int row, char TypePiece) {
		super(column, row, TypePiece);
	}
	public boolean Attack(ChessPiece enemy) {
		if(this.column == enemy.column && this.row == enemy.row)
			return false;
		if(Math.abs(this.column - enemy.column) ==  Math.abs(this.row - enemy.row))
			return true;
		else
			return false;
	}

}
