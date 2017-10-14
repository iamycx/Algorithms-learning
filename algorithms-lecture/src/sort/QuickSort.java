package sort;

/**
 * @author Yu
 * @date 2017年8月28日
 */
public class QuickSort {

	public int[] quickSort(int[] A, int n) {
		if (A == null || n == 0)
			return null;
		sort(A, 0, n - 1);
		return A;
	}

	private void sort(int[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		if (hi <= lo)
			return;
		int mid = partition(a, lo, hi);
		sort(a, lo, mid - 1);
		sort(a, mid + 1, hi);
	}

	//划分过程
	private int partition(int[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		int key = a[lo];
		int left = lo + 1;
		int right = hi;
		while (true) {
			while (a[left] <= key && left < hi)
				left++;
			while (a[right] >= key && right > lo)
				right--;
			if (left >= right)
				break;
			swap(a, left, right);
		}
		swap(a, lo, right);
		return right;
	}

	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        int[] b = new QuickSort().quickSort(a, 13);
        for (int i : b) {
            System.out.print(i + ",");
        }
	}

}
