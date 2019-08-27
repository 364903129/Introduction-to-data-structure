
public class Node {
	public char bracket;
	public Node next;
	
	Node(char newBracket) {
		bracket = newBracket;
		next = null;
	}
	Node(char newBracket, Node nextNode){
		bracket = newBracket;
		next = nextNode;
	}
}
