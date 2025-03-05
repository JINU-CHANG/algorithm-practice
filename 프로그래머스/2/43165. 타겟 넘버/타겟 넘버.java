class Solution {

    static char[] operator = {'+', '-'};
    static char[] result;

    static int answer = 0;

    public int solution(int[] numbers, int target) {
        result = new char[numbers.length];

        for (int i = 0; i < 2; i++) {
            result[0] = operator[i];
            dfs(0, numbers, target);
        }

        return answer;
    }

    private static void dfs(int count, int[] numbers, int target) {
        if (count == numbers.length - 1) {
            int value = 0;
            for (int i = 0; i < result.length; i++) {
                if (result[i] == '+') value += numbers[i];
                else value -= numbers[i];
            }

            if (value == target) answer++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            result[count + 1] = operator[i];
            dfs(count + 1, numbers, target);
        }
    }

}
