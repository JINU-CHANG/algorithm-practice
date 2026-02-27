import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            int x = number.charAt(i) - '0';
            if (stack.isEmpty()) {
                stack.push(x);
                continue;
            }
            
            while (!stack.isEmpty() && k > 0 && stack.peek() < x) {
                stack.pop();
                k--;
            }
            
            stack.push(x);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }
}