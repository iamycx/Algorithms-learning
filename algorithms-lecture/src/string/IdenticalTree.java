package string;

/**
 * @author Yu
 * @date 2017年8月27日
 * 
 *       对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 *       给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 *
 *       KMP算法讲解博客:
 *       http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 *       http://blog.csdn.net/v_july_v/article/details/7041827
 *       http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
 *
 *       移动位数 = 已匹配的字符数 - 对应的部分匹配值
 */
public class IdenticalTree {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
		}
	}

	private String treeToString(TreeNode root) {
		String seq = "";
		if (root == null)
			return "#!";
		seq = root.val + "!";
		seq += treeToString(root.left);
		seq += treeToString(root.right);
		return seq;
	}

	public boolean isIdenticalTree(TreeNode A, TreeNode B) {
		String aString = treeToString(A);
		String bString = treeToString(B);
		return getIndexOf(aString, bString) != -1;
	}

	//kmp
	private int getIndexOf(String a, String b) {
		// TODO Auto-generated method stub
		int[] next = new int[b.length()];
		next = getNext(b,next);
		return searchKMP(a,b,next);
	}

	private int searchKMP(String a, String b, int[] next) {
		// TODO Auto-generated method stub
		int M = a.length();
		int N = b.length();
		int i=0,j=0;
		while(i<M&&j<N){
			if(j==-1||a.charAt(i)==b.charAt(j)){
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		if(j==N)
			return i-j;
		else
			return -1;
	}

	private int[] getNext(String b, int[] next) {
		// TODO Auto-generated method stub
		int N = b.length();
		next[0] = -1;
		int k=-1;
		int j=0;
		while(j<N-1){
			if(k==-1||b.charAt(k)==b.charAt(j)){
				next[++j]= ++k;
				if(b.charAt(k)==b.charAt(j))
					next[j] = next[k];
			}else {
				k = next[k];
			}
		}
		return next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //System.out.println(new IdenticalTree().isIdenticalTree(A, B));
	}

}
