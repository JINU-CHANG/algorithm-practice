import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int x, n;
    static int[] length;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            x = Integer.parseInt(input) * 10_000_000;
            n = Integer.parseInt(br.readLine());

            length = new int[n];
            for (int i = 0; i < n; i++) {
                int l = Integer.parseInt(br.readLine());
                length[i] = l;
            }

            solve();
        }

        System.out.println(sb);
    }

    public static void solve() {
        Arrays.sort(length);
        int right = length.length - 1;
        for (int left = 0; left < length.length; left++) {
            while (left < right && (x < length[left] + length[right])) {
                right--;
            }

            if (left != right && x == length[left] + length[right]) {
                sb.append("yes ").append(length[left]).append(" ").append(length[right]).append("\n");
                return;
            }
        }

        sb.append("danger").append("\n");
    }
}
