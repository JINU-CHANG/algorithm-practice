import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] expectedRanks;
    static long currentRank = 0;
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        expectedRanks = new int[n];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            expectedRanks[i] = x;
        }

        Arrays.sort(expectedRanks);
        for (int i = 0; i < n; i++) {
            currentRank++;
            ans += Math.abs((expectedRanks[i] - currentRank));
        }

        System.out.println(ans);
    }
}
