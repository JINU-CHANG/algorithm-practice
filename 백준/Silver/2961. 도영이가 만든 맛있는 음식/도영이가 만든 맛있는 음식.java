import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Info {
    int s;
    int b;

    Info(int s, int b) {
        this.s = s;
        this.b = b;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Info> infos = new ArrayList<>();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            infos.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 1; i < 1 << n; i++) {
            int sSum = 1;
            int bSum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sSum *= infos.get(j).s;
                    bSum += infos.get(j).b;
                }
            }

            answer = Math.min(answer, Math.abs(sSum - bSum));
        }

        System.out.println(answer);
    }
}
