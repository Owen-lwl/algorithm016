//127. 单词接龙
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//双向广度优先遍历
public class Word_Ladder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Set<String> beginVisited = new HashSet<>();
        Set<String> endVisited = new HashSet<>();
        beginVisited.add(beginWord);
        endVisited.add(endWord);
        int step = 1;

        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextBeginVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeEveryLetterOfEachWord(word, wordSet, beginVisited, endVisited, nextBeginVisited, visited)) {
                    return step + 1;
                }
            }
            beginVisited = nextBeginVisited;
            step++;
        }
        return 0;
    }

    private boolean changeEveryLetterOfEachWord(String word, Set<String> wordSet, Set<String> beginVisited, Set<String> endVisited, Set<String> nextBeginVisited, Set<String> visited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originChar) continue;
                charArray[i] = c;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (endVisited.contains(nextWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        nextBeginVisited.add(nextWord);
                    }
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }
}
