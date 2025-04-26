import java.util.*;

class HealthInfo {
    int health;
    int cnt;
    
    HealthInfo(int health, int cnt) {
        this.health = health;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(int[] bandage, int h, int[][] attacks) {
        int max = attacks[attacks.length - 1][0];
        int current = 0;
        
        HealthInfo hInfo = new HealthInfo(h, 0);
        for (int i = 1; i <= max; i++) {
            // 체력 확인
            if (hInfo.health <= 0) return -1;
            // 공격 확인
            if (i == attacks[current][0]) {
                hInfo.health -= attacks[current][1];
                hInfo.cnt = 0;
                current++;
            } else {
                // y 확인
                hInfo.health += bandage[1];
                if (hInfo.cnt == bandage[0] - 1) {
                    hInfo.cnt = 0; 
                    hInfo.health += bandage[2];
                } else {
                    hInfo.cnt += 1;
                }
                
                if (hInfo.health > h) {
                    hInfo.health = h;
                }
            }
        }
        
        if (hInfo.health <= 0) return -1;
        else return hInfo.health;
    }
}