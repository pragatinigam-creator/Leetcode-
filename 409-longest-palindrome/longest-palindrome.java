class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];  // ASCII characters
        
        // Count frequency
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        int length = 0;
        boolean oddFound = false;
        
        for (int c : count) {
            length += (c / 2) * 2;   // add pairs
            
            if (c % 2 == 1) {
                oddFound = true;     // one odd can go in center
            }
        }
        
        if (oddFound) {
            length += 1;
        }
        
        return length;
    }
}