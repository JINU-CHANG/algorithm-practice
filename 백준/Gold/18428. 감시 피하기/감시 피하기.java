import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static char[][] map;
    static int[][] countMap;
    static int lookCount = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        countMap = new int[n][n];

        // 학생, 선생님 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        // 선생님들의 시야 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j] == 'T') {
                    for (int k = 0; k < 4; k++) {
                        recursive(i, j, k, 1);
                    }
                }
            }
        }

        // lookCount 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(countMap[i][j]);
            }
        }

        // 장애물 3개 설치 가능한지 확인
        for (int i = 0; i < 3; i++) {
            lookCount -= pq.poll();
        }

        if (lookCount <= 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean recursive(int i, int j, int k, int count) {
        boolean result = false;
        int ny = (count * dy[k]) + i;
        int nx = (count * dx[k]) + j;

        if (ny >= n || nx >= n || ny < 0 || nx < 0) return false;
        if (map[ny][nx] == 'S') {
            lookCount += 1;
            return true;
        }

        result = recursive(ny, nx, k, count);
        if (result && (map[ny][nx] == 'X')) {countMap[ny][nx] += 1;
        }
        return result;
    }
}
