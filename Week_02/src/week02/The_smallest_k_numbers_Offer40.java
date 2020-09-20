package week02;

import java.util.Arrays;
import java.util.PriorityQueue;

//方法一: 快速排序
public class The_smallest_k_numbers_Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}

//方法二: 优先队列 + 大根堆
//时间复杂度: O(NlogK)
public class The_smallest_k_numbers_Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (heap.size() < k) {
                heap.offer(num);
            }
            else if (num < heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        int[] ans = new int[k];
        int i = 0;
        for (int num : heap) {
            ans[i++] = num;
        }
        return ans;
    }
}
