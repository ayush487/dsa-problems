// Boats to Save People

import java.util.Arrays;

public class Problem034 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int boats = 0;
        while (l<=r) {
            if (people[l] + people[r]<=limit) {
                boats++;
                l++;
                r--;
            } else {
                boats++;
                r--;
            }
        }
        return boats;
    }
}
