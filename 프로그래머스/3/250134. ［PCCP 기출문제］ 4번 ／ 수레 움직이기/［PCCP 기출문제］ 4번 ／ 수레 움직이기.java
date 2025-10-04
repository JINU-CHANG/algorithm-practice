import java.util.*;

class Solution {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int[][] redVisited;
    int[][] blueVisited;
    boolean redArrived = false;
    boolean blueArrived = false;
    int answer = Integer.MAX_VALUE; // 최소 이동 횟수
    int h, w;

    public int solution(int[][] maze) {
        int ry = 0, rx = 0, by = 0, bx = 0;

        h = maze.length;
        w = maze[0].length;
        redVisited = new int[h][w];
        blueVisited = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(redVisited[i], Integer.MAX_VALUE);
            Arrays.fill(blueVisited[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (maze[i][j] == 1) {
                    ry = i; rx = j;
                    redVisited[i][j] = 0;
                } else if (maze[i][j] == 2) {
                    by = i; bx = j;
                    blueVisited[i][j] = 0;
                }
            }
        }

        dfs(maze, ry, rx, by, bx, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(int[][] maze, int ry, int rx, int by, int bx, int depth) {
        // 둘 다 도착했으면 답 갱신
        if (redArrived && blueArrived) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nry = ry, nrx = rx;
            boolean rReached = redArrived;
            if (!redArrived) {
                nry = ry + dy[i];
                nrx = rx + dx[i];
                if (outOfRange(nry, nrx) || maze[nry][nrx] == 5) continue;
                if (redVisited[nry][nrx] <= depth + 1) continue;
            }

            for (int j = 0; j < 4; j++) {
                int nby = by, nbx = bx;
                boolean bReached = blueArrived;
                if (!blueArrived) {
                    nby = by + dy[j];
                    nbx = bx + dx[j];
                    if (outOfRange(nby, nbx) || maze[nby][nbx] == 5) continue;
                    if (blueVisited[nby][nbx] <= depth + 1) continue;
                }

                // 같은 칸 불가
                if (nry == nby && nrx == nbx) continue;
                // 서로 교차 불가
                if (nry == by && nrx == bx && nby == ry && nbx == rx) continue;

                // 도착 여부 갱신
                if (maze[nry][nrx] == 3) rReached = true;
                if (maze[nby][nbx] == 4) bReached = true;

                // 방문 처리
                int prevR = redVisited[nry][nrx];
                int prevB = blueVisited[nby][nbx];
                redVisited[nry][nrx] = depth + 1;
                blueVisited[nby][nbx] = depth + 1;

                boolean prevRedArr = redArrived;
                boolean prevBlueArr = blueArrived;
                redArrived = rReached;
                blueArrived = bReached;

                dfs(maze, nry, nrx, nby, nbx, depth + 1);

                // 백트래킹 (원상복구)
                redVisited[nry][nrx] = prevR;
                blueVisited[nby][nbx] = prevB;
                redArrived = prevRedArr;
                blueArrived = prevBlueArr;
            }
        }
    }

    private boolean outOfRange(int y, int x) {
        return (y < 0 || x < 0 || y >= h || x >= w);
    }
}