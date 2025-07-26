import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r, s;
        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][s];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < s; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 거리의 최소값 구하기
        int d = Integer.MAX_VALUE;
        for (int i = 0; i < s; i++) {
            int temp = -1;
            for (int j = 0; j < r; j++) {
                if (map[j][i] == 'X') temp = j;
                else if (map[j][i] == '#' && temp != -1) {
                    d = Math.min(d, (j - temp));
                    break;
                }
            }
        }

        for (int i = r - 1; i >= 0; i--) {
            for (int j = 0; j < s; j++) {
                if (map[i][j] == 'X' && d != 1) {
                    map[i + d - 1][j] = 'X';
                    map[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
