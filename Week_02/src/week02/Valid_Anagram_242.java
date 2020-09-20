package week02;

import java.util.Arrays;

/**
 * 方法一：排序
 * 时间复杂度： O(n*logn)
 * 空间复杂度: O(1)
 */
public class Valid_Anagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
/**
 * 方法二: 哈希表 (边增边减)
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
public class Valid_Anagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }
}

//方法二另一种写法(先增后减)
public class Valid_Anagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
