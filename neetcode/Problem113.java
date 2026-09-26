//Reorganize String

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem113 {
    class Letter implements Comparable<Letter> {
        char letter;
        int count;

        Letter(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        @Override
        public int compareTo(Letter o) {
            return o.count - count;
        }

        public int decrementCount() {
            this.count--;
            return count;
        }

        @Override
        public String toString() {
            return "Letter{" +
                    "letter=" + letter +
                    ", count=" + count +
                    '}';
        }

    }

    public String reorganizeString(String s) {
        if (s.length() == 1) return s;
        Map<Character, Integer> letterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            letterMap.put(s.charAt(i), letterMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Letter> heap = new PriorityQueue<>();
        for (char c : letterMap.keySet()) {
            heap.offer(new Letter(c, letterMap.get(c)));
        }
        char[] charArr = new char[s.length()];
        Letter prevLetter = null;
        int currIndex = 0;
        while (!heap.isEmpty()) {
            Letter maxOccurredLetter = heap.poll();
            charArr[currIndex++] = maxOccurredLetter.letter;
            int newCount = maxOccurredLetter.decrementCount();
            if (prevLetter != null) {
                heap.offer(prevLetter);
            }
            if (newCount > 0) prevLetter = maxOccurredLetter;
            else prevLetter = null;
        }
        if (currIndex!=s.length()) return "";
        else {
            StringBuilder sb = new StringBuilder();
            for (char c : charArr) sb.append(c);
            return sb.toString();
        }
    }
}

/*
total letters = 7
odd space = 3 (1,3,5)
even space = 4 (0,2,4,6)
at evenIndex = 0, even space left = evenSpace - evenIndex/2 = 4 - 0/2 = 4
at evenIndex = 2, even space left = evenSpace - evenIndex/2 = 4 - 2/2 = 3
at evenIndex = 4, even space left = evenSpace - evenIndex/2 = 4 - 4/2 = 2
at evenIndex = 6, even space left = evenSpace - evenIndex/2 = 4 - 6/2 = 1
at oddIndex = 1, odd space left = oddSpace - oddIndex/2 = 3 - 1/2 = 3
at oddIndex = 3, odd space left = oddSpace - oddIndex/2 = 3 - 3/2 = 2
at oddIndex = 5, odd space left = oddSpace - oddIndex/2 = 3 - 5/2 = 1
 */