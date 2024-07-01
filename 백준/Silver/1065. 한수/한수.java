import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (checkValidNumber(i)) ans++;
        }

        System.out.println(ans);
    }

    public static boolean checkValidNumber(int i) {
        if (i < 100) return true;

        int hun = i / 100;
        int ten = (i % 100) / 10;
        int one = (i % 100) % 10;

        if ((hun - ten) == (ten - one)) return true;
        return false;
    }
}
