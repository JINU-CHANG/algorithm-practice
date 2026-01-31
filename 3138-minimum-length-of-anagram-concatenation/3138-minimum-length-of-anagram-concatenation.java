class Solution {

    public int minAnagramLength(String s) {
        for (int size = 1; size <= s.length(); size++) {
            if (s.length() % size != 0) continue;
            Set<String> set = new HashSet<>();
            for (int i = 0; i <= s.length() - size; i += size) {
                String substr = s.substring(i, i + size);
                char[] subchar = substr.toCharArray();
                Arrays.sort(subchar);

                String sortedstr = String.valueOf(subchar);
                //System.out.println(sortedstr);
                if (set.isEmpty()) set.add(sortedstr);
                if (!set.contains(sortedstr)) break;
                if (i == s.length() - size) {
                    return size;
                }
            }
        }

        return s.length();
    }
}