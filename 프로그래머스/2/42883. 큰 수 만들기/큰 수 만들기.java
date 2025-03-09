import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        String answer = "";
        
        int sIdx = 0;
        int eIdx = number.length() - (number.length() - k - 1);
        for (int i = 0; i < number.length() - k; i++) {
            int maxIdx = search(number, sIdx, eIdx);
            answer += number.charAt(maxIdx);
            sIdx = maxIdx + 1;
            if (eIdx < number.length()) eIdx++;
        }
        
        return answer;
    }
    
    private int search(String number, int sIdx, int eIdx) {
        int max = Integer.MIN_VALUE;
        int maxIdx = eIdx;
        for (int i = sIdx; i < eIdx; i++) {
            if (number.charAt(i) > max) {
                maxIdx = i;
                max = number.charAt(i);
            }
        }
        
        return maxIdx;
    }
}