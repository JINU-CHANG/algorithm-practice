import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> position = new ArrayList<>();
        while (true) {
            int x = Integer.parseInt(st.nextToken());

            if (x == 0) break;
            position.add(x);
        }

        if (position.isEmpty()) {
            System.out.println("0");
            return;
        }

        int[][] dp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int c = 0; c < position.size(); c++) {
            int[][] nDp = new int[5][5];
            for (int k = 0; k < 5; k++) {
                Arrays.fill(nDp[k], Integer.MAX_VALUE);
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (dp[i][j] == Integer.MAX_VALUE) continue;

                    int value = dp[i][j];
                    int nextPosition = position.get(c);

                    nDp[nextPosition][j] = Math.min(nDp[nextPosition][j], value + getPower(i, nextPosition)); // 왼쪽 움직이기
                    nDp[i][nextPosition] = Math.min(nDp[i][nextPosition], value + getPower(j, nextPosition)); // 오른쪽 움직이기
                }
            }

            dp = nDp;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            ans = Math.min(ans, dp[position.get(position.size() - 1)][i]);
            ans = Math.min(ans, dp[i][position.get(position.size() - 1)]);
        }

        System.out.println(ans);
    }

    public static int getPower(int x, int y) {
        if (x == 0 || y == 0) return 2;
        if (x == 1 && y == 3) return 4;
        if (x == 3 && y == 1) return 4;
        if (x == 2 && y == 4) return 4;
        if (x == 4 && y == 2) return 4;
        if (x == y) return 1;
        return 3;
    }
}
