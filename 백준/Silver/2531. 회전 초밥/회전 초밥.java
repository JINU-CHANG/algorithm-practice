import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n;
        int d;
        int k;
        int c;
        int[] array;
        int[] countArray;
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        countArray = new int[d + 1];
        array = new int[n + (k - 1)];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k - 1; i++) {
            array[n + i] = array[i];
        }

        int count = 0;
        // 맨처음 초기화
        for (int i = 0; i < k; i++) {
            if (countArray[array[i]] == 0) {
                count++;
            }

            countArray[array[i]] += 1;
        }
        

        int ans = count;
        if (countArray[c] == 0) {
            ans = Math.max(ans, count + 1);
        } else {
            ans = Math.max(ans, count);
        }

        for (int i = 1; i < n; i++) {
            // start 움직이기
            int before = array[i - 1];
            if (countArray[before] == 1) {
                count--;
            }
            countArray[before] -= 1;

            // end 움직이기
            int end = array[i + k - 1];
            if (countArray[end] == 0) {
                count++;
            }

            countArray[end] += 1;

            if (countArray[c] == 0) {
                ans = Math.max(ans, count + 1);
            } else {
                ans = Math.max(ans, count);
            }
        }

        System.out.println(ans);
    }
}
