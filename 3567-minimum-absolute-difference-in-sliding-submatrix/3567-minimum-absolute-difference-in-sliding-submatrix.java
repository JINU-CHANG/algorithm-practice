import java.util.*;

class Solution {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n - k + 1][m - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < m - k + 1; j++) {
                Set<Integer> set = new HashSet<>();
                for (int ik = 0; ik < k; ik++) {
                    for (int jk = 0; jk < k; jk++) {
                        set.add(grid[i + ik][j + jk]);
                    }
                }
                // 절대값 계산
                List<Integer> list = new ArrayList<>(set);
                Collections.sort(list);
                int min = Integer.MAX_VALUE;
                for (int l = 0; l < list.size() - 1; l++) {
                    min = Math.min(min, Math.abs(list.get(l) - list.get(l + 1)));
                }

                if (list.size() == 1) ans[i][j] = 0;
                else ans[i][j] = min;
            }
        }

        return ans;
    }
}