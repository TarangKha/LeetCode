package Easy.Trees;

import java.util.LinkedList;
import java.util.Queue;


public class MaxDepth {

	public static void main(String[] args) {
		BiNode root = new BiNode(3);
		BiNode n1 = new BiNode(9);
		BiNode n2 = new BiNode(20);
		root.left = n1;
		root.right = n2;
		n1 = new BiNode(15);
		BiNode n3 = new BiNode(7);
		n2.left = n1;
		n2.right = n3;
		System.out.println(";" + maxDepth(root));
	}
	
	static int maxDepth(BiNode root){
		if (root == null){
			return 0;
		}
		Queue<BiNode> queue = new LinkedList<BiNode>();
		queue.add(root);
		int child = 1;
		int elementsRemoved = 0;
		int depth = 0;
		while (!(queue.isEmpty())){
			BiNode temp = queue.remove();
			elementsRemoved++;
			if (elementsRemoved == child){
				depth++;
				elementsRemoved = 0;
				child = 0;
			}
			if (temp.left != null){
				queue.add(temp.left);
				child++;
			}
			if (temp.right != null){
				queue.add(temp.right);
				child++;
			}
		}
		
		return depth;
	}
}

class BiNode{
	int value;
	BiNode left;
	BiNode right;
	BiNode(int i){
		this.value = i;
	}
}


