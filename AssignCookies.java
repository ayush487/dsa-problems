import java.util.Arrays;

public class AssignCookies {
  public static void main(String[] args) {
  int[][] greeds = {
    {1,5,3,3,4},
    {2,3,5},
    {2,2},
    {1,2,3},
    {},
    {1,2},
    {2,2,2},
    {1000000,2},
    {0,0}
  };

  int[][] cookies = {
    {4,2,1,2,1,3},
    {1,1},
    {3,3,3},
    {1,2,3},
    {1,2},
    {},
    {2,2},
    {1000000},
    {0}
  };

  int[] expected = {3, 0, 2, 3, 0, 0, 2, 1, 1};

  for (int i = 0; i < greeds.length; i++) {
    int sat = getMaximumSatisfiedChildren(greeds[i], cookies[i]);
    System.out.printf("Case %d: greed=%s cookie=%s -> got=%d expected=%d%n",
      i+1, Arrays.toString(greeds[i]), Arrays.toString(cookies[i]), sat, expected[i]);
  }
}

  public static int getMaximumSatisfiedChildren(int[] greed, int[] cookie) {
    Arrays.sort(greed);
    Arrays.sort(cookie);
    int satisfied = 0;
    int greedIdx = 0;
    for (int c : cookie) {
      if (greedIdx>=greed.length) break; 
      if (greed[greedIdx]<=c) {
        satisfied++;
        greedIdx++;
      } 
    }

    return satisfied;
  }
}
