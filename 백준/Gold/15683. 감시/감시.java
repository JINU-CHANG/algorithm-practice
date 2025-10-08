import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class CCTVPosition {
    int y;
    int x;
    int num;

    CCTVPosition(int y, int x, int num) {
        this.y = y;
        this.x = x;
        this.num = num;
    }
}

public class Main {

    static int ans = Integer.MAX_VALUE;
    static int n, m;
    static int[][] map;
    static Map<Integer, Integer> directionNum = new HashMap<>();
    static int[] directionTemp;
    static List<CCTVPosition> cctvs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        directionNum.put(1, 4);
        directionNum.put(2, 2);
        directionNum.put(3, 4);
        directionNum.put(4, 4);
        directionNum.put(5, 1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new CCTVPosition(i, j, map[i][j]));
                }
            }
        }

        directionTemp = new int[cctvs.size()];
        dfs(0);
        System.out.println(ans);
    }

    // 1. dfs 가짓수 찾기
    private static void dfs(int cnt) {
        if (cnt == cctvs.size()) {
//            System.out.println(Arrays.toString(temp));
            int[][] checkMap = copyMap();
            for (int i = 0; i < directionTemp.length; i++) {
                int idx = directionTemp[i];
                CCTVPosition cctv = cctvs.get(i);

                if (cctv.num == 1) cctv1(cctv, idx, checkMap);
                else if (cctv.num == 2) cctv2(cctv, idx, checkMap);
                else if (cctv.num == 3) cctv3(cctv, idx, checkMap);
                else if (cctv.num == 4) cctv4(cctv, idx, checkMap);
                else cctv5(cctv, checkMap);
            }

            int num = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (checkMap[i][j] == 0) num++;
                }
            }

//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(checkMap[i]));
//            }
            ans = Math.min(ans, num);
            return;
        }

        int num = directionNum.get(cctvs.get(cnt).num);
        for (int i = 0; i < num; i++) {
            directionTemp[cnt] = i;
            dfs(cnt + 1);
        }
    }

    private static int[][] copyMap() {
        int[][] checkMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checkMap[i][j] = map[i][j];
            }
        }

        return checkMap;
    }

    private static void cctv1(CCTVPosition cctvPosition, int dIdx, int[][] checkMap) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int y = cctvPosition.y;
        int x = cctvPosition.x;

        while (true) {
            int ny = y + dy[dIdx];
            int nx = x + dx[dIdx];

            if (ny >= n || nx >= m || ny < 0 || nx < 0) break;
            if (checkMap[ny][nx] == 6) break;

            y = ny;
            x = nx;
            if (checkMap[ny][nx] != 0) continue;
            checkMap[ny][nx] = -1;

        }
    }

    private static void cctv2(CCTVPosition cctvPosition, int idx, int[][] checkMap) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int i = idx * 2; i < (idx * 2) + 2; i++) {
            int y = cctvPosition.y;
            int x = cctvPosition.x;

            while (true) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= n || nx >= m || ny < 0 || nx < 0) break;
                if (checkMap[ny][nx] == 6) break;

                y = ny;
                x = nx;
                if (checkMap[ny][nx] != 0) continue;
                checkMap[ny][nx] = -1;
            }
        }
    }

    private static void cctv3(CCTVPosition cctvPosition, int idx, int[][] checkMap) {
        int[] dy = {-1, 0, -1, 0, 1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1, 0, -1, 0, 1};

        for (int i = idx * 2; i < idx * 2 + 2; i++) {
            int y = cctvPosition.y;
            int x = cctvPosition.x;

            while (true) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= n || nx >= m || ny < 0 || nx < 0) break;
                if (checkMap[ny][nx] == 6) break;

                y = ny;
                x = nx;
                if (checkMap[ny][nx] != 0) continue;
                checkMap[ny][nx] = -1;
            }
        }
    }

    private static void cctv4(CCTVPosition cctvPosition, int idx, int[][] checkMap) {
        int[] dy = {-1, 0, 0, 1, 0, 0, -1, 1, 0, -1, 1, 0};
        int[] dx = {0, 1, -1, 0, 1, -1, 0, 0, -1, 0, 0, 1};

        for (int i = idx * 3; i < idx * 3 + 3; i++) {
            int y = cctvPosition.y;
            int x = cctvPosition.x;

            while (true) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= n || nx >= m || ny < 0 || nx < 0) break;
                if (checkMap[ny][nx] == 6) break;

                y = ny;
                x = nx;
                if (checkMap[ny][nx] != 0) continue;
                checkMap[ny][nx] = -1;
            }
        }
    }

    private static void cctv5(CCTVPosition cctvPosition, int[][] checkMap) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int y = cctvPosition.y;
            int x = cctvPosition.x;

            while (true) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= n || nx >= m || ny < 0 || nx < 0) break;
                if (checkMap[ny][nx] == 6) break;

                y = ny;
                x = nx;
                if (checkMap[ny][nx] != 0) continue;
                checkMap[ny][nx] = -1;
            }
        }
    }
}
