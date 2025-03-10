class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public long countOfSubstrings(String word, int k) {
        return substrings(word, k) - substrings(word, k + 1);
    }
    public long substrings(String word, int k) {
        int l = 0, r = 0;
        HashMap<Character, Integer> vowel = new HashMap<>();
        int cons = 0;
        long count = 0;
        int n = word.length();

        while (r < n) {
            char ch = word.charAt(r);
            if (isVowel(ch)) {
                vowel.put(ch, vowel.getOrDefault(ch, 0) + 1);
            } else {
                cons++;
            }

            while (vowel.size() == 5 && cons >= k) {
                count += (n - r);  
                char leftChar = word.charAt(l);
                if (isVowel(leftChar)) {
                    vowel.put(leftChar, vowel.get(leftChar) - 1);
                    if (vowel.get(leftChar) == 0) {
                        vowel.remove(leftChar);
                    }
                } else {
                    cons--;
                }
                l++;
            }
            r++;
        }
        return count;
    }
}
