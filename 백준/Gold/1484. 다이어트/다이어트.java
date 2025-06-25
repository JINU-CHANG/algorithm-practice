import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int G;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i <= G; i++) {
            int j = G / i;
            if (i >= j) break;
            if (G % i != 0) continue;
            if ((i + j) % 2 != 0) continue;

            count++;
            answer.add((i + j) / 2);
        }

        if (count == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int x : answer) {
                System.out.println(x);
            }
        }
    }
}
