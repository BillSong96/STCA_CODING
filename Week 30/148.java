class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        ListNode pivot = head, 
                 dumSmall = new ListNode(), dumLarge = new ListNode(), dumEq = new ListNode(),
                 curSmall = dumSmall, curLarge = dumLarge, curEq = dumEq;
        while (head != null) {
            if (head.val < pivot.val) {
                curSmall.next = head;
                curSmall = curSmall.next;
            }
            else if (head.val > pivot.val) {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            else {
                curEq.next = head;
                curEq = curEq.next;
            }
            head = head.next;
        }
        curSmall.next = null;
        curLarge.next = null;
        dumSmall.next = sortList(dumSmall.next);
        dumLarge.next = sortList(dumLarge.next);
        head = dumSmall;
        while (head.next != null)
            head = head.next;
        head.next = dumEq.next;
        curEq.next = dumLarge.next;
        return dumSmall.next;
    }
}