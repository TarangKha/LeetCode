package Easy.LinkedList;

import java.util.ArrayList;

public class removeNthNodeFromEndOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(5);
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = null;
		
		ListNode start = removeNthFromEnd2(head, 2);
		while(start != null) {
			System.out.println(start.val);
			start = start.next;
		}
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0){
            return head;
        }
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr;
            for(int i = 0; i < n; i++){
                if (temp.next == null){
                    curr.val = curr.next.val;
                    curr.next = curr.next.next;
                    return head;
                }
                temp = temp.next;
            }
            curr = curr.next;    
        }
        return null;
    }
	
	
	 public static ListNode removeNthFromEnd2(ListNode head, int n) {
	        ArrayList<ListNode> sol = new ArrayList<ListNode>();
	        ListNode curr = head;
	        while(curr.next != null){
	            sol.add(curr);
	            curr = curr.next;
	        }
	        sol.add(curr);
	       // ListNode delete = sol.remove(sol.size() - n+ 1 );
	        System.out.println(sol.get(sol.size() - n).val);
	        // System.out.println(sol);
	        System.out.println(sol.size());
	        ListNode prev = sol.get(sol.size() - n - 1);
	        ListNode next = sol.get(sol.size() - n + 2 - 1);
	        
	        prev.next = next;
	        return head;
	    }

}
