package src.lectures.binarytree;
/** 
 * @author Yu
 * @date 2017年8月27日
 * 
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 */
public class CheckBalance {
	
	public boolean checkBalance(TreeNode root) {
		return post(root)>=0;
	}

	private int post(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null){
			return 0;
		}
		
		int leftHight= post(root.left);
		if(leftHight==-1)
			return -1;
		
		int rightHight= post(root.right);
		if(rightHight==-1)
			return -1;
		
		if(Math.abs(leftHight-rightHight)>1)
			return -1;
		return Math.max(leftHight, rightHight)+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
