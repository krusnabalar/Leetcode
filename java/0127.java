import java.util.*;

class Solution {
    int n;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        n = beginWord.length();
        if (n != endWord.length()) {
            return 0;
        }

        boolean endWordInList = false;
        for (String word : wordList) {
            if (word.length() != n) { return 0; }
            if (endWord.equals(word)) { endWordInList = true;}
        }

        if (!endWordInList) {
            return 0;
        }

        int count = 1;
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        while (!reached.contains(endWord)) {
            Set<String> newReached = new HashSet<>();
            for (String word : reached) {
                for (int i = 0; i < wordList.size(); i++) {
                    String dst = wordList.get(i);
                    if (reached.contains(dst)) {
                        continue;
                    }
                    if (isOneAway(word, dst)) {
                        if (dst.equals(endWord)) {
                            return count + 1;
                        }
                        newReached.add(dst);
                    }
                }
            }
            count++;
            for (String s : reached) {
                wordList.remove(s);
            }
            if (newReached.size() == 0) { return 0; }
            reached = newReached;
        }
        return count;
    }

    private boolean isOneAway(String one, String two) {
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (one.charAt(i) != two.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
