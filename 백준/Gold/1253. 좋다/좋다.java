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
        int answer = 0;
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (true) {
                if (i == left) left++;
                else if (right == i) right--;

                if (left >= right) break;
                long result = array[left] + array[right];

                if (result < array[i]) {
                    left++;
                } else if (result > array[i]) {
                    right--;
                } else {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
