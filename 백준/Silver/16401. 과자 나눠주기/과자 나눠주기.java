import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static int n;
    static int longest = Integer.MIN_VALUE;
    static int[] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        snacks = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            longest = Math.max(longest, snacks[i]);
        }

        System.out.println(search());
    }

    public static int search() { //upper bound
        int left = 1;
        int right = longest;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (num(mid) < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static long num(int x) {
        long num = 0;

        for (int height : snacks) {
            num += height / x;
        }

        return num;
    }
}
