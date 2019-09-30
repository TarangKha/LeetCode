package Easy.Trees;

import java.util.ArrayList;

class isSymmetric {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l2 = new TreeNode(3);
		TreeNode r1 = new TreeNode(3);
		TreeNode r2 = new TreeNode(2);
		
		root.left = l1;
		root.right = r1;
		
		l1.left = l2;
		r1.left = r2;
		
		System.out.println(isSymmetricTEST(root));
	}
	
    public static boolean isSymmetricTEST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return true;
        }
        ArrayList<Integer> leftTree = new ArrayList<Integer>();
        ArrayList<Integer> rightTree = new ArrayList<Integer>();
        
        leftTrav(root.left, leftTree);
        rightTrav(root.right, rightTree);
        
        return leftTree.equals(rightTree);
    }
    
    public static void leftTrav(TreeNode root, ArrayList<Integer> list){
        //leftDFS - in order
        if(root == null){
            list.add(Integer.MAX_VALUE);
            return;
        } else {
        	list.add(root.val);
            leftTrav(root.left, list);
            leftTrav(root.right, list);
        }
    }
    
    public static void rightTrav(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            list.add(Integer.MAX_VALUE);
            return;
        } else {
            //rightDFS - in order
        	list.add(root.val);
            rightTrav(root.right, list);
            rightTrav(root.left, list);
        }
    }
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

