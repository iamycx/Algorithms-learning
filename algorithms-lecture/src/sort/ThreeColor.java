package sort;

/**
 * @author Yu
 * @date 2017年8月29日
 * 
 *       荷兰旗问题
 *
 *       有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 *       给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 */
public class ThreeColor {

	public int[] sortThreeColor(int[] A, int n) {
		if (A == null || n == 0)
			return null;

		int lo = -1;
		int hi = n;
		int mid = 0;
		while (mid < hi) {
			if (A[mid] < 1) {
				lo++;
				swap(A, lo, mid);
				mid++;
			} else if (A[mid] > 1) {
				hi--;
				swap(A, hi, mid);
			} else {
				mid++;
			}
		}
		return A;
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 0, 1, 2, 0, 1, 2 };
		int[] b = new ThreeColor().sortThreeColor(a, 6);
		for (int i : b) {
			System.out.print(i + ",");
		}
	}

}
