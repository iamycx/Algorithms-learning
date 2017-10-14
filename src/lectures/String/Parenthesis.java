package lectures.String;

/**
 * @author Yu
 * @date 2017年8月26日
 * 
 *       对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 *       给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。 测试样例： "(()())",6 返回：true 测试样例：
 *       "()a()()",7 返回：false 测试样例： "()(()()",7 返回：false
 */
public class Parenthesis {

	public boolean isParenthesis(String s, int n) {
		if (s == null || n == 0)
			return false;
		char[] chars = s.toCharArray();
		int num = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(')
				num++;
			if (chars[i] == ')')
				num--;
			if (chars[i] == ')' && --num == 0)
				return false;
		}
		return num == 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parenthesis p = new Parenthesis();
        boolean b;
        b = p.isParenthesis("(()())", 6);
        System.out.println(b);
        b = p.isParenthesis("()a()()", 7);
        System.out.println(b);
        b = p.isParenthesis("()(()()", 7);
        System.out.println(b);
	}

}
