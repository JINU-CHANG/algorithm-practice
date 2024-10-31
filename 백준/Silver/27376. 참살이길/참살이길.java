import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
    int x;
    int t;
    int s;

    public Info(int x, int t, int s) {
        this.x = x;
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Info o) {
        return this.x - o.x;
    }
}

public class Main {

    static int n, k;
    static List<Info> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            list.add(new Info(x, t, s));
        }

        Collections.sort(list);

        System.out.println(solve());
    }

    public static long solve() {
        int beforeX = 0;
        long totalS = 0;

        for(Info info : list) {
            // (현재 - 이전거리)
            int distance = info.x - beforeX;
            totalS += distance;

            // 초록불이 될떄까지 기다리는 시간
            if ((totalS - info.s) < 0) {
                totalS += info.s - totalS;
            } else {
                long period = (totalS - info.s) / info.t;
                if (period % 2 != 0) {
                    totalS += ((period + 1) * info.t) + info.s - totalS;
                }
            }

            beforeX = info.x;
        }

        return totalS + (n - beforeX);
    }
}
