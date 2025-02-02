import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int number = n;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] == number) {
                number -= 1;
                count++;
            }
        }

        System.out.println(n - count);
    }
}
