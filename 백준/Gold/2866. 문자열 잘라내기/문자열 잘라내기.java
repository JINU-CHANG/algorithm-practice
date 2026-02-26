import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R, C;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] carr = new char[C][R];

        List<char[]> strs = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                carr[j][i] = s.charAt(j);
            }
        }

        for (int i = 0; i < C; i++) {
            strs.add(carr[i]);
        }

        int idx = 0;
        int count = 0;
        while (idx < R) {
            for (char[] arr : strs) {
                arr[idx] = ' ';
            }

            Set<String> check = new HashSet<>();
            for (char[] arr : strs) {
                String s = String.valueOf(arr);

                if (check.contains(s)) {
                    System.out.println(count);
                    return;
                }

                check.add(s);
            }

            count++;
            idx++;
        }

        System.out.println(count);
    }
}
