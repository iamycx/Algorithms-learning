package string;
/** 
 * @author Yu
 * @date 2017年8月26日
 * 
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，
 * 则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 */
public class Transform {

	public boolean isTransform(String A,int lena,String B,int lenb) {
		if(A==null||B==null||lena!=lenb)
			return false;
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[] counts = new int[256];
		for(int i=0;i<lena;i++){
			counts[a[i]]++;
		}
		for(int j=0;j<lenb;j++){
			if(counts[b[j]]==0)
				return false;
			counts[b[j]]--;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Transform().isTransform("abdc",4,"bcad",4));
	}

}
