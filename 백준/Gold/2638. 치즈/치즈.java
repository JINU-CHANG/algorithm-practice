import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main{

    static int checkBit = -1;
    static boolean findAns = false;
    static int ans = 0;
    static int N, M;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            checkAir(0, 0);
            meltCheese();
            reset();
            if (findAns) break;
            ans++;
        }

        System.out.println(ans);
    }

    private static void checkAir(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= N || nx >= M || ny < 0 || nx < 0) continue;
            if (map[ny][nx] == 1 || map[ny][nx] == checkBit) continue;
            map[ny][nx] = checkBit;
            checkAir(ny, nx);
        }
    }

    private static void meltCheese() {
        List<int[]> meltList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (ny >= N || nx >= M || ny < 0 || nx < 0) continue;
                        if (map[ny][nx] == checkBit) count++;
                    }

                    if (count >= 2) meltList.add(new int[]{i, j});
                }
            }
        }

        if (meltList.isEmpty()) findAns = true;

        for (int[] arr : meltList) {
            map[arr[0]][arr[1]] = checkBit;
        }
    }

    private static void reset() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == checkBit) map[i][j] = 0;
            }
        }
    }
}
