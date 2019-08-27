//Haofan Wang
//hwang108

public class Rook extends ChessPiece{
	public Rook(int column, int row, char TypePiece) {
		super(column, row, TypePiece);
	}
	public boolean Attack(ChessPiece enemy) {
		if(this.column == enemy.column && this.row == enemy.row)
			return false;
		if(this.column == enemy.column || this.row == enemy.row)
			return true;
		else
			return false;
	}
}
