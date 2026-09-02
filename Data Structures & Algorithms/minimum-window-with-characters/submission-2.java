class Solution {
    public String minWindow(String s, String t) {
        int[] tArr = new int[52];
        int[] sArr = new int[52];
        int distinctChars = 0;
        int matches = 0;
        String bestSubstring = "";
        // need to loop through t. at t.getIndex(t.charAt(i)), increment for each letter in t
        // also need to loop through tArr after to see how many distinct chars there are

        for (int i = 0; i < t.length(); i++) {
            int updateIndex = getIndex(t.charAt(i));
            if (tArr[updateIndex] == 0) {
                distinctChars++;
            }
            tArr[updateIndex]++;
        }
        int bestRight = -1;
        int bestLeft = -1;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            int updateIdx = getIndex(s.charAt(right));
            if (tArr[updateIdx] != 0) {
                sArr[updateIdx]++;
                if (sArr[updateIdx] == tArr[updateIdx]) {
                    matches++;
                }
            }
            while (matches == distinctChars) {
                int removeIdx = getIndex(s.charAt(left));
                if (bestRight == -1 && bestLeft == -1) {
                    bestRight = right;
                    bestLeft = left;
                }
                if (bestRight - bestLeft > right - left) {
                    bestRight = right;
                    bestLeft = left;
                }
                if (sArr[removeIdx] != 0) {
                    sArr[removeIdx]--;
                    if (sArr[removeIdx] < tArr[removeIdx]) {
                        matches--;
                    }
                }
                left++;
            }
        }
        if (bestRight == -1 && bestLeft == -1) {
            return bestSubstring;
        }
        return s.substring(bestLeft, bestRight + 1);
    }
    // use to cover capital and lowercase letters correctly
    private int getIndex(char c) {
        return Character.isUpperCase(c) ? c - 'A' + 26 : c - 'a';
    }
}
