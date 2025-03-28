import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n - 1;
        int answer = 0;
        while (start < end) {
            int sum = array[start] + array[end];

            if (sum > x) {
                end--;
            } else if (sum == x) {
                start++;
                end--;
                answer++;
            } else {
                start++;
            }
        }

        System.out.println(answer);
    }
}
