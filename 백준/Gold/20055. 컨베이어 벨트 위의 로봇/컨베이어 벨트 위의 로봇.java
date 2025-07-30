import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] AArr = new int[2][n];
        boolean[][] robotArr = new boolean[2][n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            AArr[0][i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n - 1; i >= 0; i--) {
            AArr[1][i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        while (true) {
            answer++;
            int temp1 = AArr[0][0];
            int temp2 = 0;
            for (int i = 1; i < n; i++) {
                temp2 = AArr[0][i];
                AArr[0][i] = temp1;
                temp1 = temp2;
            }

            for (int i = n - 1; i >= 0; i--) {
                temp2 = AArr[1][i];
                AArr[1][i] = temp1;
                temp1 = temp2;
            }

            AArr[0][0] = temp1;

            // 로봇 이동
            boolean temp3 = robotArr[0][0];
            boolean temp4 = false;
            for (int i = 1; i < n; i++) {
                temp4 = robotArr[0][i];
                robotArr[0][i] = temp3;
                temp3 = temp4;
            }

            robotArr[0][0] = false;

            // 내리는 위치 확인
            if (robotArr[0][n - 1]) robotArr[0][n - 1] = false;

            // 로봇 이동
            for (int i = n - 1; i >= 0; i--) {
                if (robotArr[0][i]) {
                    if (i != n - 1 && !robotArr[0][i + 1] && AArr[0][i + 1] > 0) {
                        robotArr[0][i + 1] = true;
                        robotArr[0][i] = false;

                        AArr[0][i + 1] -= 1;
                        if (i + 1 == n - 1) robotArr[0][n - 1] = false;
                    }
                }
            }

            // 올리는 위치에 내구도 확인
            if (AArr[0][0] > 0) {
                robotArr[0][0] = true;
                AArr[0][0] -= 1;
            }

            // k 확인
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (AArr[0][i] == 0) count++;
            }
            for (int i = n - 1; i >= 0; i--) {
                if (AArr[1][i] == 0) count++;
            }

            if (count >= k) {
                System.out.println(answer);
                break;
            }
        }
    }
}
