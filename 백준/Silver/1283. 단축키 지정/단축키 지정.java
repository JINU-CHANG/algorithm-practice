import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine(); // Save As
            String[] sArray = s.split(" ");  // Save,As
            int idx = -1;

            int count = 0;
            for (String x : sArray) {
                char c = x.charAt(0);
                if (!set.contains(Character.toUpperCase(c)) && !set.contains(Character.toLowerCase(c))) {
                    set.add(c);
                    if (count == 0) idx = 0;
                    else idx = count;
                    break;
                }
                count += x.length() + 1;
            }

            if (idx == -1) {
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (c != ' ' && !set.contains(Character.toUpperCase(c)) && !set.contains(Character.toLowerCase(c))) {
                        set.add(c);
                        idx = j;
                        break;
                    }
                }
            }

            for (int j = 0; j < s.length(); j++) {
                if (j == idx) {
                    sb.append("[").append(s.charAt(j)).append("]");
                } else {
                    sb.append(s.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
