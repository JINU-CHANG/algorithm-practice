import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R, C, T;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) positions.add(i);
            }
        }

        for (; T > 0; T--) {
            // 미세먼지 확산
            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};

            int[][] nmap = new int[R][C];
            for (int x : positions) {
                nmap[x][0] = -1;
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) {
                        int count = 0;
                        for (int k = 0; k < 4; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];

                            if (ny >= R || nx >= C || ny < 0 || nx < 0) continue;
                            if (map[ny][nx] == -1) continue;
                            nmap[ny][nx] += (map[i][j] / 5);
                            count++;
                        }

                        nmap[i][j] += map[i][j] - ((map[i][j] / 5) * count);
                    }
                }
            }

            map = nmap;

            int start = positions.get(0);
            // 반시계 이동
            for (int i = start - 2; i >= 0; i--) {
                map[i + 1][0] = map[i][0];
            }

            for (int i = 1; i < C; i++) {
                map[0][i - 1] = map[0][i];
            }

            for (int i = 1; i <= start; i++) {
                map[i - 1][C - 1] = map[i][C - 1];
            }

            for (int i = C - 2; i >= 1; i--) {
                map[start][i + 1] = map[start][i];
            }

            map[start][1] = 0;

            // 시계 이동
            start = positions.get(1);
            for (int i = start + 2; i < R; i++) {
                map[i - 1][0] = map[i][0];
            }

            for (int i = 1; i < C; i++) {
                map[R - 1][i - 1] = map[R - 1][i];
            }

            for (int i = R - 2; i >= start; i--) {
                map[i + 1][C - 1] = map[i][C - 1];
            }

            for (int i = C - 2; i >= 1; i--) {
                map[start][i + 1] = map[start][i];
            }

            map[start][1] = 0;
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) continue;
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }
}
