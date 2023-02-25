package kim.fzp.array;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * <p>
 * author fzp
 * date 2023/2/25 17:08
 */
public class Solution14_2 {

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        String prefix = longestCommonPrefix(strings);
        System.out.println(prefix);
    }

    public static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        int length = strings[0].length();
        int count = strings.length;
        for (int i = 0; i < length; i++) {
            char c = strings[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strings[j].length() || c != strings[j].charAt(i)) {
                    return strings[0].substring(0, i);
                }
            }
        }
        return strings[0];
    }

}
