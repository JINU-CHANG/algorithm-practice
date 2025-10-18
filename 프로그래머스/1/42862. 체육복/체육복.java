import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 1];
        
        Arrays.fill(arr, 1);
        for (int l : lost) {
            arr[l] = 0;
        }
        
        for (int r : reserve) {
            arr[r] += 1;
        }
        
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 2 && i == 1) {
                if (arr[i + 1] == 0) arr[i + 1] += 1;
                continue;
            } else if (arr[i] == 2 && i == n) {
                if (arr[i - 1] == 0) arr[i - 1] += 1;
                continue;
            }
            
            if (arr[i] == 2) {
                if (arr[i - 1] == 0) arr[i - 1] += 1;
                else if (arr[i + 1] == 0) arr[i + 1] += 1;
            }    
        }
        
        for (int i = 1; i <= n; i++) {
            if (arr[i] >= 1) answer++;
        }
        
        return answer;
    }
}