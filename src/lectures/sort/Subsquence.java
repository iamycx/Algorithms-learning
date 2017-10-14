package lectures.sort;

/**
 * @author Yu
 * @date 2017年8月28日
 * 
 *       对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。
 *       (原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 */
public class Subsquence {

	public int shortSubsquence(int[] A, int n) {
		if (A == null || n == 0)
			return 0;
		int max = A[0];
		int min = A[n - 1];
		int right = 0;
		int left = n - 1;

		for (int i = 0; i < n; i++) {
			if (A[i] >= max)
				max = A[i];
			else {
				right = i;
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			if (A[i] <= min)
				min = A[i];
			else {
				left = i;
			}
		}
		if (right > left)
			return right - left + 1;
		else {
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 4, 7, 5, 2, 3 };
		int b = new Subsquence().shortSubsquence(a, a.length);
		System.out.println(b);
	}

}
