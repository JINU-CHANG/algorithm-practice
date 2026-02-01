import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static boolean[][] visited = new boolean[12][6];
    static char[][] map = new char[12][6];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<int[]> bomb = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int answer = 0;
        while (true) {
            boolean canBomb = false;
            visited = new boolean[12][6];
            
            // 터질 수 있는 그룹 찾기
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] == '.') continue;

                    bomb = new ArrayList<>();
                    visited[i][j] = true;
                    bomb.add(new int[]{i, j});
                    dfs(map[i][j], i, j);

                    if (bomb.size() >= 4) {
                        for (int[] arr : bomb) {
                            map[arr[0]][arr[1]] = '.';
                        }

                        canBomb = true;
                    }
                }
            }

            // 아래로 내리기
            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {

                    int count = 1;
                    while (true) {
                        if (i + count >= 12 || map[i + count][j] != '.') break;
                        map[i + count][j] = map[i + count - 1][j];
                        map[i + count - 1][j] = '.';

                        count++;
                    }
                }
            }

//            for (int i = 0; i < 12; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }

            if (!canBomb) {
                System.out.println(answer);
                return;
            }

            answer++;
        }

    }

    private static void dfs(char c, int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= 12 || nx >= 6) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] != c) continue;

            visited[ny][nx] = true;
            bomb.add(new int[]{ny, nx});
            dfs(c, ny, nx);
        }
    }
}
