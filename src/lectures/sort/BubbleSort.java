package lectures.sort;
/** 
 * @author Yu
 * @date 2017年8月28日
 * 
 * 冒泡排序
 */
public class BubbleSort {
	public int[] bubbleSort(int[] A,int n) {
		if(A==null||n==0)
			return null;
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i-1;j++){
				if(A[j]>A[j+1])
					swap(A,j,j+1);
			}
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
        int[] b = new BubbleSort().bubbleSort(a, 13);
        for (int i : b) {
            System.out.print(i + ",");
        }
	}
}
