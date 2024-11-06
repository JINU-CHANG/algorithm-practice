import java.util.*;

class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        int answer = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            Integer first = pq.poll();
            Integer second = pq.poll();

            pq.add(first + second * 2);
            answer++;
        }

        if (pq.peek() < K) return -1;
        return answer;
    }
}