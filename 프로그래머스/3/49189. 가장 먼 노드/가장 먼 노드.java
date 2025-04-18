import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 초기화
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        // 노드, 간선 정보 저장
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            
            list.get(x).add(y);
            list.get(y).add(x);
        }
        
        int[] check = new int[n + 1];
        
        // 업데이트
        for (int i = 0; i < list.get(1).size(); i++) {
            check[list.get(1).get(i)] = 1;
            dfs(list, check, list.get(1).get(i));
        }
        
        // 최대값 확인
        int max = 0;
        for (int i = 1; i < check.length; i++) {
            System.out.println(i + " : " + check[i]);
            max = Math.max(max, check[i]);
        }
        
        for (int i = 2; i < check.length; i++) {
            if (check[i] == max) answer++;
        }
        return answer;
    }
    
    private static void dfs(List<List<Integer>> list, int[] check, int x) {
        for (Integer a : list.get(x)) {  // {3, 2}
            int before = check[a]; // 0
            int now = check[x] + 1; // 1
            
            if (before == 0 || (before != 0 && now < before)) {
                check[a] = now;
                dfs(list, check, a);
            }
        }
    }
}