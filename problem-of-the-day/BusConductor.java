import java.util.Arrays;

public class BusConductor {
  public static void main(String[] args) {
    BusConductor bc = new BusConductor();
    int[] chairs = { 2, 2, 6, 6 };
    int[] passengers = { 1, 3, 2, 6 };
    int moves = bc.findMoves(chairs, passengers);
    System.out.println(moves);
  }

  public int findMoves(int[] chairs, int[] passengers) {
    Arrays.sort(chairs);
    Arrays.sort(passengers);
    int moves = 0;
    for (int i = 0; i < chairs.length; i++) {
      int diff = chairs[i] - passengers[i];
      moves += Math.abs(diff);
    }
    return moves;
  }
}
