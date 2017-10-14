package src.context;

import java.util.Arrays;

public class SuffixArray {

	private final String[] suffixes;
	private final int N;

	public SuffixArray(String s) {
		// TODO Auto-generated constructor stub
		N = s.length();
		suffixes = new String[N];
		for (int i = 0; i < N; i++) {
			suffixes[i] = s.substring(i);
		}
		Arrays.sort(suffixes);
	}

	public int length() {
		return N;
	}

	public String select(int i) {
		return suffixes[i];
	}

	public int index(int i) {
		return N - suffixes[i].length();
	}

	public int lcp(int i) {
		return lcp(suffixes[i], suffixes[i - 1]);
	}

	//两个字符串的最长公共串的长度
	private int lcp(String s, String t) {
		int M = Math.min(s.length(), t.length());
		for (int i = 0; i < M; i++) {
			if (s.charAt(i) != t.charAt(i))
				return i;
		}
		return M;
	}

	// 小于键key的后缀数量
	public int rank(String key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(suffixes[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}
}
