import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int ans = 1;
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{s, t};
        }

        Arrays.sort(arr, (a1, a2) -> {
           if (a1[0] == a2[0]) {
               return a1[1] - a2[1];
           } else {
               return a1[0] - a2[0];
           }
        });

        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);

        for (int i = 1; i < n; i++) {
            int endTime = pq.peek();
            int startTime = arr[i][0];

            if (endTime <= startTime) {
                pq.poll();
            } else {
                ans++; // 강의실 추가
            }

            pq.add(arr[i][1]);
        }

        System.out.println(ans);
    }
}
