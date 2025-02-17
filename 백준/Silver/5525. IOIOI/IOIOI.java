import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n, m;
    static String s;
    static List<Integer> counts = new ArrayList<>();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        s = br.readLine();

        // S 중에 연속되는 IO...I 체크
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I') {
                search(0, i);
            }
        }

        System.out.println(ans);
    }

    private static void search(int count, int startIdx) {
        for (int i = startIdx; i >= 0; i--) {
            if (n == count) {
                if (s.charAt(i) == 'I') {
                    ans += 1;
                }
                return;
            }

            if (i >= 1 && s.charAt(i - 1) == 'O' && s.charAt(i) == 'I') {
                count += 1;
                i--;
            } else {
                return;
            }
        }
    }
}
