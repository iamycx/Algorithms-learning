package lectures.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Yu
 * @date 2017年8月27日
 * 
 *       有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。 给定二叉树的根结点root，请返回打印结果，
 *       结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下， 且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 */
public class TreePrinter {

	public int[][] treePrint(TreeNode root) {
		if (root == null)
			return null;
		TreeNode last = root;
		TreeNode nlast = root;

		ArrayList<LinkedList<Integer>> levels = new ArrayList<LinkedList<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		int line = 0;
		levels.add(line, new LinkedList<Integer>());

		while (!queue.isEmpty()) {
			TreeNode now = queue.poll();
			levels.get(line).add(now.val);

			if (now.left != null) {
				queue.add(now.left);
				nlast = now.left;
			}
			if (now.right != null) {
				queue.add(now.right);
				nlast = now.right;
			}
			if (last == now && !queue.isEmpty()) {
				last = nlast;
				line++;
				levels.add(line, new LinkedList<Integer>());
			}
		}

		int[][] arr = new int[levels.size()][];
		for (int i = 0; i < levels.size(); i++) {
			int len = levels.get(i).size();
			arr[i] = new int[len];
			for (int j = 0; j < len; j++) {
				arr[i][j] = levels.get(i).get(j);
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
