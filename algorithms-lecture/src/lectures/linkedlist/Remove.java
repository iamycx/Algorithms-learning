package src.lectures.linkedlist;
/** 
 * @author Yu
 * @date 2017年8月30日
 * 
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定待删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 */
public class Remove {

	public boolean removeNode(ListNode A) {
		if(A == null||A.next==null)
			return false;
		ListNode next = A.next;
		
		A.val = next.val;
		A.next = next.next;
		return true;
		
	}
}
