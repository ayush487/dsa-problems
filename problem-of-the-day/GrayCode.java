import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GrayCode {

    public static void main(String[] args) {
        List<String> solution = new GrayCode().graycode(3);
        System.out.println(solution);
    }

    public void helper(int n, String current, ArrayList<String> solList, Set<String> solSet, int maxSize) {
        if (solSet.size() >= maxSize) {
            return;
        }
        boolean isSolutionFound = false;
        for (int i = 0; i < n; i++) {
            String nextStr = transform(current, n-1-i);
            if (solSet.contains(nextStr))
                continue;
            else {
                isSolutionFound = true;
                solSet.add(nextStr);
                solList.add(nextStr);
                helper(n, nextStr, solList, solSet, maxSize);
            }
        }
        if (!isSolutionFound) {
            solSet.remove(current);
            solList.removeLast();
        }
    }

    private String transform(String str, int n) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(n, str.charAt(n) == '0' ? '1' : '0');
        return sb.toString();
    }

    public ArrayList<String> graycode(int n) {
        // code here
        Set<String> solSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        solSet.add(sb.toString());
        ArrayList<String> solList = new ArrayList<>();
        solList.add(sb.toString());
        helper(n, sb.toString(), solList, solSet, Math.powExact(2, n));
        return solList;
    }
}