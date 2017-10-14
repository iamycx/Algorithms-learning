package src.lectures.sort;
/** 
 * @author Yu
 * @date 2017年8月28日
 * 
 * 选择排序
 */
public class SelectSort {

	public int[] selectSort(int[] A, int n) {
		if (A == null || n == 0)
			return null;
		int min = 0;
		for(int i=0;i<n;i++){
			min = i;
			for(int j=i;j<n;j++){
				if(A[j]<A[min]){
					min = j;
				}
			}
			swap(A, min, i);
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
		int[] a = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        int[] b = new SelectSort().selectSort(a, 13);
        for (int i : b) {
            System.out.print(i + ",");
        }
	}

}
