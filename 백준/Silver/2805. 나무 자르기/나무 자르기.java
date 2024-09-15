import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        System.out.println(search());
    }

    public static int search() {
        int left = 0;
        int right = trees[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (sum(mid) < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static long sum(int x) {
        long sum = 0;

        for (int height : trees) {
            if (height - x >= 0) {
                sum += height - x;
            }
        }
        return sum;
    }
}
