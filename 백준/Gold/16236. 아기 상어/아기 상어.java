import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int sharkSize = 2;
    static int count = 0;
    static int[] currentPosition;
    static int time = 0;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0}; // 상, 좌, 하, 우
    static int[] dx = {0, -1, 0, 1}; // 상, 좌, 하, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    currentPosition = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            int[] result = findFish(currentPosition);
            if (result == null) break;

           // System.out.println(Arrays.toString(currentPosition));
            map[result[0]][result[1]] = 0;
            count++;
            if (count == sharkSize) {
                sharkSize++;
                count = 0;
            }

            time += result[2];
            currentPosition = result;
        }

        System.out.println(time);
    }

    private static int[] findFish(int[] currentPosition) {
        Queue<int[]> distQueue = new LinkedList<>();
        Queue<int[]> fishQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });

        int min = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n][n];
        distQueue.offer(new int[]{currentPosition[0], currentPosition[1], 0});
        visited[currentPosition[0]][currentPosition[1]] = true;

        while (!distQueue.isEmpty()) {
            int[] polled = distQueue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = polled[0] + dy[i];
                int nx = polled[1] + dx[i];

                if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] > sharkSize) continue; // 자신보다 큰 물고기 있는 칸 지날 수 없음
                if (polled[2] >= min) break;

                if (0 < map[ny][nx] && map[ny][nx] < sharkSize) {
                    fishQueue.add(new int[]{ny, nx, polled[2] + 1});
                    min = polled[2] + 1;
                }

                visited[ny][nx] = true;
                distQueue.offer(new int[]{ny, nx, polled[2] + 1});
            }
        }

        if (fishQueue.isEmpty()) return null;
        return fishQueue.poll();
    }
}
