import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>(); // 듣지 못한 사람의 명단
        Set<String> ans = new TreeSet<>(); // 듣보잡 명단

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (set.contains(name)) {
                ans.add(name);
            }
        }

        System.out.println(ans.size());
        ans.stream().forEach(a -> System.out.println(a));
    }
}
