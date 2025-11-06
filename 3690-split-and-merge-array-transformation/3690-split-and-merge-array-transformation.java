class Node {
    List<Integer> list;
    int count;

    Node(List<Integer> list, int count) {
        this.list = list;
        this.count = count;
    }
}

class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        Set<List<Integer>> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
       
        List<Integer> nums1List = new LinkedList<>();
        for (int x : nums1) {
            nums1List.add(x);
        }
        queue.add(new Node(nums1List, 0));

        List<Integer> target = new LinkedList<>();
        for (int x : nums2) {
            target.add(x);
        }

        if (nums1List.equals(target)) return 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<Integer> list = node.list;
            for (int i = 1; i < list.size(); i++) {
                for (int j = 0; j + i <= list.size(); j++) {
                    List<Integer> left = list.subList(0, j);
                    List<Integer> right = list.subList(j + i, list.size());
                    List<Integer> mid = list.subList(j, j + i);

                    List<Integer> nList = new LinkedList<>();
                    nList.addAll(left);
                    nList.addAll(right);

                    for (int k = 0; k <= nList.size(); k++) {
                        List<Integer> finalList = new LinkedList<>(nList);
                        finalList.addAll(k, mid);
                        
                        if (finalList.equals(target)) {
                            return node.count + 1;
                        }

                        if (set.contains(finalList)) continue;
                        set.add(finalList);
                        queue.offer(new Node(finalList, node.count + 1));
                    }
                }
            }
        }
        return 0;
    }
}