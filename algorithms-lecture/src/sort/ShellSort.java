package sort;
/** 
 * @author Yu
 * @date 2017年8月28日
 * 
 * 希尔排序
 */
public class ShellSort {

	public int[] shellSort(int[] A, int n) {
		if (A == null || n == 0)
			return null;
		
		int h=1;
		while(h<n/3) h=3*h+1;
		
		while(h>=1){
			for (int i = 0; i < n; i++) {
				for (int j = i; j >=h && A[j - h] > A[j]; j-=h) {
					swap(A, j, j - h);
				}
			}
			h = h/3;
		}
		return A;
	}
	
	private void swap(int[] a, int j, int i) {
		// TODO Auto-generated method stub
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28 };
		int[] b = new ShellSort().shellSort(a, 13);
		for (int i : b) {
			System.out.print(i + ",");
		}
	}

}
