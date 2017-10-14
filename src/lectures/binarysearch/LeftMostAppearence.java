package lectures.binarysearch;
/** 
 * @author Yu
 * @date 2017年8月31日
 * 
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。
 * 若该元素在数组中未出现，请返回-1。
 *
 * 测试样例：
 * [1,2,3,3,4],5,3
 * 返回：2
 */
public class LeftMostAppearence {
	public int findLeftAppearence(int[] arr,int n,int num) {
		if(n==0||arr==null)
			return -1;
		int res = -1;
		int hi = n-1;
		int lo = 0;
		int mid = 0;
		while(lo<=hi){
			mid = lo+(hi-lo)/2;
			if(arr[mid]>num){
				hi = mid-1;
			}else if(arr[mid]<num){
				lo = mid+1;
			}else {
				res = mid;
				hi = mid-1;
			}
		}
		return res;
	}
}
