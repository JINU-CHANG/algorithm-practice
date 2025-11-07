import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] preDp = new int[k + 1];
        int[] newDp = new int[k + 1];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        preDp[0] = 1;
        newDp[0] = 1;
        for (int i = 1; i < k + 1; i++) {
            if (i % arr[0] == 0) preDp[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (j - arr[i] >= 0) newDp[j] = preDp[j] + newDp[j - arr[i]];
                else newDp[j] = preDp[j];
            }

            preDp = newDp;
            newDp = new int[k + 1];
            newDp[0] = 1;
        }

        System.out.println(preDp[k]);
    }
}
