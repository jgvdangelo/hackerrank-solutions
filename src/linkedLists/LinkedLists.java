package linkedLists;

public class LinkedLists {
	
	Node MergeLists(Node a, Node b){
		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		} 
		
		Node ret = null;
		
		
		// create head
		if (a.data < b.data) {
			ret = a;
			a = a.next;
		} else {
			ret = b;
			b = b.next;
		}
		Node retCurrent = ret;
		
		while (a != null && b != null) {
			if (a.data < b.data) {
				retCurrent.next = a;
				a = a.next;
			} else {
				retCurrent.next = b;
				a = a.next;
			}
			retCurrent = retCurrent.next;
		}
		
		if (a != null) {
			retCurrent.next = a;
		} else if (b != null) {
			retCurrent.next = b;
		}
		
		return ret;
	}
	
	public class Node {
		int data;
		Node next;
	}	
}
