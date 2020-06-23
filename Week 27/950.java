class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] order = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) dq.offerLast(i);
        int index = 0;
        while (true) {
            order[index++] = dq.pollFirst();
            if (dq.isEmpty()) break;
            dq.offerLast(dq.pollFirst());
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) ret[order[i]] = deck[i];
        return ret;
    }
}