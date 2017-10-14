//参考http://www.cnblogs.com/linbingdong/p/6479537.html
//http://blog.csdn.net/henuyx/article/details/44653799
//http://www.cnblogs.com/tangzhengyue/p/4315393.html
package src.string;

public class KMPSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "yuchengxin is good man";
		String pat = "good";
		int[] next = new int[pat.length()];
		getNext(pat, next);
		System.out.println(Search(txt, pat, next));
	}

	//next数组为pat跳转记录状态的数组，此处是关键，注意理解
	public static int[] getNext(String pat, int[] next) {
		int N = pat.length();
		next[0] = -1;//初始条件next[0]=-1,next[1]=0
		int k = -1;
		int j = 0;
		while (j < N - 1) {
			if (k == -1 || pat.charAt(j) == pat.charAt(k)) {
				next[++j] = ++k; //若相等，则j的下一个跳到k的下一个处
				if (pat.charAt(j) == pat.charAt(k)) {
					next[j] = next[k];//若继续相等，则再往前跳
				}
			} else {
				k = next[k];//不相等则移回到k处
			}
		}
		return next;
	}

	public static int Search(String txt, String pat, int[] next) {
		int M = txt.length();
		int N = pat.length();
		int i = 0, j = 0;
		while (i < M && j < N) {
			if (j == -1 || txt.charAt(i) == pat.charAt(j)) {
				j++;
				i++;
			} else {
				j = next[j];
			}
		}
		if (j == N)
			return i - j;
		else
			return -1;
	}
}
