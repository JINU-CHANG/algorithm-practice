import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> edgeList = new ArrayList<>(); // 저장배열
    static List<Boolean> visited = new ArrayList<>(); // 체크배열
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점
        int M = Integer.parseInt(st.nextToken()); // 간선

        for (int i = 0; i < N + 1; i++) { // 초기화
            edgeList.add(new LinkedList<>());
            visited.add(Boolean.FALSE);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeList.get(from).add(to);
            edgeList.get(to).add(from);
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited.get(i)) {
                visit(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void visit(int start) {
        visited.set(start, Boolean.TRUE);

        for (Integer x : edgeList.get(start)) {
            if (!visited.get(x)) visit(x);
        }
    }
}
