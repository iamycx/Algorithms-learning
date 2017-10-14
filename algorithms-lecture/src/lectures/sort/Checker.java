package src.lectures.sort;

import java.util.Arrays;

/** 
 * @author Yu
 * @date 2017年8月29日
 * 
 * 请设计一个高效算法，判断数组中是否有重复值。
 * 必须保证额外空间复杂度为O(1)。
 * 给定一个int数组A及它的大小n，请返回它是否有重复值。
 */
public class Checker {

	public boolean checkDuplicate(int[] a, int n) {
        if (a == null || n == 0) {
            return false;
        }

        Arrays.sort(a);
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 3, 6, 5, 8, 7, 10, 9};
        boolean b = new Checker().checkDuplicate(a, 10);
        System.out.println(b);
    }
}
