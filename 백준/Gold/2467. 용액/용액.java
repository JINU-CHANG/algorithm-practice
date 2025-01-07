import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] array;
    static int min = Integer.MAX_VALUE;
    static int[] ansArray = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int search1 = search1(i);
            int search1Result = Math.abs(array[i] + array[search1]);
            if (search1 != i && search1Result < min) {
                min = search1Result;
                ansArray[0] = array[i];
                ansArray[1] = array[search1];
            }

            int search2 = search2(i);
            int search2Result = Math.abs(array[i] + array[search2]);
            if (search2 != i && search2Result < min) {
                min = search2Result;
                ansArray[0] = array[i];
                ansArray[1] = array[search2];
            }
        }

        Arrays.sort(ansArray);
        for (int i = 0; i < 2; i++) {
            sb.append(ansArray[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static int search1(int xIdx) {
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (array[mid] + array[xIdx] >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static int search2(int xIdx) {
        int left = 1;
        int right = n - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (array[mid] + array[xIdx] > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right - 1;
    }
}
