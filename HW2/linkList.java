

public class linkList {
	public Node firstLink;
	public Node in;
	
	// Constructor
	public linkList() {
		firstLink = null;
		in = null;
	}
	// debug
	public void traverse() {
		Node newLink = firstLink;
		while(newLink != null) {
			newLink = newLink.next;
		}
	}
	public boolean Validity() {
		Node newLink = firstLink;
		int whiteKing = 0;
		int blackKing = 0;
		while(newLink != null) {
			if(newLink.piece.Type == 'K') 
				blackKing =+ 1;
			if(newLink.piece.Type == 'k') 
				whiteKing =+ 1;
			newLink = newLink.next;
		}
			if(blackKing == 1 && whiteKing == 1) {
				return true;
			}
			return false;	
	}
	public void add(ChessPiece newPiece) {
		Node lastest = new Node(newPiece);
		lastest.next = firstLink;
		firstLink = lastest;
		
	}
	public boolean occupy(int x, int y) {
		Node newLink = firstLink;
		while(newLink != null) {
			if(newLink.piece.column == x && newLink.piece.row == y) {
				return true;
			}
			newLink = newLink.next;
		}
		return false;
	}
	public String find(int queryX, int queryY) {
		Node newLink = firstLink;
		while(newLink != null) {
			if(newLink.piece.column == queryX && newLink.piece.row == queryY) {
				in = newLink;
				return(newLink.piece.Type + " ");
			}
			newLink = newLink.next;
		}
				return ("-");
	}
	public char isAttack(int queryX, int queryY) {
		Node newLink = firstLink;
		while(newLink != null) {
			if(Character.isUpperCase(newLink.piece.Type) && Character.isLowerCase(in.piece.Type) ||
				Character.isLowerCase(newLink.piece.Type) && Character.isUpperCase(in.piece.Type)) {
				if(in.piece.Attack(newLink.piece)) {
					return 'y';
		}
	}
			newLink = newLink.next;
}
		return 'n';
}
}

