import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Info {
    char c;
    int idx;

    Info(char c, int idx) {
        this.c = c;
        this.idx = idx;
    }
}

public class Main {

    static String s;
    static boolean[] visited;
    static StringBuilder answer = new StringBuilder();
    static List<Info> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        visited = new boolean[s.length()];

        solve(-1);
        System.out.println(answer);
    }

    private static void solve(int startIdx) {
        Queue<Info> queue = new PriorityQueue((Comparator<Info>) (o1, o2) -> {
            if (o1.c - o2.c == 0) return o1.idx - o2.idx;
            return o1.c - o2.c; // 글자 순 정렬
        });

        for (int i = startIdx + 1; i < s.length(); i++) {
            queue.add(new Info(s.charAt(i), i));
        }

        while (!queue.isEmpty()) {
            Info polled = queue.poll();

            // 방문 체크
            if (visited[polled.idx]) continue;

            // print
            list.add(polled);
            saveAnswer();

            visited[polled.idx] = true;
            solve(polled.idx);
        }
    }

    private static void saveAnswer() {
        Collections.sort(list, (Comparator<Info>) (o1, o2) -> {
            return o1.idx - o2.idx; // 인덱스 순 정렬
        });

        for (Info o : list) {
            answer.append(o.c);
        }
        answer.append("\n");
    }
}
