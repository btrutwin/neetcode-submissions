class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet sliding window problem
        // two pointers, fast and slow. Keep track of if letter has been seen in the HashSet 

        
        HashSet<Character> chars = new HashSet<>();
        int longestLength = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            // need to remove the char at left, and then advance left until no dupes 
            while(chars.contains(s.charAt(right))){
                chars.remove(s.charAt(left));
                left++;
            }
            chars.add(s.charAt(right));
            longestLength = Math.max(longestLength, right - left + 1);
        }

      
        return longestLength;
    }
}
