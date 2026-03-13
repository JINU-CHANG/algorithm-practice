import java.util.*;

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // 0 ~ right xor 0 ~ left - 1
        List<Integer> answer = new ArrayList<>();
        int[] sum = new int[arr.length];
    
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] ^ arr[i];
        }
        
        for (int[] query : queries) {
            if (query[0] == 0) answer.add(sum[query[1]]);
            else answer.add(sum[query[1]] ^ sum[query[0] - 1]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}