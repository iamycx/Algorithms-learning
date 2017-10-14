package sort;
/** 
 * @author Yu
 * @date 2017年8月28日
 * 
 * 基数排序
 * 保证元素均小于等于2000
 */
public class RadixSort {
	
	private int[] radix = {1, 10, 100, 1000};

	public int[] radixSort(int[] A, int n) {
        if (A == null || n == 0) {
            return null;
        }
        int total = radix.length;
        int[][] bucket = new int[10][n];
        int[] count = new int[10];
        int number = 0;

        for (int position = 0; position < total; position++) {
            for (int i = 0; i < n; i++) {
                number = getNumber(A[i], position);
                bucket[number][count[number]++] = A[i];
            }
            int i = n - 1;
            for (int k = 9; k >= 0; k--) {
                while (count[k] > 0) {
                    A[i--] = bucket[k][--count[k]];
                }

            }
        }
        return A;
    }

    private int getNumber(int num, int i) {
        num = num / radix[i];
        return num % 10;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28 };
		int[] b = new RadixSort().radixSort(a, 13);
		for (int i : b) {
			System.out.print(i + ",");
		}
	}

}
