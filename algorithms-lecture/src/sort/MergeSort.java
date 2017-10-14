package sort;

/**
 * @author Yu
 * @date 2017年8月28日
 * 
 *       归并排序
 */
public class MergeSort {

	public int[] mergeSort(int[] A, int n) {
		if (A == null || n == 0)
			return null;
		int[] help = new int[n];
		int end;
		for (int size = 1; size < n; size = 2 * size) {
			for (int i = 0; i + size < n; i = i + 2 * size) {
				end = Math.min(n, i + 2 * size);
				merge(A, help, i, i + size, end);
			}
		}
		return A;
	}

	private void merge(int[] a, int[] help, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		for (int i = lo; i < hi; i++)
			help[i] = a[i];
		int left = lo;
		int right = mid;
		for (int i = lo; i < hi; i++) {
			if (left == mid)
				a[i] = help[right++];
			else if (right == hi) {
				a[i] = help[left++];
			} else if (help[right] < help[left]) {
				a[i] = help[right++];
			} else {
				a[i] = help[left++];
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 3, 6, 7, 2, 1, 8, 9 };
		int[] sort = new MergeSort().mergeSort(a, a.length);
		for (int i : sort) {
			System.out.print(i + ",");
		}
	}

}
