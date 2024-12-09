import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static Integer[] ropes;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ropes = new Integer[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, (o1, o2) -> o2 - o1);
        System.out.println(solve());
    }

    public static int solve() {
        int sum = ropes[0];
        int max = sum;
        for (int i = 1; i < n; i++) {
            sum = ropes[i] * (i + 1);
            max = Math.max(max, sum);
        }

        return max;
    }
}
