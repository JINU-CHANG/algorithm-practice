import java.util.*;

class Solution {
    
    static int[][] array;
    
    public int[] solution(int[][] edges) {
        int[] result = new int[4];
        // max 값 찾기
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < edges.length; i++) {
            max = Math.max(max, Math.max(edges[i][0], edges[i][1]));
        }
        
        array = new int[max + 1][2];
        // 간선 정보 초기화
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0]; 
            int to = edges[i][1];
            
            array[from][1] += 1; // out
            array[to][0] += 1; // in
        }
        
        // 답 구하기
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            // new 정점
            if (array[i][0] == 0 && array[i][1] >= 2) {
                result[0] = i;
                continue;
            }
            
            // 막대그래프
            if (array[i][0] >= 1 && array[i][1] == 0) {
                result[2] += 1;
                sum += 1;
                continue;
            }
            
            // 8자그래프
            if (array[i][0] >= 2 && array[i][1] >= 2) {
                result[3] += 1;
                sum += 1;
                continue;
            }
        }
        
        result[1] = array[result[0]][1] - sum;
        return result;
    }
}