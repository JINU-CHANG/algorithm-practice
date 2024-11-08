import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String x = br.readLine();

       while (!x.equals("0")) {
           solve(x.toCharArray());
           x = br.readLine();
       }

        System.out.println(sb);
    }

    public static void solve(char[] arrays) {
        int start = 0;
        int end = arrays.length - 1;

        while (start < end) {
            if (arrays[start] != arrays[end]) {
                sb.append("no").append("\n");
                return;
            }

            start++;
            end--;
        }

        sb.append("yes").append("\n");
    }
}
