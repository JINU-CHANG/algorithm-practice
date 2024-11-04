import java.util.*;

class Solution {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        int count = 0;
        int idx = 0;
        int end = 0;
        int total = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.add(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] polled = pq.poll();
                total += polled[1] + (end - polled[0]);
                end += polled[1];
                count++;
            }
        }

        return total / jobs.length;
    }
}