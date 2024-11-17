import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int t, n;
    static int[] array;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(st.nextToken());
        for (int k = 0; k < t; k++) {
            n = Integer.parseInt(br.readLine());
            array = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                array[x] = y;
            }

            sb.append(solve()).append("\n");
        }

        System.out.println(sb);
    }

    public static int solve() {
        Stack<Integer> stack = new Stack<>();
        stack.push(array[1]);
        for (int i = 2; i < n + 1; i++) {
            if (stack.peek() < array[i]) continue;
            stack.push(array[i]);
        }

        return stack.size();
    }
}
