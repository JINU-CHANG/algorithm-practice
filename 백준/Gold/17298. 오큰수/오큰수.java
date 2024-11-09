import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] array;
    static int[] answer;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        array = new int[n];
        answer = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void solve() {
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {
                int topIdx = stack.peek();
                int top = array[topIdx];

                if (top >= array[i]) break;

                Integer popIdx = stack.pop();
                answer[popIdx] = array[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int topIdx = stack.pop();
            answer[topIdx] = -1;
        }
    }
}
