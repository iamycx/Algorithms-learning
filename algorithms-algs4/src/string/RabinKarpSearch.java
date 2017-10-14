//为什么一直得不到正确的结果？？

package src.string;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarpSearch {

	private static String txt;
	private static String pat;// 模式字符串
	private static long patHash;// 模式字符串的散列值
	private static long txtHash;
	private static int M;
	private static int N;
	private static long Q;
	private static int R = 256;
	private static long RM;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		txt = "yuchengxin is good man";
		pat = "cheng";
		RabinKarp(pat);
		System.out.println(search(txt));
	}

	public static void RabinKarp(String pat) {
		M = pat.length();
		Q = longRandomPrime();
		RM = 1;
		for (int i = 0; i < M; i++) {
			RM = (R * RM) % Q;
		}
		patHash = hash(pat, M);
	}

	private static long hash(String key, int M) {
		// TODO Auto-generated method stub
		long h = 0;
		for (int j = 0; j < M; j++) {
			h = (R * h + key.charAt(j)) % Q;
		}
		return h;
	}

	private static long longRandomPrime() {
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();
	}

	private static boolean check(int i) {
		// TODO Auto-generated method stub
		return true;
	}

	private static int search(String txt) {
		// TODO Auto-generated method stub
		N = txt.length();
		txtHash = hash(txt, N);
		if (patHash == txtHash && check(0))
			return 0; // 一开始匹配成功
		for (int i = M; i < N; i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;
			if (txtHash == patHash)
				if (check(i - M + 1))
					return i - M + 1;
		}
		return N;
	}
}
