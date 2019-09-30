package Medium.LinkedList;

import java.util.*;
import java.io.*;

public class OddEvenList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode start = head;
		for(int i = 2; i < 7; i++) {
			start.next = new ListNode(i);
			start = start.next;
		}
		ListNode begin = head;
		while(begin != null) {
			System.out.print(begin.val + " ");
			begin = begin.next;
		}
		System.out.println();
		head = oddEvenList_Sol(head);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public ListNode oddEvenList(ListNode head) {
        //if <= 2 - do nothing
        if(head.next.next == null){
            return head;
        }
        ListNode orderP =  head.next;
        int orderCount = 0;
        ListNode oddP = head.next.next;
        ListNode evenP = head.next;
        while(oddP != null){ //&& evenP != null
            swap(orderP, oddP);
            orderP = orderP.next;
            orderCount++;
            if(oddP.next != null){
                oddP = oddP.next.next;
            } else {
                break;
            }
            /*
            if(evenP.next.next != null){
                evenP = evenP.next.next;    
            }
            */
        }
        if(orderCount%2 == 0){
            oddP = orderP.next;
            //evenP = orderP;
        } else {
            oddP = orderP.next.next;
            orderP = orderP.next;
            //evenP = orderP;
        }
        while(oddP != null){//&& evenP != null
            swap(orderP, oddP);
            orderP = orderP.next;
            orderCount++;
            if (oddP.next != null){
                oddP = oddP.next.next;
            } else {
                break;
            }
        }
        return head;
    }
    
    public void swap(ListNode a, ListNode b){
        if (a !=null&&  b!=null) {  
            ListNode temp = a.next;  
            a.next = b.next;  
            b.next = temp;      
        }
    }
    
    public static ListNode oddEvenList_Sol(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	if(head.next == null) {
    		return head;
    	}
    	ListNode oddHead = head;
    	ListNode evenHead = head.next;
    	ListNode odd = oddHead;
    	ListNode even = evenHead;
    	
    	while(even != null && even.next != null) {
    		odd.next = odd.next.next;
    		even.next = even.next.next;
    		odd = odd.next;
    		even = even.next;
    	}
    	odd.next = evenHead;
    	
    	return oddHead;
    }
}
