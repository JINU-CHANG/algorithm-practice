import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            // 그룹 단어 체크
            char c = s.charAt(0);
            boolean check = true;
            Set<Character> set = new HashSet<>();
            set.add(c);
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != c && set.contains(s.charAt(j))) {
                    check = false;
                    break;
                }

                set.add(s.charAt(j));
                c = s.charAt(j);
            }

            if (check) answer++;
        }

        System.out.println(answer);
    }
}
