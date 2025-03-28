import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k;
        int[] array;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int sum = 0;
        int answer = Integer.MIN_VALUE;
        for (int end = 0; end < n; end++) {
            if (end < k) {
                sum += array[end];
            }

            if (end == k - 1) {
                answer = Math.max(answer, sum);
            }

            if (end > k - 1) {
                sum += array[end];
                sum -= array[start];
                start++;
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);
    }
}
