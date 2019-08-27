
public class Queue {
	public Node lastNode;

	public Queue() {
		lastNode = null;
	}

	public boolean isEmpty() {
		return lastNode == null;
	}

	public void enqueue(Object newItem) {
		Node newNode = new Node(newItem);

		if (isEmpty()) {
			newNode.next = newNode;
		} else {
			newNode.next = lastNode.next;
			lastNode.next = newNode;
		}
		lastNode = newNode;
	}

	public Object dequeue() {
		if (!isEmpty()) {
			Node firstNode = lastNode.next;
			if (firstNode == lastNode) {
				lastNode = null;
			} else {
				lastNode.next = firstNode.next;
			}
			return firstNode.item;
		} else {
			return 'k';
		}
	}

	public Object peek() {
		if (!isEmpty()) {
			Node firstNode = lastNode.next;
			return firstNode.item;
		} else {
			return 'k';

		}
	}
}
