package Medium.Trees;

public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(2);
		
		a.left = b;
		a.right = c;
		b.right = d;
		
		System.out.println(kthSmallest(a, 1));
		
	}
	
	public static int kthSmallest(TreeNode root, int k) {
		//preOrder traversal is sorted order of BST
		int[] i = {0, -1, 0};
		helper(root, k, i);
		return i[1];
	}
	
	public static void helper(TreeNode root, int k, int[] i) {
		if(root != null) {
			helper(root.left, k, i);
			//visit
			if(i[0] == k && i[2] == 0) {
				i[2] = 1;
				i[1] = root.val;
				return;
			}
			helper(root.right, k, i);
		} else {
			i[0]++;
		}
	}

}
