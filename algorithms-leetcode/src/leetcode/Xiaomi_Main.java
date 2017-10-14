package leetcode;

/**
 * @author Yu
 * @date 2017年9月18日
 * 
 * 2018小米软开笔试第一题
 */

import java.util.Scanner;

public class Xiaomi_Main {

	private static String res = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.next();
			str = Exg(str);
			res = str.toUpperCase();
			System.out.println(res);
		}
		sc.close();
//		System.out.println(Exg("MY.ASTParser12").toUpperCase());
	}

	public static String Exg(String str) {
		if (str == null)
			return null;
		str = "_" + str + "_";
		str = str.replace('.', '_');
		char[] c = new char[str.length()+1000];
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			if ((('a' <= str.charAt(i) && str.charAt(i) <= 'z')
					&& ('A' <= str.charAt(i + 1) && str.charAt(i + 1) <= 'Z'))) {
				c[j++] = str.charAt(i);
				c[j++] = '_';
			} else if ((('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
					&& ('A' <= str.charAt(i + 1) && str.charAt(i + 1) <= 'Z')
					&& ('a' <= str.charAt(i + 2) && str.charAt(i + 2) <= 'z'))) {
				c[j++] = str.charAt(i);
				c[j++] = '_';
			} else if ((('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
					|| ('a' <= str.charAt(i) && str.charAt(i) <= 'z'))
					&& ('0' <= str.charAt(i + 1) && str.charAt(i + 1) <= '9')) {
				c[j++] = str.charAt(i);
				c[j++] = '_';
			} else if (('0' <= str.charAt(i) && str.charAt(i) <= '9')
					&& (('A' <= str.charAt(i + 1) && str.charAt(i + 1) <= 'Z')
							|| ('a' <= str.charAt(i + 1) && str.charAt(i + 1) <= 'z'))) {
				c[j++] = str.charAt(i);
				c[j++] = '_';
			} else {
				c[j++] = str.charAt(i);
			}
			
		}
		
		String ss = String.valueOf(c);
		ss = ss.trim();//用trim()函数去除字符串首尾的空格
		return ss;
	}
}