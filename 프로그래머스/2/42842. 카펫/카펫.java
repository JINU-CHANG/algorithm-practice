import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for (int x = 1; x <= yellow; x++) { // 노란색 가로
            int y = yellow / x;
            if (yellow % x == 0 && x >= y && 2 * x + 2 * y + 4 == brown) {
                System.out.println(x);
                int bx = x + 2;
                int by = y + 2;
                
                answer = new int[] {bx, by};
                return answer;
            }     
        }
        
        return answer;
    }
}