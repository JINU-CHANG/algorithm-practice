import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        while (true) {
            if (t.equals(s)) {
                System.out.println(1);
                return;
            }

            if (s.length() > t.length()) {
                System.out.println(0);
                return;
            }

            if (t.charAt(t.length() - 1) == 'A') {
                t = t.substring(0, t.length() - 1);
                continue;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = t.length() - 2; i >= 0; i--) {
                sb.append(t.charAt(i));
            }

            t = sb.toString();
        }
    }
}
