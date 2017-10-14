package src.lectures.String;

/**
 * @author Yu
 * @date 2017年8月26日
 * 
 *       请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 *       给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 *
 *       测试样例： "Mr John Smith",13 返回："Mr%20John%20Smith" "Hello World",12
 *       返回："Hello%20%20World"
 */
public class Replacement {

	public String replacement(String s, int n) {
		if (s == null || n == 0)
			return null;
		char[] chars = s.toCharArray();
		int num = 0;
		for (int i = 0; i < n; i++) {
			if (chars[i] == ' ')
				num++;
		}
		int len = n + 2 * num - 1;
		char[] res = new char[len + 1];
		for (int j = n - 1; j >= 0; j--) {
			if (chars[j] == ' ') {
				res[len--] = '0';
				res[len--] = '2';
				res[len--] = '%';
			} else {
				res[len--] = chars[j];
			}
		}
		return new String(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Replacement().replacement("Mr John Smith", 13));
	}

}
