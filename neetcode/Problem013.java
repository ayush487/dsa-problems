// Top K Frequent Elements

public class Problem013 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] frequencyTable = new int[20001];
        for (int num : nums)
            frequencyTable[num + 10000]++;
        int[] result = new int[k];

        for (int i=0;i<k;i++) {
            int highestCount = 0;
            int highestIndex = -1;
            for (int j = 0; j < 20001; j++) {
                if (frequencyTable[j] > highestCount) {
                    highestCount = frequencyTable[j];
                    highestIndex = j;
                }
            }
            result[i] = highestIndex - 10000;
            frequencyTable[highestIndex] = 0;
        }
        return result;
    }
}
