import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int csize = 1;
        while (csize < k) {
            csize *= 2;
        }

        int count = 0;
        int temp = csize;
        int sum = 0;
        while (sum != k && !(count == 0 && (k == csize))) {
            int x = temp / 2;
            count += 1;
            temp /= 2;
            if (sum + x > k) continue;
            sum += x;
        }

        System.out.println(csize +  " " + count);
    }
}
