package kim.fzp.array;

/**
 * description
 * author fzp
 * date 2023/3/7 14:50
 */
public class Solution27_2 {

    /**
     * 双指针优化
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
