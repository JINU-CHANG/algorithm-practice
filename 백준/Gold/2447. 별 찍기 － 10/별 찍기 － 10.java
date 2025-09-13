import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] checked;
    static int[] dy = {0, 1, 2};
    static int[] dx = {0, 1, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        checked = new boolean[n + 1][n + 1];
        recursive(1, 1, n);

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!checked[i][j]) sb.append(" ");
                else sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recursive(int y, int x, int size) {
        if (size == 3) {
            for (int i = 0; i < 3; i++) {
                checked[y][x + i] = true;
            }

            checked[y + 1][x] = true;
            checked[y + 1][x + 2] = true;

            for (int i = 0; i < 3; i++) {
                checked[y + 2][x + i] = true;
            }
            return;
        }

        int nsize = size / 3;

        for (int i = 0; i < 3; i++) {
            int ny = y + (dy[i] * nsize);
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                recursive(ny, x + (dx[j] * nsize) , nsize);
            }
        }
    }
}
