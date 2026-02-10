import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Info {
    int x; // 우체국 위치
    int num;

    Info(int x, int num) {
        this.x = x;
        this.num = num;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Info> infos = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            infos.add(new Info(x, num));
            sum += num;
        }

        Collections.sort(infos, Comparator.comparingInt(i -> i.x));

        long tempsum = 0;
        for (Info info : infos) {
            tempsum += info.num;

            if ((sum + 1) / 2 <= tempsum) {
                System.out.println(info.x);
                return;
            }
        }

        System.out.println(infos.get(infos.size() - 1).x);
    }
}
