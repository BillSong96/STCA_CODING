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
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }
        int ret = 0;
        boolean flag = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!flag) {
                    flag = true;
                    ret++;
                }
            }
            else flag = false;
            head = head.next;
        }
        return ret;
    }
}