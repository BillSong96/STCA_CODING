package Others.MS_TEST;

import java.util.*;
import java.lang.Math;

public class Question1 {

    private int sum = Integer.MAX_VALUE;

    public int minSum(int[] nums, int K) {
        int maxCnt = 0, N = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0) + 1;
            maxCnt = Math.max(cnt, maxCnt);
            map.put(num, cnt);
        }
        if (maxCnt * K > N)
            return -1;
        int[] max = new int[K], min = new int[K], count = new int[K];
        Set<Integer>[] sets = new HashSet[K];
        for (int k = 0; k < K; k++) {
            sets[k] = new HashSet<>();
        }
        dfs(nums, 0, N, K, max, min, count, sets, 0);
        return sum;
    }

    private void dfs(int[] nums, int i, int N, int K, int[] max, int[] min, int[] count, Set<Integer>[] sets,
            int currentSum) {
        if (i == N) {
            sum = Math.min(sum, currentSum);
            return;
        }
        if (currentSum >= sum)
            return;
        for (int k = 0; k < K; k++) {
            if (count[k] * K == N || sets[k].contains(nums[i]))
                continue;
            sets[k].add(nums[i]);
            int tempMax = max[k], tempMin = min[k];
            max[k] = count[k] == 0 ? nums[i] : Math.max(max[k], nums[i]);
            min[k] = count[k] == 0 ? nums[i] : Math.min(min[k], nums[i]);
            count[k]++;
            dfs(nums, i + 1, N, K, max, min, count, sets, currentSum + max[k] - min[k] - tempMax + tempMin);
            count[k]--;
            max[k] = tempMax;
            min[k] = tempMin;
            sets[k].remove(nums[i]);
        }
    }
}