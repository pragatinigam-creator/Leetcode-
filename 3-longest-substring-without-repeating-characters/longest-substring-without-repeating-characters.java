class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray(); // Fixed capitalization

        for (int right = 0; right < arr.length; right++) {
            if (map.containsKey(arr[right])) {
                // Update left pointer if duplicate exists
                left = Math.max(left, map.get(arr[right]) + 1);
            }

            // Update max length
            res = Math.max(res, right - left + 1);

            // Store/update current character index
            map.put(arr[right], right);
        }

        return res;
    }
}