package lectures.stack;

import java.util.Stack;

/** 
 * @author Yu
 * @date 2017年8月30日
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class StackMin {

	private Stack<Integer> stackData = new Stack<Integer>();
    private Stack<Integer> stackMin = new Stack<Integer>();

    public void push(int node) {
        stackData.push(node);
        if (stackMin.isEmpty() || stackMin.peek() >= node) {
            stackMin.push(node);
        }
    }

    public void pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stackData is empty!");
        }

        if (stackData.peek() == stackMin.peek()) {
            stackMin.pop();
        }

        stackData.pop();
    }

    public int top() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stackData is empty!");
        }

        return stackData.peek();
    }

    public int min() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stackMin is empty!");
        }

        return stackMin.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
