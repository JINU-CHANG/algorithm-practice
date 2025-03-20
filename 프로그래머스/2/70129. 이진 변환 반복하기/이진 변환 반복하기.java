import java.util.*;

class Solution {
    
    static int count;
    static int deleted;
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
         while (!s.equals("1")) {
            s = delete0(s);
            s = Long.toBinaryString(s.length());
            count++;
          }
  
        answer[0] = count;
        answer[1] = deleted;
        
        return answer;
    }
    
    private static String delete0(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                deleted++;
                continue;
            }
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}