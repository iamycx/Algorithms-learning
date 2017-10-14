package src.lectures.binarytree;

import java.util.ArrayList;

/** 
 * @author Yu
 * @date 2017年8月28日
 * 
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
public class TreeToSequence {

	public int[][] convert(TreeNode root) {
		int[][] res = new int[3][];
		ArrayList<Integer> pre = new ArrayList<Integer>();//先序
		ArrayList<Integer> in = new ArrayList<Integer>();//中序
		ArrayList<Integer> post = new ArrayList<Integer>();//后序
		
		preOrder(pre,root);
		inOrder(in,root);
		postOrder(post,root);
		
		res[0] = listToArray(pre);
		res[1] = listToArray(in);
		res[2] = listToArray(post);
		
		return res;
	}
	
	private int[] listToArray(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		if(list == null)
			return null;
		int len = list.size();
		int[] arr = new int[len];
		for(int i=0;i<len;i++)
			arr[i] = list.get(i);
		return arr;
	}

	private void postOrder(ArrayList<Integer> list, TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		preOrder(list, root.left);
		preOrder(list, root.right);
		list.add(root.val);
	}
	
	private void inOrder(ArrayList<Integer> list, TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		preOrder(list, root.left);
		list.add(root.val);
		preOrder(list, root.right);
	}
	
	private void preOrder(ArrayList<Integer> list, TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		list.add(root.val);
		preOrder(list, root.left);
		preOrder(list, root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
