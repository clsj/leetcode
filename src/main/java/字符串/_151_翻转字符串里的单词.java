package 字符串;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class _151_翻转字符串里的单词 {

    public static void main(String[] args) {

        String s = "     hello  world xixi  haha  ";

        System.out.println("-" + new _151_翻转字符串里的单词().reverseWords(s) + "-");

//        "a good   example"
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int len = 0;
        int cur = 0;
        boolean space = true;
        for (int i = 0; i < length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            }else if (!space){
                chars[cur++] = ' ';
                space = true;
            }
        }

        len = space ? cur - 1 : cur;


        reverse(chars, 0, len - 1);

        int left = 0;

        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                reverse(chars, left, i - 1);
                left = i + 1;
            }
        }

        reverse(chars, left, len - 1);

        return new String(chars, 0, len);
    }

    public void reverse(char[] chars, int begin, int end) {
        while (begin >=0 && begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }

}
