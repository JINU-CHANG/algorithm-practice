import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
    int y;
    int x;

    public Info(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int n, m;
    static char[][][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int startY, startX;
    static int collapseBuildingNum;
    static int notCollapseBuildingNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[2][n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '@') {
                    startY = i;
                    startX = j;
                } else if (line.charAt(j) == '*' || line.charAt(j) == '#') {
                    notCollapseBuildingNum += 1;
                }
                map[0][i][j] = line.charAt(j);
                map[1][i][j] = '0';
            }
        }

        solve();
        System.out.println(collapseBuildingNum + " " + notCollapseBuildingNum);
    }

    private static void solve() {
        Queue<Info> queue = new ArrayDeque<>();

        // 본진
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 2; j++) {
                int ny = startY + (j * dy[i]);
                int nx = startX + (j * dx[i]);

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (map[0][ny][nx] == '@' || map[0][ny][nx] == '.') continue;
                if (map[0][ny][nx] == '|') break;
                if (map[0][ny][nx] == '*' && map[1][ny][nx] == '1') continue;
                if (map[0][ny][nx] == '#' && map[1][ny][nx] == '0') {
                    map[1][ny][nx] = '1';
                    continue;
                }

                if (map[0][ny][nx] == '*' || (map[0][ny][nx] == '#' && map[1][ny][nx] == '1')) {
                    collapseBuildingNum += 1;
                    notCollapseBuildingNum -= 1;
                    map[1][ny][nx] = (char) (map[1][ny][nx] + 1);
                    queue.add(new Info(ny, nx));
                }
            }
        }

        // 여진
        while(!queue.isEmpty()) {
            Info polled = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = polled.y + dy[i];
                int nx = polled.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (map[0][ny][nx] == '@' || map[0][ny][nx] == '.' || map[0][ny][nx] == '|') continue;
                if (map[0][ny][nx] == '*' && map[1][ny][nx] == '1') continue;
                if (map[0][ny][nx] == '#' && map[1][ny][nx] == '0') {
                    map[1][ny][nx] = '1';
                    continue;
                }

                if (map[0][ny][nx] == '*' || (map[0][ny][nx] == '#' && map[1][ny][nx] == '1')) {
                    collapseBuildingNum += 1;
                    notCollapseBuildingNum -= 1;
                    map[1][ny][nx] = (char) (map[1][ny][nx] + 1);
                    queue.add(new Info(ny, nx));
                }
            }
        }
    }
}
