import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static char[] stopChars = {'<' , '>'};
    static char[] is;
    static int[] ans;
    static int end = 0;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(st.nextToken());
        is = new char[k];
        ans = new int[k + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            is[i] = st.nextToken().charAt(0);
        }

        for (int i = 9; i >= 0; i--) {
            queue.add(i);
        }
        solve(0);

        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        sb.append("\n");

        end = 0;
        queue = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        solve(1);

        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
        }

        System.out.println(sb.toString());
    }

    public static void solve(int idx) {
        for (int i = 0; i < k; i++) {
            if (is[i] == stopChars[idx]) {
                int count = 0;
                while (i + count < k && is[i + count] == stopChars[idx]) {
                    count++;
                }

                for (int j = (i + count); j >= i; j--) {
                    ans[j] = queue.poll();
                }

                i += count;
                end += count + 1;

                if (i == k - 1) {
                    ans[end] = queue.poll();
                }
            } else if (i == 0 || i < k) {
                ans[end] = queue.poll();
                end++;

                if (i == k - 1) {
                    ans[end] = queue.poll();
                }
            }
        }
    }
}
