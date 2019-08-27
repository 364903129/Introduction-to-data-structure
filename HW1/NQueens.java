import java.io.*;
import java.util.Scanner;

public class NQueens {

	static int m,c,r;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Usage: java -jar FileCopy.jar <input file> <output file>");
			System.exit(1);
		}
		Scanner input = new Scanner(new File(args[0]));
		PrintWriter output = new PrintWriter(new FileWriter(args[1]));
	while(input.hasNextInt()) {
		m = input.nextInt();
		c = input.nextInt();
		r = input.nextInt();

		board = new int[m][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = 0;
			}
		}
		placeQueen(c - 1, r - 1); 
		

		if (Recursion(m -1 ) == true) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					if (board[i][j] == 1) {
						System.out.print((i + 1) + " " + (j + 1) + " ");
						output.print((i+1)+ " " + (j+1) + " ");
					}
				}
			}
		System.out.println("");
		output.println("");
		}

		else {
			System.out.println("No solution");
			output.println("No solution");
		}
	}
	input.close();
	output.close();
}

	static boolean canPlacequeen(int c, int r) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1) {
					if (c==i || r==j || Math.abs(c-i)==Math.abs(r-j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	static void placeQueen(int c, int r) {
		board[c][r] = 1;	
	}

	static void removeQueen(int c, int r) {
		board[c][r] = 0;
	}

	static boolean Recursion(int n) {
		if (n == 0) {
			return true;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0 && canPlacequeen(i, j)) {
					placeQueen(i, j);
					if (Recursion(n - 1) == true) {
						return true;
					} 
					else {
						removeQueen(i, j);
					}
				}
			}
		}
		return false;
	}
}

