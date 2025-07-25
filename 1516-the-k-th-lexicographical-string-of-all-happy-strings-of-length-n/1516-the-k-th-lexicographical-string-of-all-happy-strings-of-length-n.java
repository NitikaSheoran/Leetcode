class Solution {

    public String getHappyString(int n, int k) {
        Stack<String> stringsStack = new Stack<>();
        int indexInSortedList = 0;
        stringsStack.push(""); 

        while (stringsStack.size() > 0) {
            String currentString = stringsStack.pop();

            if (currentString.length() == n) {
                indexInSortedList++;
                if (indexInSortedList == k) {
                    return currentString;
                }
                continue;
            }

            for (char currentChar = 'c'; currentChar >= 'a'; currentChar--) {
                if (
                    currentString.length() == 0 ||
                    currentString.charAt(currentString.length() - 1) !=
                    currentChar
                ) {
                    stringsStack.push(currentString + currentChar);
                }
            }
        }
        return "";
    }
}