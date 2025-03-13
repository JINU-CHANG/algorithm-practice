class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int target = brown + yellow;
        for (int i = 1; i <= target; i++) {
            if (target % i == 0) {
                int x = target / i;
                int y = i;
                
                if ((x - 2) * (y - 2) == yellow) {
                    answer[0] = x;
                    answer[1] = y;
                    return answer;
                }
            }
        } 
        
        return answer;
    }
}