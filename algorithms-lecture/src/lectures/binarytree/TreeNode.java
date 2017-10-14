package src.lectures.binarytree;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Yu
 * @date 2017年8月26日
 * 
 * 自定义的辅助类，用于创建测试用例
 */
public class TreeNode {

	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}

	public static TreeNode createTree(String[] sequence) {
		LinkedList<String> list = new LinkedList<String>();
		list.addAll(Arrays.asList(sequence));
		return createTree(list);

	}

	private static TreeNode createTree(LinkedList<String> list) {
		// TODO Auto-generated method stub
		if (list.isEmpty())
			return null;
		String string = list.poll();
		if (string.equals("#"))
			return null;

		TreeNode root = new TreeNode(Integer.parseInt(string));
		root.left = createTree(list);
		root.right = createTree(list);
		return root;
	}
}
