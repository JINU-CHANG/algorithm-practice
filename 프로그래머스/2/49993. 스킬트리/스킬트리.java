import java.util.*;

class Solution {
    
    Set<Character> set = new HashSet<>();
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill.length(); i++) {
            set.add(skill.charAt(i));
        }
        
        for (String s : skill_trees) {
            answer += checkSkillTree(skill, s);
        }
        
        return answer;
    }
    
    private int checkSkillTree(String skill, String s) {
        int currentIdx = 0;
        
        for (int i = 0; i < s.length(); i++) {
                if (!set.contains(s.charAt(i))) continue;
                if (s.charAt(i) != skill.charAt(currentIdx)) return 0;
                currentIdx++;
        }
        return 1;
    }
}