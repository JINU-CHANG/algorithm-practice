import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long start = N - (9 * String.valueOf(N).length());

        for (long i = start; i < N; i++) {
            String s = String.valueOf(i);
            long sum = i;
            for (int j = 0; j < s.length(); j++) {
                sum += s.charAt(j) - '0';
            }

            if (sum == N) {
                System.out.println(i);
                break;
            }

            if (i == N-1) {
                System.out.println(0);
            }
        }
    }
}
