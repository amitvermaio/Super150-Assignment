class Pair {
    String word;
    int steps;
    public Pair (String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        Set<String> st = new HashSet<>();
        for (int i=0; i<wordList.length; i++) {
            st.add((wordList[i]));
        }
        st.remove(startWord);
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.word;
            int val = curr.steps;
            
            if (word.equals(targetWord)) return val;
            
            for (int i=0; i<word.length(); i++) {
                for (char ch='a'; ch<='z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String newWord = new String(replacedCharArray);
                    if (st.contains(newWord)) {
                        st.remove(newWord);
                        q.add(new Pair(newWord, val+1));
                    }
                }
            }
        }
        return 0;
    }
}

public class WordLadder {
  
}
