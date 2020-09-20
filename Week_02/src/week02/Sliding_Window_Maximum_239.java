package week02;

import java.util.LinkedList;

public class Sliding_Window_Maximum_239 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < 2) return nums;
            LinkedList<Integer> queue = new LinkedList<>();
            int[] ans = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.addLast(i);
                if (queue.peek() <= i - k) {
                    queue.poll();
                }
                if (i + 1 >= k) {
                    ans[i + 1 - k] = nums[queue.peek()];
                }
            }
            return ans;
        }
    }
}
