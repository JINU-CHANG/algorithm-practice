import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int t, n;
    static String[] calls;
    static Set<String> callHeadCheck;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            calls = new String[n];
            callHeadCheck = new HashSet<>();

            for (int j = 0; j < n; j++) {
                String call = br.readLine();
                check(call);
                calls[j] = call;
            }

            solve();
        }

        System.out.println(sb);
    }

    public static void check(String call) {
        String s = "";
        for (int i = 0; i < call.length() - 1; i++) {
            s += call.charAt(i);
            callHeadCheck.add(s);
        }
    }

    public static void solve() {
        for (String c : calls) {
            if (callHeadCheck.contains(c)) {
                sb.append("NO").append("\n");
                return;
            }
        }

        sb.append("YES").append("\n");
    }
}
