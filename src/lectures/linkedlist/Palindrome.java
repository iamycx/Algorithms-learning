package lectures.linkedlist;
/** 
 * @author Yu
 * @date 2017年8月31日
 * 
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 *
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 */
public class Palindrome {

	public boolean isPalindrome(ListNode pHead) {
		if(pHead==null)
			return false;
		
		ListNode slow = pHead;
		ListNode quick = pHead;
		while(quick.next!=null&&quick.next.next!=null){
			slow = slow.next;
			quick = quick.next.next;
		}
		
		boolean res = false;
		ListNode mid = slow;
		if(quick.next==null){
			ListNode tail = reverse(mid);
			res = meetToMid(pHead,tail);
			reverse(tail);
		}else {
			mid = slow.next;
			slow.next = null;
			ListNode tail = reverse(mid);
			res = meetToMid(pHead, tail);
			slow.next = reverse(tail);
		}
		return res;
	}
	private boolean meetToMid(ListNode head, ListNode tail) {
		// TODO Auto-generated method stub
		while(head!=null && tail!=null){
			if(head.val!=tail.val)
				return false;
			head = head.next;
			tail = tail.next;
		}
		return (head==null&&tail==null);
	}
	private ListNode reverse(ListNode head) {
		// TODO Auto-generated method stub
		ListNode newHead = null;
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            newHead = current;
            newHead.next = pre;
            pre = current;
            current = next;
        }
        return newHead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 3, 2, 1};
        Palindrome p = new Palindrome();
        ListNode head = ListNode.createList(a);
        boolean b = p.isPalindrome(head);
        System.out.println(b);
	}

}
