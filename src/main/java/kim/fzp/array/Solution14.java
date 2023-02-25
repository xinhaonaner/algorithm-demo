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
public class Solution14 {

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        String prefix = longestCommonPrefix(strings);
        System.out.println(prefix);
    }

    public static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        String prefix = strings[0];
        for (int i = 0; i < strings.length; i++) {
            prefix = longestCommonPrefix(prefix, strings[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }

        return str1.substring(0, index);
    }

}
