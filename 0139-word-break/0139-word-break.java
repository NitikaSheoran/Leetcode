class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        // seen.add(0);


        while(!queue.isEmpty()){
            int start = queue.poll();

            if(start == s.length()) return true;

            for(int end = start+1; end<=s.length(); end++){
                if(seen.contains(end)) continue;
                if(wordDict.contains(s.substring(start, end))){
                    queue.add(end);
                    seen.add(end);
                    // break;
                }
            }
        }

        return false;
    }
}