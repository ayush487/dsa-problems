//Combination Sum

import java.util.ArrayList;
import java.util.List;

class Problem120 {
    private class Sum {
        int sum;
        List<Integer> list;

        public Sum(int sum, List<Integer> list) {
            this.sum = sum;
            this.list = list;
        }

        public Sum copy(int newNum) {
            List<Integer> copyList = new ArrayList<>(this.list);
            copyList.add(newNum);
            return new Sum(this.sum + newNum, copyList);
        }
    }

    private List<List<Integer>> mainList;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        mainList = new ArrayList<>();
        Sum currentSum = new Sum(0, new ArrayList<Integer>());
        dfs(nums, 0, currentSum, target);
        return mainList;
    }

    private void dfs(int[] nums, int startIndex, Sum currentSum, int target) {
        if (currentSum.sum > target) return;
        if (currentSum.sum == target) {
            mainList.add(currentSum.list);
            return;
        }
        for (int i = startIndex; i < nums.length; i++)
            dfs(nums, i, currentSum.copy(nums[i]), target);
    }
}