import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n;
        int m;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        int left = 0;
        int right = n - 1;

        int answer = 0;
        while (left < right) {
            int result = array[left] + array[right];

            if (result > m) {
                right--;
            } else if (result == m) {
                answer++;
                left++;
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer);
    }
}
