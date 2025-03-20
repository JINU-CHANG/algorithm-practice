import java.util.*;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        
        if (s.length() == 1) return 1;
        for (int i = 1; i <= s.length() / 2; i++) {
            String pattern = s.substring(0, i);
            StringBuffer sb = new StringBuffer();

            int cnt = 1;
            for (int j = i; j <= s.length() - i; j += i) {
                String check = s.substring(j, j + i);

                if (pattern.equals(check)) { // b a
                    cnt++;
                } else {
                    if (cnt > 1) sb.append(cnt).append(pattern);
                    else sb.append(pattern);

                    pattern = check;
                    cnt = 1;
                }
            }

            if (cnt > 1) sb.append(cnt).append(pattern);
            else sb.append(pattern);
            min = Math.min(min, sb.length() + s.length() % i);
        }

        return min;
    }
}