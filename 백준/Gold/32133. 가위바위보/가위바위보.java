import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    List<Character> trace;
    List<Integer> winners;
    int cnt;

    public Node(List<Character> trace, List<Integer> winners, int cnt) {
        this.trace = trace;
        this.winners = winners;
        this.cnt = cnt;
    }
}

public class Main {

    static int n, m, k;
    static Character[] rsp = {'R', 'S', 'P'};
    static Character[][] frsp;
    static Map<Character, Character> map = new HashMap<>();
    static Queue<Node> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    static {
        map.put('R', 'P');
        map.put('S', 'R');
        map.put('P', 'S');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        frsp = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String rsp = br.readLine();
            for (int j = 0; j < rsp.length(); j++) {
                frsp[i][j] = rsp.charAt(j);
            }
        }
        bfs();
        System.out.println(sb);
    }

    public static void bfs() {
        initQueue();

        while (!queue.isEmpty()) {
            Node polled = queue.poll();

            if (polled.cnt == m) {
                sb.append(-1);
                return;
            }

            for (int i = 0; i < 3; i++) {
                Character nrsp = rsp[i];
                List<Integer> nwinners = getWinners(nrsp, polled.winners, polled.cnt);
                List<Character> ntrace = new ArrayList<>(polled.trace);
                ntrace.add(nrsp);

                if (nwinners.isEmpty()) continue;
                if (polled.cnt <= m && nwinners.size() <= k) {
                    sb.append(polled.cnt + 1).append("\n");
                    printTrace(ntrace);
                    return;
                }

                queue.add(new Node(ntrace, nwinners, polled.cnt + 1));
            }
        }
    }

    public static List<Integer> getWinners(Character mrsp, List<Integer> participants, int round) {
        List<Integer> winners = new ArrayList<>();

        for (int j = 0; j < participants.size(); j++) {
            if (isWin(mrsp, frsp[participants.get(j)][round])) {
                winners.add(participants.get(j));
            }
        }

        return winners;
    }

    public static void initQueue() {
        List<Integer> initWinners = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            initWinners.add(i);
        }

        for (int i = 0; i < 3; i++) {
            queue.add(new Node(List.of(rsp[i]), initWinners, 0));
        }
    }

    public static boolean isWin(char mrsp, char frsp) {
        return map.get(mrsp).equals(frsp);
    }

    public static void printTrace(List<Character> trace) {
        for (int i = 1; i < trace.size(); i++) {
            sb.append(trace.get(i));
        }
    }
}

