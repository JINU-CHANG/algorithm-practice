import java.io.*;
import java.util.*;

class Position {
    int y;
    int x;
    
    Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    
    static Map<Integer, Position> map = new HashMap<>();
    static Position left = new Position(3, 0);
    static Position right = new Position(3, 2);
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(count, new Position(i, j));
                count++;
            }
        }
        map.put(0, new Position(3, 1));
        
        for (int i = 0; i < numbers.length; i++) {
            if (checkLeft(numbers[i], hand)) {
                answer += "L";
                left = map.get(numbers[i]);
            } else {
                answer += "R";
                right = map.get(numbers[i]);
            }
        }
    
        return answer;
    }
    
    private boolean checkLeft(int number, String hand) {
        if (number == 1 || number == 4 || number == 7) return true;
        if (number == 3 || number == 6 || number == 9) return false;
        
        Position target = map.get(number);
        int leftDis = calculateDis(left, target);
        int rightDis = calculateDis(right, target);
        
        if (leftDis == rightDis && hand.equals("left")) return true;
        return (leftDis < rightDis);
    }
    
    private int calculateDis(Position position1, Position position2) {
        return Math.abs(position1.y - position2.y) 
            + Math.abs(position1.x - position2.x);
    }
}