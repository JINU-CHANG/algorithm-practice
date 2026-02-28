import java.util.*;

class Solution {
    
    boolean[] visited;
    char[] temp;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        for (int i = 1; i <= numbers.length(); i++) {
            visited = new boolean[numbers.length()];
            temp = new char[i];
            search(i, numbers, 0);
        }
        
        for (int x : set) {
            if (check(x)) answer++;
        }
        
        return answer;
    }
    
    private void search(int n, String numbers, int count) {
        if (count == n) {
            set.add(Integer.parseInt(String.valueOf(temp)));
            return;    
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            temp[count] = numbers.charAt(i);
            search(n, numbers, count + 1);
            visited[i] = false;
        }
    }
    
    private boolean check(int x) {
        if (x == 1) return false;
        int count = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) count++;
        }
        
        if (count == 2) return true;
        else return false;
    }
}