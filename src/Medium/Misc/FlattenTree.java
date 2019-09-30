package Medium.Misc;

import Medium.Trees.TreeNode;

public class FlattenTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(5);
		
		a.left.left = new TreeNode(3);
		a.left.right = new TreeNode(4);
		
		a.right.right = new TreeNode(6);
		
		flatten(a);
		printTree(a);
		
	}
	
	public static void flatten(TreeNode root) {
        //appraoch - keep going left recursively, when you have to go right, move the node to the bottom left child.
        TreeNode start = root;
        TreeNode[] destination = new TreeNode[1];
        recurse(root, destination);
        TreeNode leftPointer = root.left;
        while(leftPointer != null){
            root.right = leftPointer;
            root.left = null;
            leftPointer = leftPointer.left;
            root = root.right;
        }
        root = start;
    }
    
    public static void recurse(TreeNode root, TreeNode[] destination){
        if(root != null){
            //visit
            if(destination[0] != null){
                destination[0].left = root;
                destination[0] = destination[0].left;
            }
            recurse(root.left, destination);
            //hit bottom of left branch.
            if(destination[0] == null){
                destination[0] = root;
            }
            recurse(root.right, destination);
        }
    }
    
    public static void printTree(TreeNode root) {
    	while(root != null) {
    		System.out.println(root.val);
    		root = root.right;
    	}
    }

}
