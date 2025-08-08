import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int k = 0; k < 5; k++) {
            String[] arr = places[k];
            
            List<int[]> list = new LinkedList<>();
            char[][] map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[i][j] = arr[i].charAt(j);
                    if (map[i][j] == 'P') {
                        list.add(new int[]{i, j});
                    }
                }
            }
            
            answer[k] = check(list, map);
        }
    
        return answer;
    }
    
    private static int check(List<int[]> list, char[][] map) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int[] arr1 = list.get(i);
                int[] arr2 = list.get(j);
                
                int manha = Math.abs(arr1[0] - arr2[0]) + Math.abs(arr1[1] - arr2[1]);
                
                if (manha > 2) continue;
                
                if (manha == 1) return 0;
                if (manha == 2) {
                    if (arr1[0] == arr2[0] || arr1[1] == arr2[1]) {
                        int y = (arr1[0] + arr2[0]) / 2;
                        int x = (arr1[1] + arr2[1]) / 2;
                        
                        if (map[y][x] != 'X') {
                            return 0;
                        }
                    } else {
                        if (!(map[arr1[0]][arr2[1]] == 'X' && map[arr2[0]][arr1[1]] == 'X')) {
                            return 0;
                        }
                    }
                }  
            }
        }
        
        return 1;
    }
}