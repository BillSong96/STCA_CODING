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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ln = head;
        head = head.next;
        ln.next = head.next;
        head.next = ln;
        while (ln.next != null && ln.next.next != null) {
            ListNode temp = ln.next;
            ln.next = temp.next;
            temp.next = ln.next.next;
            ln.next.next = temp;
            ln = ln.next.next;
        }
        return head;
    }
}