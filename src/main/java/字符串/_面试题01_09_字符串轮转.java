package 字符串;

/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 */
public class _面试题01_09_字符串轮转 {

    // s1 + s1 包含s2的话就是旋转词
    public boolean isFlipedString(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        s1 = s1 + s1;
        return s1.contains(s2);
    }
}
