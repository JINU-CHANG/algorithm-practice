import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int B;
    static char[] A;
    static boolean[] visited;
    static char[] temp;
    static List<Integer> list = new ArrayList<>();
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken().toCharArray();
        String sb = st.nextToken();
        B = Integer.parseInt(sb);
        visited = new boolean[A.length];
        temp = new char[A.length];

        back(0);

        for (Integer i : list) {
            if (i < B) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }

    private static void back(int count) {
        if (count == A.length) {
            if (temp[0] == '0') return;
            list.add(Integer.parseInt(String.valueOf(temp)));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            temp[count] = A[i];
            back(count + 1);
            visited[i] = false;
        }
    }
}
