class Solution {
    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        if(len%2==1){
            return false;
        }
        Stack<Integer> openB = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        for(int i=0; i<len; i++){
            if(locked.charAt(i) == '0'){
                unlocked.push(i);
            }else if(s.charAt(i) == '('){
                openB.push(i);
            }else if(s.charAt(i) == ')'){
                if(!openB.isEmpty()){
                    openB.pop();
                }else if(!unlocked.isEmpty()){
                    unlocked.pop();
                }else{
                    return false;
                }
            }
        }

        while(!unlocked.isEmpty() && !openB.isEmpty() && openB.peek()<unlocked.peek()){
            openB.pop();
            unlocked.pop();
        }
        if(!openB.isEmpty()){
            return false;
        }
        return true;
    }
}