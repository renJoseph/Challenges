package challenges.medium.searchInRotatedSortedArray;

public class Solution {
    public static void main(String[] args) {
        
    }

    public int search(int[] nums, int target) {
        int i = 0;
        for(int n : nums){
            if(n == target){
                return i;
            } i++;
        } return -1;
    }
}
