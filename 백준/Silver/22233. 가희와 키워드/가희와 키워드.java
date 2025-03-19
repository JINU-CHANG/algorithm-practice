import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>();

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            String[] splited = s.split(",");

            for (int j = 0; j < splited.length; j++) {
                String s2 = splited[j];

                if (!set.contains(s2)) continue;
                set.remove(s2);
            }

            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);
    }
}
