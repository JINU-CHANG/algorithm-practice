import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            sb.append(bfs(A)).append("\n");
        }

        System.out.println(sb);
    }

    public static String bfs(int x) {
        boolean[] visited = new boolean[10_000];
        String[] ans = new String[10_000];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        visited[x] = true;
        ans[x] = "";

        while (!queue.isEmpty()) {
            int polled = queue.poll();
            if (polled == B) {
                return ans[polled];
            }

            int calculatedD = calculateD(polled);
            if (!visited[calculatedD]) {
                queue.add(calculatedD);
                visited[calculatedD] = true;
                ans[calculatedD] = ans[polled] + "D";
            }

            int calculatedS = calculateS(polled);
            if (!visited[calculatedS]) {
                queue.add(calculatedS);
                visited[calculatedS] = true;
                ans[calculatedS] = ans[polled] + "S";
            }

            int calculatedL = calculateL(polled);
            if (!visited[calculatedL]) {
                queue.add(calculatedL);
                visited[calculatedL] = true;
                ans[calculatedL] = ans[polled] + "L";
            }

            int calculatedR = calculateR(polled);
            if (!visited[calculatedR]) {
                queue.add(calculatedR);
                visited[calculatedR] = true;
                ans[calculatedR] = ans[polled] + "R";
            }
        }

        return "";
    }

    public static int calculateD(int x) {
        int nx = 2 * x;
        if (nx > 9999) {
            return nx % 10000;
        }
        return nx;
    }

    public static int calculateS(int x) {
        if (x == 0) {
            return 9999;
        }

        return x - 1;
    }

    public static int calculateL(int x) {
        String s = String.valueOf(x);
        char[] cs = {'0', '0', '0', '0'};
        for (int i = 0; i < s.length(); i++) {
            cs[i + (4 - s.length())] = s.charAt(i);
        }

        char temp = cs[cs.length - 1];
        for (int i = cs.length - 1; i > 0; i--) {
            char bi = cs[i - 1];
            char ci = temp;
            cs[i - 1] = ci;
            temp = bi;
        }

        cs[cs.length - 1] = temp;

        return Integer.parseInt(String.valueOf(cs));
    }

    public static int calculateR(int x) {
        String s = String.valueOf(x);
        char[] cs = {'0', '0', '0', '0'};
        for (int i = 0; i < s.length(); i++) {
            cs[i + (4 - s.length())] = s.charAt(i);
        }

        char temp = cs[0];
        for (int i = 0; i < cs.length - 1; i++) {
            char ni = cs[i + 1];
            char ci = temp;
            cs[i + 1] = ci;
            temp = ni;
        }

        cs[0] = temp;

        return Integer.parseInt(String.valueOf(cs));
    }

}
