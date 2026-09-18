// Contains Duplicate

import java.util.HashSet;
import java.util.Set;

public class Problem002 {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int e : nums) {
            if (set.contains(e)) return true;
            else set.add(e);
        }
        return false;
    }
}