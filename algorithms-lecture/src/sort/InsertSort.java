package sort;

/**
 * @author Yu
 * @date 2017年8月28日
 * 
 * 插入排序
 */
public class InsertSort {

	public int[] insertSort(int[] A, int n) {
		if (A == null || n == 0)
			return null;
		for (int i = 0; i < n-1; i++) {
			for (int j = i + 1; j > 0 && A[j - 1] > A[j]; j--) {
				swap(A, j, j - 1);
			}
		}
		return A;
	}

	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28 };
		int[] b = new InsertSort().insertSort(a, 13);
		for (int i : b) {
			System.out.print(i + ",");
		}
	}

}
