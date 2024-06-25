package day13;



class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		val=x;
	}
}

public class BinaryTreeBalance {

	private static int checkHeight(TreeNode node) {
		if(node==null) {
			return 0;
		}
		int leftHeight=checkHeight(node.left);
		int rightHeight=checkHeight(node.right);
		
		if(leftHeight==-1 || rightHeight ==-1) {
			return -1;
		}
		if(Math.abs(leftHeight-rightHeight)>1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight)+1;
	}
	public static boolean isBalanced(TreeNode root) {
		return checkHeight(root)!=-1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		
		System.out.println("is the tree balanced?" + isBalanced(root));
		
		root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(3);
		
		System.out.println("is the tree balanced?" + isBalanced(root));
	}

}
