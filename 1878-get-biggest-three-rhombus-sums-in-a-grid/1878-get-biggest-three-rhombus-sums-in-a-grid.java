import java.util.*;

class Solution {

    public int[] getBiggestThree(int[][] grid) {
        Set<Integer> set = new HashSet<>();

        // 가로 : m, 세로 : n
        int m = grid[0].length;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                set.add(grid[i][j]);
            }
        }

        int k = 2;
        while (true) {
            int y = k - 1;
            int x = 0;

            if (!isValid(y, x, k, m, n)) break;
            for (int i = y; i < n; i++) {
                for (int j = x; j < m; j++) {
                    if (isValid(i, j, k, m, n)) {
                        set.add(calculateSum(k, i, j, grid));
                    }
                }
            }

            k++;
        }
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        if (list.size() < 3) return list.stream().mapToInt(Integer::intValue).toArray();
        return list.subList(0, 3).stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isValid(int y, int x, int k, int m, int n) {
        return x >= 0 && x + (2 * (k - 1)) < m && y + (k - 1) < n && y - (k - 1) >= 0;
    }

    private int calculateSum(int k, int y, int x, int[][] grid) { // k = 3, startIdx = 3
        int length = k * 2 - 1;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int dist = (k - 1 - (Math.abs(k - 1 - i)));
            if (i == 0 || i == length - 1) {
                sum += grid[y + dist][x + i];
                continue;
            }
            sum += grid[y + dist][x + i];
            sum += grid[y - dist][x + i];
        }

       
        return sum;
    }
}