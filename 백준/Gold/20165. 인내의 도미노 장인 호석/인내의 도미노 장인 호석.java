import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, r;
    static int[][] dominos;
    static boolean[][] falled;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        dominos = new int[n][m];
        falled = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                dominos[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int oy = Integer.parseInt(st.nextToken());
            int ox = Integer.parseInt(st.nextToken());
            int d = parseDirection(st.nextToken().charAt(0));

            offense(oy - 1, ox - 1, d);

            st = new StringTokenizer(br.readLine());
            int dy = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            falled[dy - 1][dx - 1] = false;
        }

        sb.append(count).append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(falled[i][j]) sb.append('F').append(" ");
                else sb.append('S').append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int parseDirection(char d) {
        return switch (d) {
            case 'E' -> 0;
            case 'W' -> 1;
            case 'S' -> 2;
            default -> 3;
        };
    }

    public static void offense(int y, int x, int d) {
        falled[y][x] = true;
        count++;

        for (int i = 1; i <= dominos[y][x] - 1; i++) {
            int ny = y + i * dy[d];
            int nx = x + i * dx[d];

            if (ny >= n || nx >= m || ny < 0 || nx < 0) break;
            if (falled[ny][nx]) continue;
            offense(ny, nx, d);
        }
    }
}
