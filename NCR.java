public class NCR {
  public static void main(String[] args) {
    NCR ncr = new NCR();
    int a = ncr.nCr(25,10);
    System.out.println(a);
  }

  public int nCr(int n, int r) {
    if (r>n) return 0;
    if (n==r || r==0) return 1;
    else if (n == r-1 || r==1) return n;
    else {
      r = Math.min(n-r, r);
      long result = 1;
      for (int i=0;i<r;i++) {
        result *= n-i;
        result /= (i+1);
      }
      return (int) result;
    }
  }
}
