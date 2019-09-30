package Medium.Design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Medium.Trees.TreeNode;

public class Codec {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		String tc = "*,5,2,3,x,x,2,4,3,1";
		//TreeNode tcR = deserialize(tc);
		System.out.println(serialize(deserialize(tc)));
		
		//System.out.println(serialize(root));
		//System.out.println(serialize(deserialize(serialize(root))));
	}
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
    	//BFS to construct string
    	String serialized = "*";
    	Queue<TreeNode> parent = new LinkedList<TreeNode>();
    	Queue<TreeNode> child = new LinkedList<TreeNode>();
    	parent.add(root);
    	while(!parent.isEmpty()) {
    		TreeNode parentNode = parent.poll();
    		if(parentNode != null) {
    			serialized = serialized + "," + parentNode.val;
    			if(parentNode.left != null) {
        			child.add(parentNode.left);
        		} else {
        			child.add(null);
        		}
        		if(parentNode.right != null) {
        			child.add(parentNode.right);
        		} else {
        			child.add(null);
        		}
    		} else {
    			serialized = serialized + "," + "x";
    			child.add(null);
    			child.add(null);
    		}
    		if(parent.isEmpty() && !child.isEmpty()) {
    			boolean finished = true;
				while(!child.isEmpty()){
					if(child.peek() != null) {
						finished = false;
					}
                    parent.add(child.remove());
                }
				if(finished == true) {
					break;
				}
			} else if (parent.isEmpty() && child.isEmpty()) {
				break;
			}
    	}
    	return serialized;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	String[] input = data.split(",");
    	TreeNode[] nodes = new TreeNode[input.length];
    	nodes[0] = null;
    	for(int i = 1; i < input.length; i++) {
    		if(!input[i].equals("x")) {
    			nodes[i] = new TreeNode(Integer.parseInt(input[i]));
    		}
    	}
    	for(int i = 1; i < nodes.length/2; i++) {
    		TreeNode root = nodes[i];
    		if(root == null) {
    			continue;
    		}
    		root.left = nodes[i*2];
    		root.right = nodes[(i*2)+1];
    	}
    	return nodes[1]; 
    }
 // Your Codec object will be instantiated and called as such:
 // Codec codec = new Codec();
 // codec.deserialize(codec.serialize(root));

}
