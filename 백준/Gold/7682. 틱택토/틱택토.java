import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
    static StringBuilder sb = new StringBuilder();
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("end")) break;

            int Xcount = 0;
            int Ocount = 0;
            map = new char[3][3];
            for (int i = 0; i < 9; i++) {
                map[i / 3][i % 3] = line.charAt(i);

                if (map[i / 3][i % 3] == 'X') Xcount++;
                else if (map[i / 3][i % 3] == 'O') Ocount++;
            }

            checkMap(Xcount, Ocount);
        }

        System.out.println(sb);
    }

    private static void checkMap(int Xcount, int Ocount) {
        int XResult = 0;
        int OResult = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == '.')
                    continue;
                boolean[] checked = checkValid(i, j);

                if (checked[0]) {
                    if ((checked[1] && Xcount - Ocount == 1) || !checked[1] && Xcount - Ocount == 0) {
                        if (checked[1]) XResult++;
                        else OResult++;
                    } else {
                        sb.append("invalid").append("\n");
                        return;
                    }
                }
            }
        }

        if (XResult + OResult == 1) {
            sb.append("valid").append("\n");
        } else if (Xcount + Ocount == 9 && Xcount - Ocount == 1) {
            sb.append("valid").append("\n");
        } else {
            sb.append("invalid").append("\n");
        }
    }

    private static boolean[] checkValid(int i, int j) {
        for (int k = 0; k < 8; k += 2) {
            int n1y = i + dy[k];
            int n1x = j + dx[k];

            int n2y = i + dy[k + 1];
            int n2x = j + dx[k + 1];

            if (n1y >= 3 || n2y >= 3 || n1x >= 3 || n2x >= 3) continue;
            if (n1y < 0 || n2y < 0 || n1x < 0 || n2x < 0) continue;

            if (map[i][j] == map[n1y][n1x] && map[i][j] == map[n2y][n2x]) {
                return new boolean[] {true, map[i][j] == 'X'};
            }
        }

        return new boolean[] {false, false};
    }
}
