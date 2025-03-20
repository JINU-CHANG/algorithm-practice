import java.util.*;

class Solution {

    static char[] operators;
    static char[] result;
    static boolean[] visited;
    static long answer;
    static List<Long> numList = new ArrayList<>();
    static List<Character> opList = new ArrayList<>();

    public long solution(String expression) {
        // 연산식을 List로 분리
        int idx = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                opList.add(c);
                numList.add(Long.parseLong(expression.substring(idx, i)));
                idx = i + 1;
            }
        }
        numList.add(Long.parseLong(expression.substring(idx)));

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-') {
                set.add('-');
            } else if (expression.charAt(i) == '*') {
                set.add('*');
            } else if (expression.charAt(i) == '+') {
                set.add('+');
            }
        }

        System.out.println(set.size());

        operators = new char[set.size()];
        result = new char[set.size()];
        visited = new boolean[set.size()];

        int t = 0;
        for (char c : set) {
            operators[t] = c;
            t++;
        }

        // 경우의 수 계산
        for (int i = 0; i < result.length; i++) {
            visited[i] = true;
            result[0] = operators[i];
            dfs(i, 0);
            visited[i] = false;
        }

        return answer;
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == result.length - 1) {

            List<Long> numListtmp = new ArrayList<>(numList);
            List<Character> opListtmp = new ArrayList<>(opList);

            for (int i = 0; i < result.length; i++) {
                calculate(numListtmp, opListtmp, result[i]);
            }

            answer = Math.max(answer, Math.abs(numListtmp.get(0)));
        }

        for (int i = 0; i < result.length; i++) {
            if (i == idx) continue;
            if (visited[i]) continue;

            visited[i] = true;
            result[cnt + 1] = operators[i];
            dfs(i, cnt + 1);
            visited[i] = false;
        }
    }

    private static void calculate(List<Long> numListtmp, List<Character> opListtmp, char c) {
        long result = 0;
        for (int i = 0; i < opListtmp.size(); i++) {
            if (opListtmp.get(i) == c) {
                if (c == '+')
                    result = numListtmp.get(i) + numListtmp.get(i + 1);
                else if (c == '-')
                    result = numListtmp.get(i) - numListtmp.get(i + 1);
                else
                    result = numListtmp.get(i) * numListtmp.get(i + 1);

                numListtmp.set(i, result);
                numListtmp.remove(i + 1);
                opListtmp.remove(i);

                i--;
            }
        }
    }
}