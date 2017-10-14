package src.lectures.stack;

import java.util.Stack;

/** 
 * @author Yu
 * @date 2017年8月30日
 * 
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，
 * 为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 *
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 */
public class TwoStack {

	public int[] twoStack(int[] A,int n) {
		if(A==null||n==0){
			return null;
		}
		
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		int popCount = 0;
		for(int i = 0;i<n;i++){
			if(A[i]>0)
				stack1.push(A[i]);
			else 
				popCount++;
		}
		
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		int[] res = new int[popCount];
		int i=0;
		while(popCount>0){
			res[i] = stack2.pop();
			i++;
			popCount--;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStack ts = new TwoStack();
        int[] a = {1, 2, 3, 0, 4, 0};
        int[] b = ts.twoStack(a, a.length);
        for (int i : b) {
            System.out.print(i + "  ");
        }
	}

}
