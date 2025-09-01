import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        boolean[] visited = new boolean[100_001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[n] = arr[n - 1];

        int left = 0;
        int right = 0;
        int before = -1;
        visited[arr[left]] = true;

        long answer = 0;
        while (true) { // 유니크한 수열 찾기
            if (visited[arr[right + 1]]) {
                long x = (right - left + 1);
                long y = (before - left + 1);
                answer += (x * (x + 1)) / 2;
                answer -= (y * (y + 1)) / 2;

                before = right;

                //System.out.println(left + " " + right);

                while (arr[left] != arr[right + 1] && left <= right) {
                    visited[arr[left]] = false;
                    left++;
                }

                left++;
                visited[arr[left]] = true;
            }
            if (right == n - 1) break;

            right++;
            visited[arr[right]] = true;
        }

        System.out.println(answer);
    }
}
