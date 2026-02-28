import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visited = new boolean[words.length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{-1, 0});
        
        while (!q.isEmpty()) {
            int[] polled = q.poll();   
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                
                // 한글자 바뀌는지 체크
                String str1;
                if (polled[0] == -1) {
                    str1 = begin;
                } else {
                    str1 = words[polled[0]];
                }
                String str2 = words[i];
                
                if (str1.length() != str2.length()) continue;
                
                int count = 0;
                for (int j = 0; j < str1.length(); j++) {
                    if (str1.charAt(j) != str2.charAt(j)) count++;
                }
                
                if (count == 1 && str2.equals(target)) {
                    return polled[1] + 1;
                }
                
                if (count == 1) {
                    visited[i] = true;
                    q.add(new int[]{i, polled[1] + 1});
                }
            }
        }
        
        return answer;
    }
}