public class Node {
	int data;
	Node next;

	public Node(int d, Node n) { data = d; next = n; }

	public String toString() {
		if (next != null)
			return Integer.toString(data) + ", " + next.toString();
		else
			return Integer.toString(data);
	}

}
