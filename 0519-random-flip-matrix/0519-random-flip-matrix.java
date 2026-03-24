import java.util.*;

class Solution {

    private int h;
    private int w;
    private int size;
    private Map<Integer, Integer> map;

    public Solution(int m, int n) {
        h = m;
        w = n;
        size = m * n;
        map = new HashMap<>();
    }
    
    public int[] flip() {
        int idx = (int) (Math.random() * size);
        int temp = map.getOrDefault(idx, idx);
        map.put(idx, map.getOrDefault(size - 1, size - 1));
        size--;
        return new int[]{temp / w, temp % w};
    }
    
    public void reset() {
        size = h * w;
        map.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */