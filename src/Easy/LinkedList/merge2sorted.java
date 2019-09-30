package Easy.LinkedList;

public class merge2sorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(4);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = null;
		
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(3);
		ListNode b3 = new ListNode(4);
		
		b1.next = b2;
		b2.next = b3;
		b3.next = null;
		
		ListNode head = mergeTwoListsV4(a1, b1);
		
		while(head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        if (l1 != null){
            head = l1;
            if(l1.next != null){
                l1 = l1.next;   
            }
            ListNode curr = head;
            while(l1 != null || l2 != null){
                if (l2 != null){
                    curr.next = l2;
                    curr = curr.next;
                    l2 = l2.next;
                }
                if (l1 != null){
                    curr.next = l1;
                    curr = curr.next;
                    l1 = l1.next;
                }
            }
            return head;
        } else if (l2 != null){
            head = l2;
            if(l2.next != null){
                l2 = l2.next;   
            }
            ListNode curr = head;
            while(l1 != null || l2 != null){
                if (l1 != null){
                    curr.next = l1;
                    curr = curr.next;
                    l1 = l1.next;
                }
                if (l2 != null){
                    curr.next = l2;
                    curr = curr.next;
                    l2 = l2.next;
                }
            }
            return head;
        } else {
            return null;
        }
        
    }
	
	public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        int headFlag = 0;
        while(l1 != null && l2 != null){
            if (l2.val <= l1.val){
                if(headFlag == 0){
                    curr = l2;
                    head = curr;
                    headFlag++;
                } else {
                    curr.next = l2;
                }
                curr = curr.next;
                l2 = l2.next;
            }
            if (l1.val <= l2.val){
                if(headFlag == 0){
                    curr = l1;
                    head = curr;
                    headFlag++;
                } else {
                    curr.next = l1;
                }
                curr = curr.next;
                l1 = l1.next;
            }
        }
        while(l1 != null){
            if(headFlag == 0){
                curr = l2;
                head = curr;
                headFlag++;
            } else {
                curr.next = l1;
            }
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2 != null){
            if(headFlag == 0){
                curr = l2;
                head = curr;
                headFlag++;
            } else {
                curr.next = l2;
            }
            curr = curr.next;
            l2 = l2.next;
        }
        return head;
    }

	@SuppressWarnings("unused")
	public static ListNode mergeTwoListsV3(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = new ListNode(0);
        boolean head1 = false;
        ListNode start = null;
		while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                node = l1;
                if(!head1){
                    start = node;
                    head1 = true;
                }
                l1 = l1.next;
            } else {
                node = l2;
                if(!head1){
                    start = node;
                    head1 = true;
                }
                l2 = l2.next;
            }
            node = node.next;
        }
        while(l1 != null){
            node = l1;
            l1 = l1.next;
            node = node.next;
        }
        while(l2 != null){
            node = l2;
            l2 = l2.next;
            node = node.next;
        }
        return start;
    }
	
	public static ListNode mergeTwoListsV4(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode prev = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return result.next;
    }
}
