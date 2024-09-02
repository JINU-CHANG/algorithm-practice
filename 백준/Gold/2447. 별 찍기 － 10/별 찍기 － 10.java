import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] map;
    static char[][] nmap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        map = new char[3][3];

        // 3일때 초기 세팅
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i % 2 == 0) {
                    map[i][j] = '*';
                } else if (j % 2 == 0) {
                    map[i][j] = '*';
                } else {
                    map[i][j] = ' ';
                }

            }
        }

        for (int i = 9; i <= n; i = i * 3) {
            draw(i);
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void draw(int x) {
        nmap = new char[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (( x / 3 <= i && i < (x / 3) * 2) && (x / 3 <= j && j < (x / 3) * 2)) {
                    nmap[i][j] = ' ';
                    continue;
                }

                int ni = i % (x / 3);
                int nj = j % (x / 3);

                nmap[i][j] = map[ni][nj];
            }
        }

        map = nmap;
    }

}

