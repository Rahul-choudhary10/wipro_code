package day12;


public class Solution {
	public void removeDuplicates(ListNode head) {
		ListNode current=head;
		
		while(current!=null && current.next !=null) {
			if(current.val==current.next.val) {
				current.next=current.next.next;
			}
			else {
				current=current.next;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head=new ListNode(1);
		head.next= new ListNode(1);
		head.next.next= new ListNode(2);
		head.next.next.next= new ListNode(3);
		head.next.next.next.next= new ListNode(3);
		head.next.next.next.next.next= new ListNode(4);
		head.next.next.next.next.next.next= new ListNode(4);
		head.next.next.next.next.next.next.next= new ListNode(4);
		head.next.next.next.next.next.next.next.next= new ListNode(5);
		
		Solution solution = new Solution();
		solution.removeDuplicates(head);
		
		ListNode current=head;
		while(current!=null) {
			System.out.println(current.val +" ");
			current=current.next;
		}
	}

}
