import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = map[i][j];
            }
        }

        // 최단거리 여러 개로 쪼갤 수 있는 방법 구하기
        for (int i = 1; i <= n; i++) { // 출발
            for (int j = 1; j <= n; j++) { // 중간
                if (i == j) continue;
                for (int k = 1; k <=n; k++) { // 도착
                    if (j == k || i == k) continue;

                    if (map[i][k] > map[i][j] + map[j][k]) {
                        System.out.println(-1);
                        return;
                    }
                    if (map[i][k] == map[i][j] + map[j][k]) {
                        //System.out.println(i + " " + j + " " + k);
                        arr[i][k] = 0;
                        arr[k][i] = 0;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                    sum += arr[i][j];
                }
        }

        System.out.println(sum / 2);
    }
}
