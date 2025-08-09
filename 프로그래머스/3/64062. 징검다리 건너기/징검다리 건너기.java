import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            while (!dq.isEmpty() && stones[dq.peekLast()] <= stones[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            int left = i - k + 1;
            if (dq.peekFirst() < left) dq.pollFirst();

            if (i >= k - 1) {
                ans = Math.min(ans, stones[dq.peekFirst()]);
            }
        }
        return ans;
    }
}
