class Solution {

    public String smallestNumber(String pattern) {
        return String.valueOf(findSmallestNumber(pattern, 0, 0, 0));
    }
    private int findSmallestNumber(
        String pattern,
        int currentPosition,
        int usedDigitsMask,
        int currentNum
    ) {
        if (currentPosition > pattern.length()) return currentNum;

        int result = Integer.MAX_VALUE;
        int lastDigit = currentNum % 10;
        boolean shouldIncrement = currentPosition == 0 || pattern.charAt(currentPosition - 1) == 'I';

        for (int currentDigit = 1; currentDigit <= 9; ++currentDigit) {
            if ((usedDigitsMask & (1 << currentDigit)) == 0 && currentDigit > lastDigit == shouldIncrement){
                result = Math.min(result, findSmallestNumber(pattern, currentPosition + 1,
                    usedDigitsMask | (1 << currentDigit),
                    currentNum * 10 + currentDigit));
                }
        }

        return result;
    }
}