public class StringRotations {
  public static void main(String[] args) {
    StringRotations sr = new StringRotations();
    boolean isRelated = sr.areRotations("abcd", "acbd");
    System.out.println(isRelated);
  }

  public boolean areRotations(String s1, String s2) {
    if (s1.length()!=s2.length()) return false;
    if(s1.equals(s2)) return true;
    s1 = s1+s1;
    return s1.lastIndexOf(s2)>=0;
  }
}
