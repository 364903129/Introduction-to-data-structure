import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Bard {
	static int count = 0;
	public Node head;
	
	public Node remove() { //print out number of times in this case
		Node temp = head;
		if (head == null) {
			return null;
		}
		head = head.next;
		return temp;
	}

	public void add(String key, int frequency) {
		Node n = new Node();
		n.freq = frequency;
		n.key = key;
		Node pre = null;
		Node curr = head;
		while (curr != null && frequency < curr.freq) {
			pre = curr;
			curr = curr.next;
		}

		if (pre == null) {// adds at the head
			n.next = head;
			head = n;
		}

		else {
			pre.next = n;
			n.next = curr;
		}
		count = count + 1;
	}


	public static boolean isNumber(String str) { //check if it's a number
		try {
			Integer integer = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public void reset() { //reset the list
		head = null;
	}

	public static void main(String[] args) throws Exception {
		Path path = Paths.get(System.getProperty("user.dir")).resolve("shakespeare.txt");// open shakespeare file
		BufferedReader shakespeare = new BufferedReader(new FileReader(path.toFile()));
		FileReader readingFile = new FileReader("input.txt");// open input file
		BufferedReader reading = new BufferedReader(readingFile);
		PrintStream printStream = new PrintStream(new FileOutputStream("analysis.txt"));// write on analysis file
		System.setOut(printStream);
		
		Bard B = new Bard();

		Map<String, Integer> times = new HashMap<>(); //import hash table
		String line = shakespeare.readLine();
		String token = reading.readLine();
		while (line != null) { 
			if (!line.trim().equals("")) {
				String[] words = line.split(" ");
				for (String word : words) {
					if (word == null || word.trim().equals("") || word.toUpperCase().equals(word)) {
						continue;
					}
					token = token.toLowerCase();
					String processed = word.toLowerCase();
					// replace all the punctuation with space, then trim. 
					if (processed.length() > 1)
					{
						if (processed.charAt(0) == '"' && processed.charAt(processed.length() - 1) == '"') {
							processed = processed.substring(1, processed.length() - 1);
						}
						if (processed.charAt(0) == '"' && !(processed.charAt(processed.length() - 1) == '"')) {
							processed = processed.substring(1);
						}
						if (!(processed.charAt(0) == '"') && (processed.charAt(processed.length() - 1) == '"')) {
							processed = processed.substring(0, processed.length() - 1);
						}
					}
					if (processed.indexOf("[") == 0 || processed.indexOf("[") == processed.length() - 1)
						processed = processed.replace("[", "");
					if (processed.indexOf("]") == 0 || processed.indexOf("]") == processed.length() - 1)
						processed = processed.replace("]", "");
					if (processed.indexOf("(") == 0 || processed.indexOf("(") == processed.length() - 1)
						processed = processed.replace("(", "");
					if (processed.indexOf(")") == 0 || processed.indexOf(")") == processed.length() - 1)
						processed = processed.replace(")", "");
					if (processed.indexOf("-") == 0 || processed.indexOf("-") == processed.length() - 1)
						processed = processed.replace("-", "");
					if (processed.indexOf(";") == 0 || processed.indexOf(";") == processed.length() - 1)
						processed = processed.replace(";", "");
					if (processed.indexOf(".") == 0 || processed.indexOf(".") == processed.length() - 1)
						processed = processed.replace(".", "");
					if (processed.indexOf(",") == 0 || processed.indexOf(",") == processed.length() - 1)
						processed = processed.replace(",", "");
					if (processed.indexOf(" ") == 0 || processed.indexOf(" ") == processed.length() - 1)
						processed = processed.replace(" ", "");
					if (processed.indexOf("'") == 0 || processed.indexOf("'") == processed.length() - 1)
						processed = processed.replace("'", "");
					if (processed.indexOf("!") == 0 || processed.indexOf("!") == processed.length() - 1)
						processed = processed.replace("!", "");
					if (processed.indexOf("?") == 0 || processed.indexOf("?") == processed.length() - 1)
						processed = processed.replace("?", "");
					if (processed.indexOf(":") == 0 || processed.indexOf(":") == processed.length() - 1)
						processed = processed.replace(":", "");
					if (processed.indexOf("\"") == 0 || processed.indexOf("\"") == processed.length() - 1)
						processed = processed.replace("\"", "");
					if (processed.indexOf("/") == 0 || processed.indexOf("/") == processed.length() - 1)
						processed = processed.replace("/", "");
					if (processed.indexOf("_") == 0 || processed.indexOf("_") == processed.length() - 1)
						processed = processed.replace("_", "");
					
					if (times.containsKey(processed)) {
						times.put(processed, times.get(processed) + 1);
					} else {
						times.put(processed, 1);
					}

				}
			}

			line = shakespeare.readLine();
		}
		while (token != null) {
			token = token.trim();
			String[] strings = token.split(" ");
			if (isNumber(strings[0])) {
				int lengthofword = Integer.parseInt(strings[0]);
				int numberoftimes = Integer.parseInt(strings[1]);
				for (Map.Entry<String, Integer> entry : times.entrySet()) {
					if (entry.getKey().length() == lengthofword) {
						B.add(entry.getKey(), entry.getValue());
					}
				}
				for (int i = 0; i < numberoftimes; i++) {
					System.out.print(B.remove().key + " ");
				}

			} else {
				if (times.get(token) != null) { //if this word exist, print out the solution to analysis
					System.out.print(token + " " + times.get(token));
				} else if (times.get(token) == null) { // if odn't exist print out 0 to analysis
					System.out.print(token + " " + "0");
				}
			}
			B.reset();
			System.out.println(); 
			token = reading.readLine();
		}
		shakespeare.close();//close shakespeare and reading
		reading.close();
	}
}