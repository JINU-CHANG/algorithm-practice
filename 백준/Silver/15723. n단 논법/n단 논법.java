import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[26][26];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            int x = charArray[0] - 97;
            int y = charArray[charArray.length - 1] - 97;

            arr[x][y] = 1;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            char[] charArray = br.readLine().toCharArray();
            int x = charArray[0] - 97;
            int y = charArray[charArray.length - 1] - 97;

            if (arr[x][y] == 1) {
                System.out.println('T');
            } else {
                System.out.println('F');
            }
        }
    }
}
