class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        Map<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int m = p.length();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (i >= m) {
                char toRemove = s.charAt(i - m);
                if (window.get(toRemove) == 1) {
                    window.remove(toRemove);
                } else {
                    window.put(toRemove, window.get(toRemove) - 1);
                }
            }
            if (window.equals(pMap)) {
                res.add(i - m + 1);
            }
        }

        return res;
    }
}
