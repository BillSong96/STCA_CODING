/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head, evenHead = head.next, oddTail = head, evenTail = head.next;
        head = evenHead.next;
        while (head != null) {
            oddTail.next = head;
            oddTail = head;
            head = head.next;
            if (head == null) break;
            evenTail.next = head;
            evenTail = head;
            head = head.next;
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }
}