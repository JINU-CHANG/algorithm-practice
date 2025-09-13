import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] checked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        checked = new boolean[n + 1][2 * n];
        recursive(1, n, n);

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < 2 * n; j++) {
                if (!checked[i][j]) sb.append(" ");
                else sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recursive(int y, int x, int size) {
        if (size == 3) {
            checked[y][x] = true;
            checked[y + 1][x - 1] = true;
            checked[y + 1][x + 1] = true;
            for (int i = 0;  i < 5; i++) {
                checked[y + 2][x - 2 + i] = true;
            }
            return;
        }

        int nsize = size / 2;

        // 맨 위
        recursive(y, x, nsize);

        // 왼쪽
        recursive(y + nsize, x - nsize, nsize);

        // 오른쪽
        recursive(y + nsize, x + nsize, nsize);
    }
}
