import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            dp.add(new ArrayList<>());
        }
        
        dp.get(1).add(N);
        if (N == number) return 1;
        
        for (int i = 2; i <= 8; i++) {
            List<Integer> result = dp.get(i);
            for (int j = 1; j < i; j++) {
                int nN = Integer.parseInt(String.valueOf(N).repeat(i));
                List<Integer> list1 = dp.get(j);
                List<Integer> list2 = dp.get(i - j);
                
                result.add(nN);
                for (int a : list1) {
                    for (int b : list2) {
                        result.add(a + b);
                        result.add(a - b);
                        result.add(a * b);
                        if (a != 0 && b != 0) result.add(a / b);
                    }
                }
            }
            
            for (int x : result) {
                if (x == number) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}