import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int f = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            switch (f) {
                case 1 -> sb.append(query1(k)).append("\n");
                case 2 -> sb.append(query2(k)).append("\n");
                case 3 -> {
                    long j = Long.parseLong(st.nextToken());
                    sb.append(query3(k, j)).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static int query1(long k) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return arr.length - left;
    }

    public static int query2(long k) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return arr.length - left;
    }

    public static int query3(long k, long j) {
        return query1(k) - query2(j);
    }
}
