import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder1 {
  public static void main(String[] args) {
    WordLadder1 wl = new WordLadder1();
    String[] wordlist = { "poon", "plee", "same", "poie", "plea", "plie", "poin" };
    int ans = wl.wordLadderLength("toon", "plea", wordlist);
    System.out.println(ans);
  }

  public int wordLadderLength(String startWord, String targetWord,
      String[] wordList) {
    boolean contains = false;
    for (String w : wordList) {
      if (w.equals(targetWord)) {
        contains = true;
        break;
      }
    }
    if (!contains)
      return 0;
    wordList = addWord(startWord, wordList);
    List<List<Integer>> edges = new ArrayList<>();
    collectEdges(edges, wordList);
    
    int startWordIdx = 0;
    int targetWordIdx = 0;
    for (int i = 0; i < wordList.length; i++) {
      if (wordList[i].equals(startWord))
        startWordIdx = i;
      if (wordList[i].equals(targetWord))
        targetWordIdx = i;
    }
    class Node {
      int wordIdx;
      int distance;
      public Node(int wordIdx, int distance) {
        this.wordIdx = wordIdx;
        this.distance = distance;
      }
    }
    Queue<Node> queue = new LinkedList<>();
    boolean[] addedInQ = new boolean[wordList.length];
    queue.add(new Node(startWordIdx, 1));
    addedInQ[startWordIdx] = true;
    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      if (currentNode.wordIdx == targetWordIdx)
        return currentNode.distance;
      for (List<Integer> edge : edges) {
        if (!addedInQ[edge.get(1)] && edge.get(0) == currentNode.wordIdx) {
          queue.offer(new Node(edge.get(1), currentNode.distance + 1));
          addedInQ[edge.get(1)] = true;
        }
      }
    }
    return 0;
  }

  private void collectEdges(List<List<Integer>> edges, String[] wordlist) {

    for (int i = 0; i < wordlist.length; i++) {
      for (int j = 0; j < wordlist.length; j++) {
        if (i != j && isConnection(wordlist[i], wordlist[j])) {
          List<Integer> connection = new ArrayList<>(2);
          connection.add(i);
          connection.add(j);
          edges.add(connection);
        }
      }
    }
  }

  private boolean isConnection(String word1, String word2) {
    int requiredSameTextCount = word1.length() - 1;
    for (int i = 0; i < word1.length(); i++) {
      if (word1.charAt(i) == word2.charAt(i))
        requiredSameTextCount--;
    }
    return requiredSameTextCount <= 0;
  }

  private String[] addWord(String word, String[] wordList) {
    for (String wString : wordList) {
      if (wString.equals(word))
        return wordList;
    }
    String[] newList = new String[wordList.length + 1];
    newList[0] = word;
    for (int i = 0; i < wordList.length; i++) {
      newList[i + 1] = wordList[i];
    }
    return newList;
  }
}
