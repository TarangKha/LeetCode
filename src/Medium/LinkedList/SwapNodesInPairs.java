package Medium.LinkedList;

import java.util.*;
import java.io.*;

public class SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LinkedList<ListNode> test = new LinkedList<ListNode>();
		ListNode head = new ListNode(1);
		ListNode start = head;
		for(int i = 2; i < 6; i++) {
			start.next = new ListNode(i);
			start = start.next;
		}
		ListNode begin = head;
		while(begin != null) {
			System.out.print(begin.val + " ");
			begin = begin.next;
		}
		System.out.println();
		ListNode swappedHead = swapPairs(head);
		while(swappedHead != null) {
			System.out.print(swappedHead.val + " ");
			swappedHead = swappedHead.next;
		}
	}
	
	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode start = head.next;
		head.next = head.next.next;
		start.next = head; 
		start.next.next = swapPairs(head.next);
		return start;
	}

}
