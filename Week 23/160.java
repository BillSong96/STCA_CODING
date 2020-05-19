/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode ln1 = headA, ln2 = headB;
        int diff = 0;
        while (ln1.next != null) {
            ln1 = ln1.next;
            diff++;
        }
        while (ln2.next != null) {
            ln2 = ln2.next;
            diff--;
        }
        if (ln1 != ln2) return null;
        ln1 = headA;
        ln2 = headB;
        if (diff > 0) {
            while (diff > 0) {
                ln1 = ln1.next;
                diff--;
            }
        }
        else if (diff < 0) {
            while (diff < 0) {
                ln2 = ln2.next;
                diff++;
            }
        }
        while (ln1 != ln2) {
            ln1 = ln1.next;
            ln2 = ln2.next;
        }
        return ln1;
    }
}