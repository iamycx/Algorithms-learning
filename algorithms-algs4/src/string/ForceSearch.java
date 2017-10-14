// 暴力查找字符串中的指定字符串
package src.string;

public class ForceSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("" + Search("abcdefgh", "def"));
	}

	public static int Search(String txt, String pat) {
		int M = txt.length();
		int N = pat.length();
		for (int i = 0; i <= M - N; i++) {
			int j;
			for (j = 0; j < N; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == N)
				return i;
		}
		return -1;
	}

}
