import java.util.*;

class Info implements Comparable<Info> {
    String end;
    boolean visited;
    
    Info(String end) {
        this.end = end;
        this.visited = false;
    }
    
    @Override
    public int compareTo(Info o) {
    return this.end.compareTo(o.end);
    }
}

class Solution {

    static boolean flag;
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];

        // 정보 저장
        Map<String, List<Info>> map = new HashMap<>();
        for (String[] values : tickets) {
            map.put(values[0], new ArrayList<>());
            map.put(values[1], new ArrayList<>());
        }

        for (String[] values : tickets) {
            map.get(values[0]).add(new Info(values[1]));
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        answer[0] = "ICN";
        dfs(answer, map, "ICN", 0, tickets.length);
        return answer;
    }

    private void dfs(String[] answer, Map<String, List<Info>> map, String start, int count, int size) {
        if (count == size) {
            flag = true;
            return;
        }

        for (Info info : map.get(start)) {
            if (flag || info.visited) continue;

            answer[count + 1] = info.end;
            info.visited = true;
            dfs(answer, map, info.end, count + 1, size);
            info.visited = false;
        }
    }
}