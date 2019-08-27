//Haofan Wang
//hwang108

public class ChessPiece {
	public int column, row;
	public char Type;
	
	public ChessPiece(int C, int R, char TypePiece) {
		column = C;
		row = R;
		Type = TypePiece;
	}
	public boolean Attack(ChessPiece enemy) {
		return false;
	}
}

