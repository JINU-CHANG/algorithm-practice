import java.util.*;

class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(IntStream.range(1, n + 1).boxed().toList());
        Collections.sort(list, Comparator.comparing(String::valueOf));
        return list;
    }
}