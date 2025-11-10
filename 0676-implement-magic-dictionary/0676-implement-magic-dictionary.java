class MagicDictionary {

    private Set<String> words = new HashSet<>();

    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            words.add(s);
        }
    }
    
    public boolean search(String searchWord) {
        for (String s : words) {
            if (s.length() != searchWord.length()) continue;

            int count = 0;
            for (int i = 0; i < searchWord.length(); i++) {
                if (searchWord.charAt(i) != s.charAt(i)) count++;
            }

            if (count == 1) return true;
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */