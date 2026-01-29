import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        for (; t > 0; t--) {
            String s = new StringTokenizer(br.readLine()).nextToken();

            char[] carray = s.toCharArray();
            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
                return carray[i1] - carray[i2];
            });

            pq.add(carray.length - 1);

            int changeIdx = 0;
            int i = carray.length - 1;
            for (; i >= 1; i--) {
                char x1 = carray[i - 1];
                char x2 = carray[i];

                if (x1 < x2) {
                    while (!pq.isEmpty()) {
                        int polled = pq.poll();
                        if (carray[polled] > x1) {
                            changeIdx = polled;
                            break;
                        }
                    }

                    carray[i - 1] = carray[changeIdx];
                    carray[changeIdx] = x1;
                    break;
                }

                pq.add(i - 1);
            }

            if (i > 0) Arrays.sort(carray, i, carray.length);
            sb.append(carray).append("\n");
        }

        System.out.println(sb);
    }
}
