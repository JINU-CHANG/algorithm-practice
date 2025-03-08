import java.util.*;

class Info {
    String current;
    Set<String> set;
    
    Info(String current, Set<String> set) {
        this.current = current;
        this.set = set;
    }
    
    public boolean contains(String word) {
        return set.contains(word);
    }
}

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    private int bfs(String begin, String target, String[] words) {
        Queue<Info> queue = new ArrayDeque();
        Set<String> set = new HashSet<>();
        set.add(begin);
        queue.add(new Info(begin, set));
        
        while (!queue.isEmpty()) {
            Info polled = queue.poll();
            
            for (int i = 0; i < words.length; i++) {
                if (!canChange(polled.current, words[i])) continue;
                if (polled.contains(words[i])) continue;
                
                if (words[i].equals(target)) return polled.set.size();
                    
                Set<String> nset = new HashSet<>(polled.set);
                nset.add(words[i]);
                queue.add(new Info(words[i], nset));
            }
        }
                    
        return 0;
    }
                    
    private boolean canChange(String string1, String string2) {
        Arrays.sort(string1.toCharArray());
        Arrays.sort(string2.toCharArray());
        
        int count = 0;
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) != string2.charAt(i)) count++;
        }
        
        return count == 1;
    }
}