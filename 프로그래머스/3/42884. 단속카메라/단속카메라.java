import java.util.*;

class Info implements Comparable<Info> {
    int start;
    int end;
    
    Info(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int compareTo(Info i) {
        return this.end - i.end; // 오름차순
    }
}

class Solution {
    
    public int solution(int[][] routes) {
        Queue<Info> pq = new PriorityQueue<>();    
        for (int i = 0; i < routes.length; i++) {
            pq.add(new Info(routes[i][0], routes[i][1]));
        }
        
        Info current = pq.poll();
        int count = 1;
        
        while (!pq.isEmpty()) {
            Info polled = pq.poll();
            if (polled.start <= current.end) continue;

            current = polled;
            count++;
        }
        
        return count;
    }
}