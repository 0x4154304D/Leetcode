// time:O(n)    space:O(1)
class Solution {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}


// time:O(n)    space:O(n)
class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] hashTable = new int[nums.length];
        for(int i : nums){
            if(hashTable[i] != 0){
                return i;
            }
            ++hashTable[i];
        }
        return -1;
    }
}