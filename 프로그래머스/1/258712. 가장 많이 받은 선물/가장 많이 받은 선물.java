import java.util.*;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        // 친구 인덱스 저장
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        
        // 주고받은 선물정보 저장
        int[][] info = new int[friends.length][friends.length];
        int[][] info2 = new int[friends.length][3];
        
        for (int i = 0; i < gifts.length; i++) {
            String[] splited = gifts[i].split(" ");
            int from = map.get(splited[0]); // 선물 준 사람
            int to = map.get(splited[1]); // 선물 받은 사람
            
            info[from][to] += 1;
            info2[from][0] += 1; // 준 선물
            info2[from][2] += 1; // 선물지수
            info2[to][1] += 1; // 받은 선물
            info2[to][2] -= 1;  // 선물지수
        }
    
        int[] result = new int[friends.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                if (info[i][j] > info[j][i]) {
                    result[i] += 1;
                } else if (info[i][j] < info[j][i]) {
                    result[j] += 1;
                } else {
                    if (info2[i][2] > info2[j][2]) {
                        result[i] += 1;
                    } else if (info2[i][2] < info2[j][2]) {
                        result[j] += 1;
                    }
                }
                
                max = Math.max(max, Math.max(result[j], result[i]));
            }
        }
        
    
        return max;
    }
}