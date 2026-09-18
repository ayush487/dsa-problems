public class LemonadeChange {
  public static void main(String[] args) {
    int[] input1 = {5,5,5,10,20};
    int[] input2 = {5,5,10,10,20};
    System.out.println(lemonadeChange(input1));
    System.out.println(lemonadeChange(input2));
  }
  public static boolean lemonadeChange(int[] bills) {
    int change5 = 0;
    int change10 = 0;
    for (int bill : bills) {
      if (bill==5) change5++;
      else if (bill==10) {
        if (change5>0) {
          change5--;
          change10++;
        } else return false;
      }
      else if(bill==20) {
        if (change10>0 && change5>0) {
          change10--; change5--;
        } else if (change5>=3) change5-=3;
        else return false;
      }
    }
    return true;
  }
}