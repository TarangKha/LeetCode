package Medium.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(9);
		TreeNode c = new TreeNode(20);
		TreeNode d = null;
		TreeNode e = null;
		TreeNode f = new TreeNode(15);
		TreeNode g = new TreeNode(7);
		
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		
		List<List<Integer>> list = zigzagLevelOrder(a);
		for(List<Integer> level : list) {
			for(Integer i : level) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null) {
			return null;
		}
		Queue<TreeNode> parent = new LinkedList<TreeNode>();
		Stack<TreeNode> child = new Stack<TreeNode>();
		
		List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<Integer>();
		int depth = 0;
		
        parent.add(root);
        level.add(root.val);
        list.add(level);
        level = new ArrayList<Integer>();
        depth++;
        
        while(!parent.isEmpty() || !child.isEmpty()) {
        	TreeNode top = parent.poll();
        	if(depth%2 == 0) { //left to right
        		if(top.left != null) {
        			child.push(top.left);
        			level.add(top.left.val);
        		}
        		if(top.right != null) {
        			child.push(top.right);
        			level.add(top.right.val);
        		}
        	} else { //right to left
        		if(top.right != null) {
        			child.push(top.right);
        			level.add(top.right.val);
        		}
        		if(top.left != null) {
        			child.push(top.left);
        			level.add(top.left.val);
        		}
        	}
        	
        	if(parent.isEmpty()) {
        		if(!child.isEmpty()) {
        			list.add(level);
        			level = new ArrayList<Integer>();
        		}
        		depth++;
        		while(!child.isEmpty()) {
        			parent.add(child.pop());
        		}
        	}
        }
        return list;
    }
}
