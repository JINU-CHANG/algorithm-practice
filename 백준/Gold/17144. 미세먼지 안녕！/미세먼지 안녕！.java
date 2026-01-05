import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main{

    static int R, C, T;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        List<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) idxs.add(i);
            }
        }

        for (int t = 0; t < T; t++) {

            // 미세먼지 확산
            int[][] temp = new int[R][C];
            temp[idxs.get(0)][0] = -1;
            temp[idxs.get(1)][0] = -1;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != 0 && map[i][j] != -1) {
                        int count = 0;
                        for (int k = 0; k < 4; k++) {
                            int ny = dy[k] + i;
                            int nx = dx[k] + j;

                            if (ny >= R || nx >= C || ny < 0 || nx < 0) continue;
                            if (nx == 0 && (ny == idxs.get(0) || ny == idxs.get(1))) continue;

                            temp[ny][nx] += map[i][j] / 5;
                            count++;
                        }

                        temp[i][j] += (map[i][j] - (map[i][j] / 5) * count);
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] = temp[i][j];
                }
            }

            // 미세먼지 확산
            int top = idxs.get(0);
            for (int i = top - 1; i > 0; i--) {
                map[i][0] = map[i - 1][0];
            }

            for (int i = 0; i < C - 1; i++) {
                map[0][i] = map[0][i + 1];
            }

            for (int i = 0; i < top; i++) {
                map[i][C - 1] = map[i + 1][C - 1];
            }

            for (int i = C - 1; i > 1; i--) {
                map[top][i] = map[top][i - 1];
            }

            map[top][1] = 0;

            int bottom = idxs.get(1);
            for (int i = bottom + 1; i < R - 1; i++) {
                map[i][0] = map[i + 1][0];
            }

            for (int i = 0; i < C - 1; i++) {
                map[R - 1][i] = map[R - 1][i + 1];
            }

            for (int i = R - 1; i > bottom; i--) {
                map[i][C - 1] = map[i - 1][C - 1];
            }

            for (int i = C - 1; i > 1; i--) {
                map[bottom][i] = map[bottom][i - 1];
            }

            map[bottom][1] = 0;
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += map[i][j];
            }
        }

        System.out.println(answer + 2);
    }
}
