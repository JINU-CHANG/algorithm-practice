import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Info {
    char c;
    int count;

    Info(char c, int count) {
        this.c = c;
        this.count = count;
    }
}

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int R, C;
    static Info[][] map;
    static boolean move;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new Info[R][C];

        for (int i = 0; i < R; i++) {
            String s = new StringTokenizer(br.readLine()).nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = new Info(s.charAt(j), 0);
            }
        }

        // 매분마다 반복
        int time = 0;
        while (true) {
            move = false;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    Info info = map[i][j];

                    if (info.c == '*' && time == info.count) {
                        waterMove(i, j, time);
                    } else if (info.c == 'S' && time == info.count) {
                        animalMove(i, j, time);
                    }
                }
            }

            if (!move) {
                System.out.println("KAKTUS");
                return;
            }

            if (ans != -1) {
                System.out.println(ans);
                return;
            }

            time++;
        }
    }

    private static void waterMove(int i, int j, int time) {
        for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            if (map[ny][nx].c == 'X' || map[ny][nx].c == 'D') continue;

            if (map[ny][nx].c == 'S' && time == map[ny][nx].count) {
                animalMove(ny, nx, time);
            }
            map[ny][nx] = new Info('*', time + 1);
        }
    }

    private static void animalMove(int i, int j, int time) {
        for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            if (map[ny][nx].c == 'X' || map[ny][nx].c == '*') continue;

            move = true;
            if (map[ny][nx].c == 'D') {
                ans = time + 1;
                return;
            }
            map[ny][nx] = new Info('S', time + 1);
        }
    }
}
