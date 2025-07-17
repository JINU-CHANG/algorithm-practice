import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean e = false;
        boolean w = false;
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (e && w || (!e && w)) {
                if (s.charAt(i) == 'E') {
                    ans++;
                    e = true;
                    w = false;
                    continue;
                }
            }

            if (s.charAt(i) == 'E') e = true;
            else w = true;
        }

        System.out.println(ans + 1);
    }
}
