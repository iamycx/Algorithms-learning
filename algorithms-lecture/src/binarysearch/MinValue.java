package binarysearch;
/** 
 * @author Yu
 * @date 2017年8月31日
 * 
 * 对于一个有序循环数组arr，返回arr中的最小值。
 * 有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。
 * 比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 给定数组arr及它的大小n，请返回最小值。
 *
 * 测试样例：
 * [4,1,2,3,3],5
 * 返回：1
 */
public class MinValue {

	public int getMin(int[] arr,int n) {
		if (arr == null || n == 0) {
            return -1;
        }

        int lo = 0;
        int hi = n - 1;
        int mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            //System.out.println("lo:" + arr[lo] + " hi:" + arr[hi] + " mid:" + arr[mid]+"          lo:" + lo + " hi:" + hi + " mid:" + mid);
            if (arr[lo] < arr[hi]) {
                return arr[lo];
            }

            if (arr[lo] > arr[mid]) {
                hi = mid;
            } else if (arr[hi] < arr[mid]) {
                lo = mid;
            } else {
                int min = arr[lo];
                for (int i = lo; i <= hi; i++) {
                    if (arr[i] < min) {
                        min = arr[i];
                        break;
                    }
                }
                return min;
            }

        }

        return arr[lo];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a ={9,7,3,4,5};
        MinValue mv = new MinValue();
        int min = mv.getMin(a, a.length);
        System.out.println(min);
	}

}
