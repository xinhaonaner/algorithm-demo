package kim.fzp.array;

/**
 * 题目26：删除排序数组中的重复项
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * author fzp
 * date 2023/3/7 15:09
 */
public class Solution26 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

}
