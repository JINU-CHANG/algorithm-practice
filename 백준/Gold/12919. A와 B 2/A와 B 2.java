import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();
        int answer = 0;

        if (S.equals(T)) {
            System.out.println(1);
            return;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(S);
        while (!queue.isEmpty()) {
            // A 추가
            String polled = queue.poll();
            String n1Str = polled + "A";
            String n1Flip = new StringBuilder().append(n1Str).reverse().toString();

            // B 추가
            String n2Str = polled + "B";
            String n2Flip = new StringBuilder().append(n2Str).reverse().toString();

            if (n1Str.equals(T) || n2Flip.equals(T)) {
                answer = 1;
                break;
            }
            
            if (T.contains(n1Str) || T.contains(n1Flip)) queue.add(n1Str);
            if (T.contains(n2Str) || T.contains(n2Flip)) queue.add(n2Flip);
        }

        System.out.println(answer);
    }
}
