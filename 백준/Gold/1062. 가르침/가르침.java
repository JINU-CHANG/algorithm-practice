import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static String[] strs;
    static Set<Character> set = Set.of('a', 'n', 't', 'i', 'c');
    static boolean[] visited = new boolean[26];
    static int realAnswer = 0;

    public static void main(String[] args) throws IOException {
        // 97
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }

        for (char c : set) {
            visited[getNum(c)] = true;
        }

        if (k - 5 < 0) {
            System.out.println(realAnswer);
        } else {
            check(0, 0);
            System.out.println(realAnswer);
        }
    }

    private static int getNum(char c) {
        return c - 97;
    }

    private static char getChar(int i) {
        return (char) (i + 97);
    }

    private static void check(int idx, int count) {
        if (count == k - 5) {
            // 정답
            int answer = 0;
            for (int i = 0; i < n; i++) {
                String s = strs[i];
                int temp = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (visited[getNum(s.charAt(j))]) temp++;
                }

                if (temp == s.length()) answer++;
            }
            //System.out.println(Arrays.toString(visited));
            realAnswer = Math.max(answer, realAnswer);
            return;
        }

        for (int i = idx; i < 26; i++) {
            char c = getChar(i);
            if (set.contains(c)) continue;

            visited[i] = true;
            check(i + 1, count + 1);
            visited[i] = false;
        }
    }
}
