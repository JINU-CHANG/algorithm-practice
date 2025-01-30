import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static int n;
    static int[] numbers;
    static Integer[] high;
    static int currentHighIdx;
    static Queue<Integer> outQueue;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            numbers = new int[n];
            high = new Integer[n];
            outQueue = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
            currentHighIdx = 0;
            ans = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                numbers[j] = number;
                high[j] = number;
            }

            Arrays.sort(high, (o1, o2) -> -(o1 - o2));

            for (int j = 0; j < n; j++) {
                while (!outQueue.isEmpty()) {
                    Integer polled = outQueue.poll();
                    if (!polled.equals(high[currentHighIdx])) {
                        outQueue.add(polled);
                        break;
                    }
                    currentHighIdx += 1;
                }

                if (numbers[j] < high[currentHighIdx]) {
                    ans += (high[currentHighIdx] - numbers[j]);
                    outQueue.add(numbers[j]);
                } else {
                    currentHighIdx += 1;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
