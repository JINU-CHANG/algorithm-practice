import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<String> strs = new ArrayList<>();
        for (int i : numbers) {
            strs.add(String.valueOf(i));
        }
        
        Collections.sort(strs, (o1, o2) -> {
            int x = Integer.parseInt(o1 + o2);
            int y = Integer.parseInt(o2 + o1);
            return -(x - y);
        });
        
        if (strs.get(0).equals("0")) return "0";
        
        for (String s : strs) {
            answer.append(s);
        }
        
        return answer.toString();
    }
}