import java.util.*;

class Node {
    int y;
    int x;

    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        // 누적합
        int h = grid.length;
        int w = grid[0].length;
        Node[][] prefixSum = new Node[h][w];

        
        if (grid[0][0] == 'X') {
            prefixSum[0][0] = new Node(0, 1);
        } else if (grid[0][0] == 'Y') {
            prefixSum[0][0] = new Node(1, 0);
        } else {
            prefixSum[0][0] = new Node(0, 0);
        }

        for (int i = 1; i < w; i++) {
            Node preNode = prefixSum[0][i - 1];
            if (grid[0][i] == 'X') {
                prefixSum[0][i] = new Node(preNode.y, preNode.x + 1);
            } else if (grid[0][i] == 'Y') {
                prefixSum[0][i] = new Node(preNode.y + 1, preNode.x);
            } else {
                prefixSum[0][i] = new Node(preNode.y, preNode.x);
            }
        }
        
        for (int i = 1; i < h; i++) {
            Node preNode4 = prefixSum[i - 1][0];
            if (grid[i][0] == 'X') {
                prefixSum[i][0] = new Node(preNode4.y, preNode4.x + 1);
            } else if (grid[i][0] == 'Y') {
                prefixSum[i][0] = new Node(preNode4.y + 1, preNode4.x);
            } else {
                prefixSum[i][0] = new Node(preNode4.y, preNode4.x);
            }

            for (int j = 1; j < w; j++) {
                Node preNode1 = prefixSum[i - 1][j];
                Node preNode2 = prefixSum[i][j - 1];
                Node preNode3 = prefixSum[i - 1][j - 1];
                int xCnt = preNode1.x + preNode2.x - preNode3.x;
                int yCnt = preNode1.y + preNode2.y - preNode3.y;
                if (grid[i][j] == 'X') {
                    prefixSum[i][j] = new Node(yCnt, xCnt + 1);
                } else if (grid[i][j] == 'Y') {
                    prefixSum[i][j] = new Node(yCnt + 1, xCnt);
                } else {
                    prefixSum[i][j] = new Node(yCnt, xCnt);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (prefixSum[i][j].x == prefixSum[i][j].y && prefixSum[i][j].x > 0) {
                   // System.out.println(i + " " + j);
                    ans++;
                }
            }
        }
        return ans;
    }
}