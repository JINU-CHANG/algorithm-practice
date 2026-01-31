import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!stack.isEmpty() && stack.peek() == 'A' && c == 'P') {
                if (stack.size() < 3) {
                    System.out.println("NP");
                    return;
                }
                stack.pop();
                char x1 = stack.pop();
                char x2 = stack.pop();

                if (!(x1 == 'P' && x2 == 'P')) {
                    System.out.println("NP");
                    return;
                }

                stack.add('P');
                continue;
            }

            stack.add(c);
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
