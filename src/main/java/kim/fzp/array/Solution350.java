package kim.fzp.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 第350题：两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * <p>
 * author fzp
 * date 2023/2/25 14:33
 */
public class Solution350 {

    public static void main(String[] args) {
        int[] num1 = new int[]{
                1, 2, 3, 2, 1
        };
        int[] num2 = new int[]{
                2, 2
        };
        int[] intersect = intersect(num1, num2);
        System.out.println(intersect);
    }

    /**
     * 由于同一个数字在两个数组中都可能出现多次，因此需要用哈希表存储每个数字出现的次数。对于一个数字，其在交集中出现的次数等于该数字在两个数组中出现次数的最小值。
     * <p>
     * 首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，然后遍历第二个数组，对于第二个数组中的每个数字，如果在哈希表中存在这个数字，则将该数字添加到答案，并减少哈希表中该数字出现的次数。
     * <p>
     * 为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，然后遍历较长的数组得到交集。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static int[] intersect(int[] num1, int[] num2) {
        if (num1.length > num2.length) {
            return intersect(num2, num1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : num1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[num1.length];
        int index = 0;
        for (int num : num2) {
            Integer count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
            }
            if (count > 0) {
                map.put(num, count);
            } else {
                map.remove(num);
            }
        }

        return Arrays.copyOfRange(intersection, 0, index);
    }
}
