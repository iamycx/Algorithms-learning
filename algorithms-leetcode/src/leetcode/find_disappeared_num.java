package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class find_disappeared_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m = { 1, 1, 2, 2, 4, 4, 5, 5, 9 };
		System.out.println(singleNonDuplicate(m));
	}

	public static int singleNonDuplicate(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len - 2; i += 2) {
			int j = i+1;
			if (nums[i] != nums[j]) {
				return nums[i];
			}
		}
		return nums[len - 1];
	}

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return "";
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = nums[i] + "";
		}
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String i, String j) {
				String s1 = i + j;
				String s2 = j + i;
				return s1.compareTo(s2);
			}
		});
		if (strs[strs.length - 1].charAt(0) == '0')
			return "0";
		String res = new String();
		for (int i = 0; i < strs.length; i++) {
			res = strs[i] + res;
		}
		return res;
	}

	public static boolean detectCapitalUse(String word) {
		String upper = word.toUpperCase();
		String lower = word.toLowerCase();
		if (lower == word || upper == word)
			return true;
		String sub = word.substring(1, word.length());
		if (sub.toLowerCase() == sub)
			return true;
		else
			return false;

	}

	public static boolean judgeCircle(String moves) {
		int m = 0, n = 0, j = 0, k = 0;
		for (int i = 0; i < moves.length(); i++) {
			switch (moves.charAt(i)) {
			case 'U':
				m++;
				break;
			case 'D':
				n++;
				break;
			case 'R':
				j++;
				break;
			case 'L':
				k++;
				break;
			default:
				break;
			}
		}
		if (m == n && j == k)
			return true;
		else
			return false;
	}

	public static String reverseWords(String s) {
		String res = "";
		String[] strings = s.split(" ");
		for (int i = 0; i < strings.length; i++) {
			StringBuffer sb = new StringBuffer(strings[i]);
			strings[i] = sb.reverse().toString();
			res += strings[i];
			if (i < strings.length - 1)
				res += " ";
		}
		return res;

	}

	public static int arrayPairSum(int[] nums) {
		int i = 0;
		Arrays.sort(nums);
		for (int j = 0; j < nums.length; j += 2) {
			i += nums[j];
		}
		return i;
	}

	public static List<Integer> getRight(int[] nums) {
		List<Integer> l = new ArrayList<Integer>();
		Arrays.sort(nums);
		int gg = nums.length - 1;
		int max = nums[gg];
		max++;
		int[] m = new int[max];
		for (int i = 0; i < nums.length; i++) {
			m[nums[i]] = 1;
		}
		for (int j = 1; j < m.length; j++) {
			if (m[j] == 0) {
				l.add(j);
			}
		}
		return l;
	}

}
