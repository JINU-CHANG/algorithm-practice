import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point{
    int y;
    int x;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Main{

    static int n, m;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Point> virus = new ArrayList<>();
    static List<Point> points = new ArrayList<>();
    static int[][] map;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) virus.add(new Point(i, j));
                else if (map[i][j] == 0) points.add(new Point(i, j));
            }
        }

        pick(-1, 0);
        System.out.println(answer);
    }

    private static void pick(int idx, int count) {
        if (count == 3) {
            countSafeZone();
            return;
        }

        for (int i = idx + 1; i < points.size(); i++) {
            Point point = points.get(i);
            map[point.y][point.x] = 1;
            pick(i, count + 1);
            map[point.y][point.x] = 0;
        }
    }

    private static void countSafeZone() {
        int[][] tempMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        for (Point point : virus) {
            spreadVirus(tempMap, point.y, point.x);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 0) count++;
            }
        }

        answer = Math.max(answer, count);
    }

    private static void spreadVirus(int[][] tempMap, int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= n || nx >= m || ny < 0 || nx < 0) continue;
            if (tempMap[ny][nx] != 0) continue;
            tempMap[ny][nx] = 2;
            spreadVirus(tempMap, ny, nx);
        }
    }
}
