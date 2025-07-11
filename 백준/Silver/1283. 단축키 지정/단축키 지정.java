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
            String option = br.readLine();
            String[] words = option.split(" ");
            int keyIdx = -1;

            int length = 0;
            for (String x : words) {
                char c = x.charAt(0);
                if (!set.contains(Character.toUpperCase(c)) && !set.contains(Character.toLowerCase(c))) {
                    set.add(c);
                    if (length == 0) keyIdx = 0;
                    else keyIdx = length;
                    break;
                }
                length += x.length() + 1;
            }

            if (keyIdx == -1) {
                for (int j = 0; j < option.length(); j++) {
                    char c = option.charAt(j);
                    if (c != ' ' && !set.contains(Character.toUpperCase(c)) && !set.contains(Character.toLowerCase(c))) {
                        set.add(c);
                        keyIdx = j;
                        break;
                    }
                }
            }

            for (int j = 0; j < option.length(); j++) {
                if (j == keyIdx) {
                    sb.append("[").append(option.charAt(j)).append("]");
                } else {
                    sb.append(option.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
