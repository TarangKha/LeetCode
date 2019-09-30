package Medium.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Node connect(Node root) {
		if(root == null){
            return null;
        }
        Queue<Node> parent = new LinkedList<Node>();
		Queue<Node> child = new LinkedList<Node>();
		
		Node start = root;
		parent.add(root);
		while(!parent.isEmpty()) {
			Node parentNode = parent.remove();
			if(parent.peek() == null) {
				parentNode.next = null;
			} else {
				parentNode.next = parent.peek();
			}
			if(parentNode.left != null) {
				child.add(parentNode.left);
			}
			if(parentNode.right != null) {
				child.add(parentNode.right);
			}
			
			if(parent.isEmpty() && !child.isEmpty()) {
				while(!child.isEmpty()){
                    parent.add(child.remove());
                }
			} else if (parent.isEmpty() && child.isEmpty()) {
				break;
			}
		}
		return start;
	}
}
/*
	Steps:
	
	1. go down left tree, and connect left with right;
	2. when going down right nodes of left tree, create a temp node in an arrayList at the index of the level;
	3. go down right tree, and connect left with right;
	4. when going down left nodes of right tree, delete temp node and connect left side with right side.
	5. go down right side of right tree and point to null;
*/