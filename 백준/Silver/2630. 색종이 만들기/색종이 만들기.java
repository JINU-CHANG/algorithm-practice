import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] squares;
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        squares = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                squares[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        test(0, 0, n);
        System.out.println(white + "\n" + blue);
    }

    public static void test(int x, int y, int size) {
        int check = squares[x][y];

        Loop1 :
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (squares[i][j] != check) {
                    test(x, y, size/2); // 1
                    test(x, y + size/2, size/2); // 2
                    test(x + size/2, y, size/2); // 3
                    test(x + size/2, y + size/2, size/2); // 4
                    break Loop1;
                }

                if (i == x + size - 1 && j == y + size - 1) {
                    if (check == 1) blue++;
                    else white++;
                }
            }
        }
    }
}
