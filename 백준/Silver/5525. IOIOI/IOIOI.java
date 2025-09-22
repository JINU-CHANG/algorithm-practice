import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int length = n + n + 1;
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (shouldRemove(stack, c)) {
                stack = new Stack<>();
            }

            stack.push(c);
            if (c == 'I' && stack.size() >= length) ans++;
        }

        System.out.println(ans);
    }

    private static boolean shouldRemove(Stack<Character> stack, char c) {
        if (!stack.isEmpty() && stack.peek() == 'O' && c != 'I') return true;
        if (!stack.isEmpty() && stack.peek() == 'I' && c != 'O') return true;
        if (stack.isEmpty() && c != 'I') return true;

        return false;
    }
}
