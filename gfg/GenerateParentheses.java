import java.util.ArrayList;
import java.util.Stack;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.isValid("((()))"));
        System.out.println(gp.isValid("(()())"));
        System.out.println(gp.isValid("())"));
        System.out.println(gp.isValid(")("));
    }

    public ArrayList<String> generateParentheses(int n) {
        // code here
        Stack<Character> openStack = new Stack<>();
        Stack<Character> closedStack = new Stack<>();
        for (int i=0;i<n;i+=2) {
            openStack.push('(');
            closedStack.push(')');
        }
        
        return null;
    }

    public boolean isBalanced(String parenthesis) {
        int points = 0;
        for (int i=0;i<parenthesis.length();i++) {
            char curr = parenthesis.charAt(i);
            if (curr=='(') {
                points++;
            } else {
                points--;
                if (points<0) return false;
            }
        }
        return true;
    }

    

    private boolean isValid(String parenthesises) {
        Stack<Character> stk = new Stack<>();
        for (int i=0;i<parenthesises.length();i++) {
            char curr = parenthesises.charAt(i);
            if (curr=='(') {
                stk.push('(');
            } else {
                if (stk.isEmpty()) return false;
                if (stk.pop()!='(') return false;
            }
        }
        if (stk.isEmpty()) return true;
        else return false;
    }
}
