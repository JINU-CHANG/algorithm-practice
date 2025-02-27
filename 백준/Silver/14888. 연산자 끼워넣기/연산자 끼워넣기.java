import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] numbers;
    static int[] answer;
    static boolean[] visited;
    static List<Integer> operatorIdxs = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int x = Integer.parseInt(st.nextToken());

            for (int j = 0; j < x; j++) {
                operatorIdxs.add(i);
            }
        }

        answer = new int[n - 1];
        for (int i = 0; i < operatorIdxs.size(); i++) {
            answer[0] = operatorIdxs.get(i);
            visited[i] = true;
            dfs(0);
            visited[i] = false;
        }

        System.out.println(max + "\n" + min);
    }

    private static void dfs(int count) {
        if (count == n - 2) {
            calculateAns();
            return;
        }

        for (int i = 0; i < operatorIdxs.size(); i++) {
            if (visited[i]) continue;
            answer[count + 1] = operatorIdxs.get(i);
            visited[i] = true;
            dfs(count + 1);
            visited[i] = false;
        }
    }

    private static void calculateAns() {
        int result = numbers[0];
        for (int i = 0; i < n - 1; i++) {
            switch (answer[i]) {
                case 0:
                    result = (result + numbers[i + 1]);
                    break;
                case 1:
                    result = (result - numbers[i + 1]);
                    break;
                case 2:
                    result = (result * numbers[i + 1]);
                    break;
                case 3:
                    if (result < 0) {
                        result = -(-result / numbers[i + 1]);
                    } else {
                        result = result / numbers[i + 1];
                    }
            }
        }

        max = Math.max(max, result);
        min = Math.min(min, result);
    }
}
