package 字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class _3_无重复字符的最长子串 {
    // pi 是 上一次字符串出现的下标
    // li 是 i -1 无重复字符最长子串的开始下标
    // i是 就会有三种情况 pi 和 li 的大小不同的情况

    public static void main(String[] args) {
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();

        if (length == 0) return 0;

        char[] chars = s.toCharArray();

        Map<Character, Integer> prevIndex = new HashMap<>();

        prevIndex.put(chars[0], 0);

        int li = 0;
        int max = 1;
        for (int i = 1; i < length; i++) {
            Integer pi = prevIndex.getOrDefault(chars[i], -1);
            if (pi >= li) {
                li = pi + 1;
            }
            prevIndex.put(chars[i], i);
            max = Math.max(max, i - li + 1);
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int length = s.length();

        if (length == 0) return 0;

        char[] chars = s.toCharArray();

        int[] prevIndex = new int[128];
        Arrays.fill(prevIndex, -1);
        prevIndex[chars[0]] = 0;
        int li = 0;
        int max = 1;
        for (int i = 1; i < length; i++) {
            int pi = prevIndex[chars[i]];
            if (pi >= li) {
                li = pi + 1;
            }
            prevIndex[chars[i]] = i;
            max = Math.max(max, i - li + 1);
        }

        return max;
    }
}
