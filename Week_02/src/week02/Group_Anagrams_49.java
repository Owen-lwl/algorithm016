package week02;

import java.util.*;
/*
* 方法一：排序 + 哈希表
* 时间复杂度：O(N * K * logK)，其中 N是 strs 的长度，而 K 是 strs 中字符串的最大长度
* 空间复杂度：O(NK)
* */
public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
/*
* 方法二: 按计数分类 + 哈希表
* 时间复杂度: O(NK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。
* 空间复杂度: O(N)
* */
public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
