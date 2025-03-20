import java.util.*;

class Solution {
    
    static char[] result;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        for (int i = 1; i <= numbers.length(); i++) {
            result = new char[i];
            dfs(-1, -1, numbers, i);
        }
        return set.size();
    }
    
    private static void dfs(int idx, int cnt, String numbers, int length) {
        if (cnt == length - 1) {
            int x = Integer.parseInt(String.valueOf(result));

            if (x == 0 || x == 1) return;
            for (int i = 2; i < x; i++) {
                if (x % i == 0) return;
            }
            
            set.add(x);
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (i == idx) continue;
            if (visited[i]) continue;
            
            visited[i] = true;
            result[cnt + 1] = numbers.charAt(i);
            dfs(i, cnt + 1, numbers, length);
            visited[i] = false;
        }
    }
}