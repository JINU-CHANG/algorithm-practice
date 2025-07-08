import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] array = new boolean[31];
        for (int i = 0; i < 28; i++) {
            int x = Integer.parseInt(br.readLine());
            array[x] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (array[i]) continue;
            else sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
