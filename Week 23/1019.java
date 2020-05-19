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
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            n++;
            list.add(temp.val);
            temp = temp.next;
        }
        int[] ret = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && list.get(i) >= st.peek()) st.pop();
            ret[i] = st.empty() ? 0 : st.peek();
            st.push(list.get(i));
        }
        return ret;
    }
}