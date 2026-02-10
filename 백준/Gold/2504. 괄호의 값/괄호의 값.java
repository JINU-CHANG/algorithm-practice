import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        List<String> strList = List.of("(", ")", "[", "]");

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')' || c == ']') {
                // pop
                int sum = 0;
                boolean ansFlag = false;
                while (!stack.isEmpty()) {
                    if (c == ')' && stack.peek().equals("(")) {
                        stack.pop();
                        if (sum == 0) stack.push(String.valueOf(2));
                        else stack.push(String.valueOf(sum * 2));
                        ansFlag = true;
                        break;
                    }

                    if (c == ']' && stack.peek().equals("[")) {
                        stack.pop();
                        if (sum == 0) stack.push(String.valueOf(3));
                        else stack.push(String.valueOf(sum * 3));
                        ansFlag = true;
                        break;
                    }

                    if (!strList.contains(stack.peek())) {
                        sum += Integer.parseInt(stack.pop());
                        continue;
                    }

                    break;
                }

                if (!ansFlag) {
                    System.out.println("0");
                    return;
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            if (strList.contains(stack.peek())) {
                System.out.println(0);
                return;
            }
            sum += Integer.parseInt(stack.pop());
        }

        System.out.println(sum);
    }
}
