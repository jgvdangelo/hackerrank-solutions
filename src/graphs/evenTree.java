package graphs;

// from challenge here: https://www.hackerrank.com/challenges/even-tree
public class evenTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private class GraphNode {
		public int ancestorIndex;
		public int numberOfChildren;
		public int index;
		
		public GraphNode(int ancestor, int index) {
			this.ancestorIndex = ancestor;
			this.index = index;
			numberOfChildren = 0;
		}
		
		public void incrementChildren() {
			numberOfChildren++;
		}
		
		public void removeChildren(int remove) {
			numberOfChildren -= remove;
		}
	}
}
