
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int answer = 0;

        int[][] nArr = new int[m][n];
        int[][] mArr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) nArr[i][j] = grid[i][j];
                else nArr[i][j] = nArr[i][j - 1] + grid[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) mArr[j][i] = grid[j][i];
                else mArr[j][i] = mArr[j - 1][i] + grid[j][i];
            }
        }


        int k = 1;
        while (true) {
            if (k > m || k > n) break;

            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {

                    // 행 & 열 확인
                    int nSum = 0;
                    int mSum = 0;
                    for (int r = 0; r < k; r++) {
                        int temp1 = 0;
                        if (j == 0) temp1 = nArr[i + r][j + k - 1];
                        else temp1 = nArr[i + r][j + k - 1] - nArr[i + r][j - 1];

                        if (nSum == 0) nSum = temp1;
                        else if (nSum != temp1) {
                            nSum = -1;
                            break;
                        }

                        int temp2 = 0;
                        if (i == 0) temp2 = mArr[i + k - 1][j + r];
                        else temp2 = mArr[i + k - 1][j + r] - mArr[i - 1][j + r];

                        if (mSum == 0) mSum = temp2;
                        else if (mSum != temp2) {
                            mSum = -1;
                            break;
                        }
                    }

                    int lDSum = 0;
                    int rDSum = 0;
                    for (int r = 0; r < k; r++) {
                        lDSum += grid[i + r][j + r];
                        rDSum += grid[i + r][j + k - 1 - r];
                    }

                    //System.out.println(k + " " + lDSum + " " + rDSum + " " + nSum + " " + mSum);
                    if ((lDSum == rDSum && rDSum == nSum && nSum == mSum)) {
                        answer = k;
                    }
                }
            }

            k++;
        }
        return answer;
    }
}
