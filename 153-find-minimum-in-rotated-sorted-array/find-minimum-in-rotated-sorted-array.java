

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            if(nums[low] < nums[high]){//Entire array in search space is sorted, thus the 1st elt will the min elt, This point will only come in search space when after eliminating we have already crossed the pivot point(ie the point of rotation)
                ans = Math.min(ans, nums[low]);
                break;
            }
            int mid = low + (high - low)/2;
            //Left half is sorted, pick the min and eliminate the left half.
            if(nums[low] <= nums[mid]){ //Equality is imp in this condn coz when search space is small, low and mid can point to same elt as well.
                ans = Math.min(ans, nums[low]);
                low = mid+1;
            }else{  //Right half is sorted, pick the min from rt half and eliminate the right half.
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}