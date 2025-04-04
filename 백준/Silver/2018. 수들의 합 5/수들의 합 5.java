import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 1; i < n; i++) {
            long sum = i;
            for (int j = i + 1; j < n; j++) {
                sum += j;
                if (sum > n) break;
                if (sum == n) answer++;
            }
        }

        System.out.println(answer + 1);
    }
}
