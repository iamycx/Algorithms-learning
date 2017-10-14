package binarytree;

import java.util.LinkedList;

/**
 * @author Yu
 * @date 2017年8月27日
 * 
 *       请把纸条竖着放在桌上，然后从纸条的下边向上⽅对折，压出折痕后再展开。 此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；
 *       突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 *       给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 *
 *       测试样例： 1 返回：["down"]
 */
public class FoldPaper {

	public String[] res(int n) {
		String[] res = new String[(1 << n) - 1];
		LinkedList<String> queue = new LinkedList<String>();

		fold(1, n, true, queue);
		for (int i = 0; i < (1 << n) - 1; i++) {
			res[i] = queue.poll();
		}
		return res;
	}

	private void fold(int i, int n, boolean down, LinkedList<String> queue) {
		// TODO Auto-generated method stub
		if (i > n)
			return;
		fold(i + 1, n, true, queue);
		String s = down ? "down" : "up";
		queue.add(s);
		fold(i + 1, n, false, queue);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] r = new FoldPaper().res(3);
		for (String s : r) {
			System.out.print(s + " ");
		}
	}

}
