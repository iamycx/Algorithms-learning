package lectures.sort;
/** 
 * @author Yu
 * @date 2017年8月28日
 */
public class Finder {

	public boolean findX(int[][] mat, int n, int m, int x) {
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return true;
            } else if (mat[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]a ={{1,2,3},{4,5,6},{7,8,9}};
        Finder f = new Finder();
        boolean b = f.findX(a,3,3,5);
        System.out.println(b);
        b = f.findX(a,3,3,15);
        System.out.println(b);
    }

}
