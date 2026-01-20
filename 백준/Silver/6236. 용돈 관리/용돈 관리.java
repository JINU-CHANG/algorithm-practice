import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        values = new int[n];

        int min = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, values[i]);
        }

        System.out.println(lowerBound(min));
    }

    private static int lowerBound(int min) {
        int left = min;
        int right = Integer.MAX_VALUE - min;

        while (left < right) {
            int mid = (left + right) / 2;
            if (canDraw(mid)) right = mid;
            else left = mid + 1;
        }

        return right;
    }

    private static boolean canDraw(int k) {
        int left = 0;
        int count = 0;
        for (int x : values) {
            if (left < x) {
                count++;
                left = k;
            }
            left = left - x;
        }

        return 0 < count && count <= m;
    }
}
