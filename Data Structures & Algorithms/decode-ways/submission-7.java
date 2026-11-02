class Solution {
    public int numDecodings(String s) {
        int prev2 = 1;
int prev1 = (s.charAt(0) == '0') ? 0 : 1;
for (int i = 2; i <= s.length(); i++) {
    int one = s.charAt(i - 1) - '0';
    int two = (s.charAt(i - 2) - '0') * 10 + one;
    int cur = 0;
    if (one >= 1) cur += prev1;
    if (two >= 10 && two <= 26) cur += prev2;
    prev2 = prev1;
    prev1 = cur;
}
return prev1;
    }
}
