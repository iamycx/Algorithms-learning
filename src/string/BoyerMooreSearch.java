//参考算法第四版代码
package string;

public class BoyerMooreSearch {
	//注意此处right[]的构造
	public static void getRight(String pat, int[] right) {
		for (int i = 0; i < 256; i++) {
			right[i] = -1;
		}
		for (int j = 0; j < pat.length(); j++) {
			right[pat.charAt(j)] = j;
		}
	}

	public static int Search(String txt, String pat, int[] right) {
		int M = txt.length();
		int N = pat.length();
		int skip;
		for (int i = 0; i < M - N; i += skip) {
			skip = 0;
			for (int j = N - 1; j >= 0; j--) {
				if (pat.charAt(j) != txt.charAt(i + j)) {
					skip = j - right[txt.charAt(i + j)];
					if (skip < 1)
						skip = 1;
					break;
				}
			}
			if (skip == 0)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		String txt = "THIS IS A BIG TIGER";
		String pat = "IG";
		int[] right = new int[256];
		getRight(pat, right);
		System.out.println(Search(txt, pat, right));
	}

}
