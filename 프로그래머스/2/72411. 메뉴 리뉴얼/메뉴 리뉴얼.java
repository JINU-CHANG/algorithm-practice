import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    static Map<String, Integer> map = new HashMap<>();
    static char[] temp;
    static int[] maxArr;
    static List<String> answer = new LinkedList<>();
    
    public String[] solution(String[] orders, int[] course) {
        for (int i : course) {
            set.add(i);
        }
        maxArr = new int[course[course.length - 1] + 1];
        
        for (String s : orders) {
            char[] carr = s.toCharArray();
            Arrays.sort(carr);
            temp = new char[carr.length];
            dfs(String.valueOf(carr), -1, 0);
        }
        
        for (int i : course) {
            for (String s : map.keySet()) {
                if (s.length() == i && map.get(s) == maxArr[i] && maxArr[i] >= 2) {
                    System.out.println("=====");
                    System.out.println(s);
                    answer.add(s);
                }
            }
        }
        
        Collections.sort(answer);
        String[] arranswer = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            arranswer[i] = answer.get(i);
        }
        return arranswer;
    }
    
    // dfs -> 조합찾기
    private void dfs(String s, int idx, int count) {
        if (set.contains(count)) {
            String ns = convertString(count);
            if (map.containsKey(ns)) {
                map.put(ns, map.get(ns) + 1);
            } else {
                map.put(ns, 1);
            }
            
            maxArr[count] = Math.max(maxArr[count], map.get(ns));
            //System.out.println(ns);
        }
        
        for (int i = idx + 1; i < s.length(); i++) {
            temp[count] = s.charAt(i);
            
            dfs(s, i, count + 1);
        }
    }
    
    private String convertString(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(temp[i]);
        }
        return sb.toString();
    }
}