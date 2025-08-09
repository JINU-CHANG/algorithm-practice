import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] ans = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
                 dq.pollLast();
            }

            dq.offerLast(i);
            int left = i - l + 1;
            if (dq.peekFirst() < left) dq.pollFirst();
            ans[i] = arr[dq.peekFirst()];
        }

        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }
}
