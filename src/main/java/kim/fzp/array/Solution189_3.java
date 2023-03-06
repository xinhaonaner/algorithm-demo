package kim.fzp.array;

/**
 * 旋转数组
 * author fzp
 * date 2023/3/6 13:56
 */
public class Solution189_3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] rotate = rotate(nums, 3);
        System.out.println(rotate);
    }

    /**
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     */
    public static int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        // 翻转所有元素
        reverse(nums, 0, nums.length - 1);
        // [0,k mod n−1] 区间的元素
        reverse(nums, 0, k - 1);
        // [k mod n,n−1] 区间的元素
        reverse(nums, k, nums.length - 1);

        return nums;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
