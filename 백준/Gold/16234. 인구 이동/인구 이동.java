import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] visited;
    static int[][] countries;
    static int count;
    static int sum;
    static int n, l, r;
    static int ans;
    static int[] countryPeople = new int[25001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        countries = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int num = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] > 0) continue;

                    count++;
                    sum += countries[i][j];
                    visited[i][j] = num;

                    dfs(i, j, num);
                    countryPeople[num] = (sum) / count;

                    num++;
                    sum = 0;
                    count = 0;
                }
            }

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (countries[i][j] != countryPeople[visited[i][j]]) flag = true;
                    countries[i][j] = countryPeople[visited[i][j]];
                }
            }

            if (!flag) {
                System.out.println(ans);
                return;
            }

            ans++;
            countryPeople = new int[25001];
            visited = new int[n][n];
        }
    }

    private static void dfs(int y, int x, int num) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
            if (l > Math.abs(countries[ny][nx] - countries[y][x])
                    || r < Math.abs(countries[ny][nx] - countries[y][x])) continue;
            if (visited[ny][nx] > 0) continue;

            count++;
            sum += countries[ny][nx];
            visited[ny][nx] = num;
            dfs(ny, nx, num);
        }
    }
}
