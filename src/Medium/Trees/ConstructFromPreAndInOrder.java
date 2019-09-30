package Medium.Trees;

public class ConstructFromPreAndInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {1,2,3,4};
		int[] inorder = {4,3,2,1};
		TreeNode root = buildTree(preorder, inorder);
		
		printOut(root);
	}
	
	public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
		int[] preIdx = {0};
		TreeNode root = new TreeNode(-1);
		helperv2(preOrder, inOrder, 0, inOrder.length - 1, preIdx, root);		
		return root;
	}
	
	public static void helperv2(int[] preOrder, int[] inOrder, int low, int high, int[] preIdx, TreeNode root) {
		if(low > high) {
			return;
		}
		if(preIdx[0] >= preOrder.length) {
			return;
		}
		int rootIdx = -1;
		for(int i = low; i <= high;i++) {
			if(preOrder[preIdx[0]] == inOrder[i]) {
				rootIdx = i;
				root.val = (inOrder[rootIdx]);
				preIdx[0]++;
				break;
			}
		}
		if(rootIdx != -1) {
			if (low < rootIdx){ // there is a left
				root.left = new TreeNode(-1);
				helperv2(preOrder, inOrder, low, rootIdx - 1, preIdx, root.left);
				
			}
			if (high > rootIdx){ // there is a right
				root.right = new TreeNode(-1);
				helperv2(preOrder, inOrder, rootIdx + 1, high, preIdx, root.right);
			}
		}
	}
	
	public static void printOut(TreeNode root) {
		if(root != null) {
			System.out.print(root.val + " ");
			printOut(root.left);
			printOut(root.right);
		}
	}
	
}
