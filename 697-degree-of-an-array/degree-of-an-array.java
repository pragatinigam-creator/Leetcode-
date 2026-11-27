
import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, int[]> map = new HashMap<>();

        int degree = 0;
        int answer = nums.length;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (!map.containsKey(num)) {
                // [frequency, first index, last index]
                map.put(num, new int[]{1, i, i});
            } 
            else {
                int[] arr = map.get(num);

                arr[0]++;  // Increase frequency
                arr[2] = i; // Update last index
            }

            int[] arr = map.get(num);

            if (arr[0] > degree) {
                degree = arr[0];

                answer = arr[2] - arr[1] + 1;
            } 
            else if (arr[0] == degree) {

                answer = Math.min(
                    answer,
                    arr[2] - arr[1] + 1
                );
            }
        }

        return answer;
    }
}
