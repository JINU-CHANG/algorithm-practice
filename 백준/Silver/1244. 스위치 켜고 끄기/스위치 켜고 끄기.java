import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int sNum;
    static int[] switchStatus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        switchStatus = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }

        sNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < sNum; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) change1(b);
            else change2(b);
        }

        for (int i = 1; i <= n; i++) {
            sb.append(switchStatus[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void change1(int x) {
        for (int i = x; i <= n; i = i + x) {
            changeStatus(i);
        }
    }

    private static void change2(int x) {
        changeStatus(x);

        for (int i = 1; i <= n; i++) {
            int left = x - i;
            int right = x + i;

            if (left <= 0 || right > n) break;
            if (switchStatus[left] != switchStatus[right]) break;
            changeStatus(left);
            changeStatus(right);
        }
    }

    private static void changeStatus(int x) {
        if (switchStatus[x] == 0) {
            switchStatus[x] = 1;
        } else {
            switchStatus[x] = 0;
        }
    }

}
