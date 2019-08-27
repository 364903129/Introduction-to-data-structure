import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Balanced {
	public static void main(String[] args) throws IOException {

		int lineNumber = 0;

		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));
		while (in.hasNextLine()) {
			StackReferenceBased aStack = new StackReferenceBased();
			boolean balancedSoFar = true;
			lineNumber++;
			String line = in.nextLine().trim() + " ";
			char[] token = line.toCharArray();
			int n = token.length;
			//System.out.println("Line " + lineNumber + " contains " + n + " tokens:");
			for (int i = 0; i < n; i++) {
				//System.out.println(" " + token[i]);
				while (balancedSoFar && i < n) {
					char ch = token[i];
					if (ch == '{') {
						aStack.push('{');
					} else if (ch == '}') {
						if (!aStack.isEmpty() && aStack.peek() == '{') {
							aStack.pop();
						} else if (aStack.pop() == 'k') {
							balancedSoFar = false;
						} else {
							balancedSoFar = false;
						}
					}
					if (ch == '(') {
						aStack.push('(');
					} else if (ch == ')') {
						if (!aStack.isEmpty() && aStack.peek() == '(') {
							aStack.pop();
						} else if (aStack.pop() == 'k') {
							balancedSoFar = false;
						} else {
							balancedSoFar = false;
						}
					}
					if (ch == '<') {
						aStack.push('<');
					} else if (ch == '>') {
						if (!aStack.isEmpty() && aStack.peek() == '<') {
							aStack.pop();
						} else if (aStack.pop() == 'k') {
							balancedSoFar = false;
						} else {
							balancedSoFar = false;
						}
					}
					if (ch == '[') {
						aStack.push('[');
					} else if (ch == ']') {
						if (!aStack.isEmpty() && aStack.peek() == '[') {
							aStack.pop();
						} else if (aStack.pop() == 'k') {
							balancedSoFar = false;
						} else {
							balancedSoFar = false;
						}
					}
					break;
				}
			}
			if (balancedSoFar && aStack.isEmpty()) {
				out.println("Y");
			} else {
				out.println("N");
			}
		}
		in.close();
		out.close();
	}
}