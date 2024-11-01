import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       n = Integer.parseInt(st.nextToken());

       array = new int[n];
       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < n; i++) {
           array[i] = Integer.parseInt(st.nextToken());
       }

       solve();
        System.out.println(sb);
    }

    public static void solve() {
        int minIdx = 0;
        int maxIdx = 0;
        int realMinIdx = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] > array[maxIdx]) {
                maxIdx = i;
            }

            if (array[i] < array[minIdx] && i < maxIdx) {
                minIdx = i;
            }

            if (array[maxIdx] - array[minIdx] < array[i] - array[realMinIdx]) {
                maxIdx = i;
                minIdx = realMinIdx;
            }

            sb.append(array[maxIdx] - array[minIdx]).append(" ");

            if (array[i] < array[realMinIdx]) {
                realMinIdx = i;
            }
        }
    }
}
