import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int h = citations.length;
        if (citations[0] >= h) return h;
        for (int i = 0; i < citations.length - 1; i++) {
            h = citations.length - i - 1;
            if (citations[i + 1] >= h && citations[i] <= h) return h;
        }
        return answer;
    }
}