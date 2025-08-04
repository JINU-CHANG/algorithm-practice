import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        sb.append(0).append(" ");
        for (int i = 1; i < n; i++) {
            while (true) {
                if (stack.isEmpty() || arr[stack.peek()] >= arr[i]) break;
                stack.pop();
            }

            if (stack.isEmpty()) sb.append(0).append(" ");
            else sb.append(stack.peek() + 1).append(" ");

            stack.push(i);
        }

        System.out.println(sb);
    }
}
