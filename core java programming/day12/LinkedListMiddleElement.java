package day12;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val=x;
		next=null;
	}
}

public class LinkedListMiddleElement {
	public static ListNode findMiddleElement(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null&& fast.next != null) {
			slow = slow.next;
			fast=fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head=new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode middle = findMiddleElement(head);
		if(middle!=null) {
			System.out.println("the middle element is:" + middle.val);
		}
		else
		{
			System.out.println("the linked list is empty.");
		}
		
	}

}
