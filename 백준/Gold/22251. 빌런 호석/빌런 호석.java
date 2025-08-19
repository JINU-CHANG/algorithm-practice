import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, K, P, X;
        int answer = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 불 표시
        int[][] arr = new int[10][10];
        boolean[][] light = new boolean[10][7];

        light[0] = new boolean[]{true, true, true, true, true, true, false};
        light[1] = new boolean[]{false, true, true, false, false, false, false};
        light[2] = new boolean[]{true, true, false, true, true, false, true};
        light[3] = new boolean[]{true, true, true, true, false, false, true};
        light[4] = new boolean[]{false, true, true, false, false, true, true};
        light[5] = new boolean[]{true, false, true, true, false, true, true};
        light[6] = new boolean[]{true, false, true, true, true, true, true};
        light[7] = new boolean[]{true, true, true, false, false, false, false};
        light[8] = new boolean[]{true, true, true, true, true, true, true};
        light[9] = new boolean[]{true, true, true, true, false, true, true};

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) continue;
                int count = 0;
                for (int k = 0; k < 7; k++) {
                    if (light[i][k] != light[j][k]) count++;
                }

                arr[i][j] = count;
            }
        }

        String v2 = changeString(String.valueOf(X), K);
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;

            String v1 = String.valueOf(i);
            if (v1.length() > K) break;
            if (v1.length() < K) {
                v1 = changeString(v1, K);
            }

            int countP = 0;
            for (int j = 0; j < K; j++) {
                countP += arr[v1.charAt(j) - '0'][v2.charAt(j) - '0'];
            }

            if (1 <= countP && countP <= P) answer++;
        }

        System.out.println(answer);
    }

    private static String changeString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < k - s.length(); j++) sb.append('0');
        for (int j = 0; j < s.length(); j++) sb.append(s.charAt(j));

        return sb.toString();
    }
}
