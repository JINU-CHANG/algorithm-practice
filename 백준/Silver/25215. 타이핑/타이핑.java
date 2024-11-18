import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] array;
    static boolean isCapital = false;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        array = new char[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            array[i + 1] = s.charAt(i);
        }

        solve();
        System.out.println(cnt - 1);
    }

    public static void solve() {
       for (int i = 0; i < array.length; i++) {
           if (i + 1 < array.length && isCapital && Character.isLowerCase(array[i + 1])) {
               if (i + 2 < array.length && !Character.isUpperCase(array[i + 2])) {
                   isCapital = false;
               }
               i++;
               cnt+=2;
           } else if (i + 1 < array.length && !isCapital&& Character.isUpperCase(array[i + 1])) {
               if (i + 2 < array.length && !Character.isLowerCase(array[i + 2])) {
                   isCapital = true;
               }
               i++;
               cnt+=2;
           }
           cnt++;
       }
    }
}
