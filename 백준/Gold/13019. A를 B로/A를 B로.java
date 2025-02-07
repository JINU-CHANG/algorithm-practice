import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static String A;
    static String B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();

        int aIdx = A.length() - 1;
        int bIdx = B.length() - 1;

        int result = 0;
        while (aIdx >= 0) {
            if (B.charAt(bIdx) != A.charAt(aIdx)) {
                result++;
            } else {
                bIdx--;
            }
            aIdx--;
        }

        if (canChange()) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean canChange() {
        char[] aCharArray = A.toCharArray();
        char[] bCharArray = B.toCharArray();

        Arrays.sort(aCharArray);
        Arrays.sort(bCharArray);

        return String.valueOf(aCharArray).equals(String.valueOf(bCharArray));
    }
}
