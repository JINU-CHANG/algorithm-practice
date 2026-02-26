import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            sb.append(checkPalin(s)).append("\n");
        }

        System.out.println(sb);
    }

    private static int checkPalin(String s) {
        int leftIdx = 0;
        int rightIdx = s.length() - 1;

        while (leftIdx < rightIdx) {
            char leftC = s.charAt(leftIdx);
            char rightC = s.charAt(rightIdx);

            if (leftC == rightC) {
                leftIdx++;
                rightIdx--;
                continue;
            }

            int leftResult = checkPseudoPenlin(leftIdx + 1, rightIdx, s);
            int rightResult = checkPseudoPenlin(leftIdx, rightIdx - 1, s);

            if (leftResult == 1 || rightResult == 1) return 1;
            else return 2;
        }

        return 0;
    }

    private static int checkPseudoPenlin(int leftIdx, int rightIdx, String s) {
        if (leftIdx > rightIdx) return 2;

        while (leftIdx < rightIdx) {
            char leftC = s.charAt(leftIdx);
            char rightC = s.charAt(rightIdx);

            if (leftC == rightC) {
                leftIdx++;
                rightIdx--;
                continue;
            }

            return 2;
        }

        return 1;
    }
}
