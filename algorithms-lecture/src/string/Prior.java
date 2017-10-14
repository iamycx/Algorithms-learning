package string;

import java.util.Arrays;
import java.util.Comparator;

/** 
 * @author Yu
 * @date 2017年8月27日
 * 
 * 对于一个给定的字符串数组，请找到一种拼接顺序，
 * 使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 *
 * 测试样例：
 * ["abc","de"],2
 * "abcde"
 */
public class Prior {

	public String isPrior(String[] A,int n) {
		if(A==null||n==0)
			return null;
		
		//此处对String数组排序
		Arrays.sort(A,new Comparator<String>() {
			public int compare(String s1,String s2) {
				return (s1+s2).compareTo(s2+s1);
			}
		});
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<A.length;i++){
			sb.append(A[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"gbc","de","ack"};
		System.out.println(new Prior().isPrior(str, 3));
	}

}
