package string;

/**
 * @author Yu
 * @date 2017年8月27日
 * 
 *       对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 *       给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 *
 *       测试样例： "ABCDE",5,3 返回："DEABC"
 */
public class Translation {

	public String trans(String A, int lena, int a) {
		char[] ch = A.toCharArray();
		reverse(ch, 0, a - 1);
		reverse(ch, a, lena - 1);
		reverse(ch, 0, lena - 1);
		return new String(ch);
	}

	private void reverse(char[] ch, int i, int j) {
		// TODO Auto-generated method stub
		char temp;
		while (i < j) {
			temp = ch[j];
			ch[j] = ch[i];
			ch[i] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Translation().trans("ABCDE",5,3));
	}

}
