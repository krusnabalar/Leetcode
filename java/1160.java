class Solution {
    int[] charTally = new int[26];

    public int countCharacters(String[] words, String chars) {
        tallyChars(chars, this.charTally);

        int answer = 0;
        for (String word : words) {
            int[] tallyWord = new int[26];
            if (tallyChars(word, tallyWord))
                answer += word.length();
        }
        return answer;
    }

    private boolean tallyChars(String s, int[] tally) {
        for (Character c : s.toCharArray()) {
            tally[c - 'a']++;
            if (tally[c - 'a']++ >= charTally[c - 'a'])
                return false;
        }
        return true;
    }
}