package lectures.sort;

/**
 * @author Yu
 * @date 2017年8月28日
 * 计数排序
 */
public class CountingSort {

	public int[] countingSort(int[] A, int n) {
		if (A == null || n == 0) {
			return null;
		}

		int min = A[0], max = A[0];
		for (int i = 0; i < n; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}
		int[] b = new int[max - min + 1];
		for (int i = 0; i < n; i++) {
			b[A[i] - min]++;
		}
		int i = 0;
		for (int j = 0; j <= max - min; j++) {
			for (int c = b[j]; c > 0; c--) {
				A[i] = min + j;
				i++;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28 };
		int[] b = new CountingSort().countingSort(a, 13);
		for (int i : b) {
			System.out.print(i + ",");
		}
	}

}
