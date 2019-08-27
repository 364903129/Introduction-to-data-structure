import java.io.*;
import java.util.Scanner;

public class FileReverse {
	public static void main(String args[]) throws IOException{
	Scanner input = new Scanner(new File(args[0]));
	PrintWriter output = new PrintWriter(new FileWriter(args[1]));
	while(input.hasNextLine()) {
		String line = input.nextLine().trim()+" ";
		
		String[] token = line.split("\\s+");
		int n = token.length;
		for(int i=0; i<n; i++) {
			output.println(" "+stringReverse(token[i]));
		}
	}
	output.close();
	input.close();
	}
	public static String stringReverse(String s) {
		char [] array = s.toCharArray();
		char[] reversed = new char[s.length()];
		int j = 0;
		for(int i = array.length-1; i>=0; i--) {
			reversed[j++] = array[i];
		}
		return new String(reversed);
			
}
}
