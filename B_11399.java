import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_11399 {
    static int N;
    static List<Integer> times = new ArrayList<>();
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            times.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(times, Collections.reverseOrder());

        for (int i=1; i<=N; i++) {
            ans += times.get(i-1) * i;
        }

        System.out.println(ans);
    }
}
