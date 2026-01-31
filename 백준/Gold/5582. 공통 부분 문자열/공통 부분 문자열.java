import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] arr = new int[str2.length()][str1.length()];
        int answer = 0;

        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                int c1 = str1.charAt(j);
                int c2 = str2.charAt(i);

                if (c1 == c2) {
                    arr[i][j] = 1;

                    if (i >= 1 && j >= 1 && arr[i - 1][j - 1] != 0) {
                        arr[i][j] += arr[i - 1][j - 1];
                        answer = Math.max(answer, arr[i][j]);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
