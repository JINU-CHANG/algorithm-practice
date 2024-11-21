import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, M;
    static boolean[][] dp;
    static int[] volumes;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        volumes = new int[N];
        dp = new boolean[N][M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        // 초기값 셋팅
        int first = S - volumes[0];
        int second = S + volumes[0];
        if (first >= 0) dp[0][first] = true;
        if (second <= M) dp[0][second] = true;

        solve();

        // 최대값 확인
        for (int i = 0; i < M + 1; i++) {
            if (dp[N - 1][i]) {
                answer = Math.max(answer, i);
            }
        }

        // 정답 출력
        if (answer == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void solve() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M + 1; j++) {
                if (dp[i][j]) {
                    int first = j - volumes[i + 1];
                    int second = j + volumes[i + 1];

                    if (first >= 0) dp[i + 1][first] = true;
                    if (second <= M) dp[i + 1][second] = true;
                }
            }
        }
    }
}
