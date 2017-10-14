package src.context;

public class LRS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = StdIn.readAll();
		int N = text.length();
		SuffixArray sa = new SuffixArray(text);
		String longestRepeatSubstring = "";
		for (int i = 1; i < N; i++) {
			int length = sa.lcp(i);
			if (length > longestRepeatSubstring.length())
				longestRepeatSubstring = sa.select(i).substring(0, length);
		}
		StdOut.println(longestRepeatSubstring);
	}

}
