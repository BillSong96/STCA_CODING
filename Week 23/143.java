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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int len = list.size();
        if (len == 0) return;
        int i = 0;
        while (len / 2 != i) {
            if (len / 2 > i) {
                list.get(i).next = list.get(len - 1 - i);
                i = len - 1 - i;
            }
            else {
                list.get(i).next = list.get(len - i);
                i = len - i;
            }
        }
        list.get(i).next = null;
    }
}