package string;
/** 
 * @author Yu
 * @date 2017年8月26日
 * 
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。
 * 保证A中字符全部为小写英文字符，且长度小于等于500。
 *
 * 测试样例：
 * "aabcb",5
 * 返回：3
 */
public class DistinctSubstring {

	public int longestSubstring(String A,int n) {
		if(A==null||n==0)
			return 0;
		char[] c = A.toCharArray();
		int[] maps= new int[256];
		for(int i=0;i<maps.length;i++){
			maps[i]=-1;
		}
		int maxLen = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            pre = Math.max(pre, maps[c[i]]);
            cur = i - pre;
            System.out.println(c[i]+"("+i+")  pre:"+ pre + " cur:"+cur);
            maxLen = Math.max(cur, maxLen);
            maps[c[i]] = i;
        }
        return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new DistinctSubstring().longestSubstring("aabcb", 5));
	}

}
