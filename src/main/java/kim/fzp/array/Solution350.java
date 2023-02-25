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
        int[] intersect = intersect2(num1, num2);
        System.out.println(intersect);
    }

    /**
     * 哈希表
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

    /**
     * 排序 + 双指针
     * 如果两个数组是有序的，则可以使用双指针的方法得到两个数组的交集。
     * <p>
     * 首先对两个数组进行排序，然后使用两个指针遍历两个数组。
     * <p>
     * 初始时，两个指针分别指向两个数组的头部。每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。当至少有一个指针超出数组范围时，遍历结束。
     */
    static int[] intersect2(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        int index1 = 0, index2 = 0, index = 0;
        int[] result = new int[Math.min(num1.length, num2.length)];
        while (index1 < num1.length && index2 < num2.length) {
            if (num1[index1] < num2[index2]) {
                index1++;
            } else if (num1[index1] > num2[index2]) {
                index2++;
            } else {
                result[index] = num1[index1];
                index++;
                index1++;
                index2++;
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }
}
