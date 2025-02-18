import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;

        String s = br.readLine();
        while (!s.contains("-")) {
            int ans = 0;
            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                Character current = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(current);
                    continue;
                }

                Character peeked = stack.peek();
                if (peeked == '{' && current == '}') stack.pop();
                else stack.push(current);
            }

            while (!stack.isEmpty()) {
                Character second = stack.pop();
                Character first = stack.pop();

                if (first != '{') ans++;
                if (second != '}') ans++;
            }

            sb.append(count).append(". ").append(ans).append("\n");
            count++;
            s = br.readLine();
        }

        System.out.println(sb);
    }
}
