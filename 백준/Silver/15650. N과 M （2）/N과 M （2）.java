import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            find(i, 0);
            ans.clear();
        }
    }

    public static void find(int x, int num) {
        if (x <= N && num < M) {
            num++;
            ans.add(x);
        }

        if (num == M) {
            ans.forEach(a -> System.out.print(a + " "));
            System.out.println();
            return;
        }

        for (int i = x + 1; i <= N; i++) {
            find(i, num);
            ans.remove(ans.size() - 1);
        }
    }
}
