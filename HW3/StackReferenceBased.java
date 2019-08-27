
public class StackReferenceBased {

	public Node top;

	public StackReferenceBased() {
		top = null;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(char newBracket) {
		top = new Node(newBracket, top);
	}

	public char pop() {
		if (!isEmpty()) {
			Node temp = top;
			top = top.next;
			return temp.bracket;
		} else {
			return 'k';
		}
	}

	public void popAll() {
		top = null;
	}

	public char peek() {
		if (!isEmpty()) {
			return top.bracket;
		} else {
			return 'm';
		}
	}
}
