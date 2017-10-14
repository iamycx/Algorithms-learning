package src.lectures.stack;

import java.util.Stack;

/** 
 * @author Yu
 * @date 2017年8月30日
 * 
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，
 * 而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 *
 * 测试样例：
 * [4,3,2,1],4
 * 返回：[1,2,3,4]
 */
public class StackReverse {

	public int[] stackReverse(int[] A,int n) {
		if(A==null||n==0)
			return null;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=n-1;i>=0;i--){
			stack.push(A[i]);
		}
		
		reverse(stack);
		
		int i =0;
		int[] res = new int[n];
		while(!stack.isEmpty()){
			res[i] = stack.pop();
			i++;
		}
		return res;
	}
	
	private void reverse(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if(stack.isEmpty()) return;
		int bottom = get(stack);
        reverse(stack);
        stack.push(bottom);
	}
	
	private int get(Stack<Integer> stack) {
        int current = stack.pop();
        if (stack.isEmpty()) {
            return current;
        } else {
            int last = get(stack);
            stack.push(current);
            return last;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackReverse sr = new StackReverse();
        int[] a = {1, 2, 3, 4};
        int[] b = sr.stackReverse(a, a.length);
        for (int i : b) {
            System.out.print(i + ",");
        }
	}

}
