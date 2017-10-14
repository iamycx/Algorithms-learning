package src.lectures.binarytree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Yu
 * @date 2017年8月28日
 */
public class TreeToSequence2 {

	public int[][] convert(TreeNode root) {
		int[][] res = new int[3][];
		ArrayList<Integer> pre = new ArrayList<Integer>();// 先序
		ArrayList<Integer> in = new ArrayList<Integer>();// 中序
		ArrayList<Integer> post = new ArrayList<Integer>();// 后序

		preOrder(pre, root);
		inOrder(in, root);
		postOrder(post, root);

		res[0] = listToArray(pre);
		res[1] = listToArray(in);
		res[2] = listToArray(post);

		return res;
	}

	private void preOrder(ArrayList<Integer> list, TreeNode root) {
		// TODO Auto-generated method stub
		Stack<TreeNode> stack = new Stack<TreeNode>();

		if (root == null)
			return;

		TreeNode current = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			current = stack.pop();
			list.add(current.val);
			if (current.right != null)
				stack.push(current.right);
			if (current.left != null) {
				stack.push(current.left);
			}
		}
	}

	private void inOrder(ArrayList<Integer> list, TreeNode root) {
		// TODO Auto-generated method stub
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return;
		TreeNode current = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			if (current == null || current.left == null) {
				current = stack.pop();
				list.add(current.val);
				if (current.right != null)
					stack.push(current.right);
				current = current.right;
			} else {
				stack.push(current.left);
				current = current.left;
			}
		}
	}

	private void postOrder(ArrayList<Integer> list, TreeNode root) {
		// TODO Auto-generated method stub

		Stack<TreeNode> stack = new Stack<TreeNode>();

		if (root == null)
			return;

		TreeNode last = root;
		TreeNode current = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			current = stack.peek();
			if (current.left != null && last != current.left && last != current.right) {
				stack.push(current.left);
			} else if (current.right != null && last != current.right) {
				stack.push(current.right);
			} else {
				last = stack.pop();
				list.add(last.val);
			}
		}
	}

	private int[] listToArray(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		if (list == null)
			return null;
		int len = list.size();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++)
			arr[i] = list.get(i);
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
