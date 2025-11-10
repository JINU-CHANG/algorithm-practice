import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] sequences;
    static String ans = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sequences = new int[n];
        dfs(0);

        System.out.println(ans);
    }

    private static void dfs(int count) {
        if (count == n) {
            ans = changeNumber(count);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            sequences[count] = i;
            if (checkBadSequence(count)) continue;

            //System.out.println(Arrays.toString(sequences));
            dfs(count + 1);

            if (ans != null) return;
        }
    }

    private static String changeNumber(int size) {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += sequences[i];
        }

        return s;
    }

    private static boolean checkBadSequence(int count) {
        String s = changeNumber(count + 1);

        for (int k = 1; k < s.length(); k++) {
            for (int i = 0; i + 2 * k <= s.length(); i++) {
                String sub1 = s.substring(i, i + k);
                String sub2 = s.substring(i + k, i + 2 * k);

                if (sub1.equals(sub2)) return true;
            }
        }

        return false;
    }
}
