//ChessBoard.java
//Haofan Wang
//hwang108
//HW2
//Determine validity, find piece, discover an attack on 8*8 chessboard

import java.io.*;
import java.util.*;

public class ChessBoard {
	
	public static int queryX;
	public static int queryY;
	
	public static void main(String [] args) throws IOException{
		// open files
		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));
		
		//read lines from in, extract and print tokens from each line
		while(in.hasNextLine()) {
			
		// trim leading and trailing spaces, then add one trailing spaces so split works on blank lines
			String line = in.nextLine().trim() + " ";
			int count = 0;
			
		//  split line around white space
			String[] token = line.split("\\s+");
			linkList pieceList = new linkList();
			int queryX = Integer.parseInt(token[0]);
			int queryY = Character.getNumericValue(token[1].charAt(0));
			
			//check if the place is occupied
			for(int i = 2; i < token.length; i += 3) {
				char TypePiece = token[i].charAt(0);
				int column = Integer.parseInt(token[i+1]);
				int row = Integer.parseInt(token[i+2]);
				//System.out.println(TypePiece + " " + column + " "+ row); debug
				if(pieceList.occupy(column, row)) {
					out.println("Invalid");
					count++;
					break;
				}
			insertPiece(TypePiece, column, row, pieceList);
			}
				if(count < 1) {
					if(pieceList.Validity() == false){
						out.print("Invalid");
						break;
					}else{
					out.print(pieceList.find(queryX, queryY));
					}
					if(pieceList.occupy(queryX, queryY) == false) {
						out.println();
					}
					else {
						out.println(pieceList.isAttack(queryX, queryY));
					}
					}
				}
		in.close();
		out.close();
	}
	public static void insertPiece(char typePiece, int column, int row, linkList list) {
		ChessPiece nextPiece = null;
		switch(typePiece) {
		case 'K' : nextPiece = new King(column, row, 'K');
		break;
		case 'k' : nextPiece = new King(column, row, 'k');
		break;
		case 'Q' : nextPiece = new Queen(column, row, 'Q');
		break;
		case 'q' : nextPiece = new Queen(column, row, 'q');
		break;
		case 'R' : nextPiece = new Rook(column, row, 'R');
		break;
		case 'r' : nextPiece = new Rook(column, row, 'r');
		break;
		case 'B' : nextPiece = new Bishop(column, row, 'B');
		break;
		case 'b' : nextPiece = new Bishop(column, row, 'b');
		break;
		
		}
		list.add(nextPiece);
	}
}
