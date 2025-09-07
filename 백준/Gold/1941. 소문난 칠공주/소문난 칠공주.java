import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static char[][] map = new char[5][5];
    static List<int[]> seatIdxs = new ArrayList<>();
    static int[][] temp = new int[7][2];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = s.charAt(j);
                seatIdxs.add(new int[]{i, j});
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int count) {
        if (count == 7) {
            if (canMakeMember()) answer++;
            return;
        }

        for (int i = idx; i < 25; i++) {
            temp[count] = seatIdxs.get(i);
            dfs(i + 1, count + 1);
        }
    }
    
    private static boolean canMakeMember() {
        boolean[][] visited = new boolean[5][5];
        
        int sCount = 0;
        for (int[] arr : temp) {
            visited[arr[0]][arr[1]] = true;
            if (map[arr[0]][arr[1]] == 'S') sCount++;
        }
        if (sCount < 4) return false;

        int memberCount = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{temp[0][0], temp[0][1]});
        visited[temp[0][0]][temp[0][1]] = false;

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = polled[0] + dy[i];
                int nx = polled[1] + dx[i];

                if (ny >= 5 || nx >= 5 || ny < 0 || nx < 0) continue;
                if (!visited[ny][nx]) continue;

                memberCount++;
                visited[ny][nx] = false;
                queue.offer(new int[]{ny, nx});
            }
        }

        if (memberCount == 7) return true;
        return false;
    }
}
