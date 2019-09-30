package Medium.LinkedList;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode answer = null;
		ListNode head = answer;
		ListNode carry = new ListNode(0);
		int sum;
		while(l1 != null && l2 != null) {
			sum = l1.val + l2.val + carry.val;
			if(sum >= 10) {
				int baseVal = sum/10;
				int carryVal = sum%10;
				carry.next.val = carryVal;
				carry = carry.next;
				answer.val = baseVal;
				answer = answer.next;
			} else {
				carry.next.val = 0;
				carry = carry.next;
				answer.val = sum;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null) {
			answer.val = l1.val;
			answer = answer.next;
			l1 = l1.next;
		}
		while(l2 != null) {
			answer.val = l2.val;
			answer = answer.next;
			l2 = l2.next;
		}
		
		int returnAnswer = 0;
		int baseMultiplier = 1;
		while(head != null) {
			returnAnswer = returnAnswer + head.val*baseMultiplier;
			baseMultiplier = baseMultiplier*10;
			head = head.next;
		}
		return returnAnswer;
	}
}
