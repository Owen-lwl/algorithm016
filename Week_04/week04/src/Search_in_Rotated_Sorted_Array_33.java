//33. 搜索旋转排序数组

//方法一: 二分搜索
public class Search_in_Rotated_Sorted_Array_33 {
    class Solution {
        public int search(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                // 当[0,mid]有序时,向后规约条件
                if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                    lo = mid + 1;
                    // 当[0,mid]发生旋转时，向后规约条件
                } else if (target > nums[mid] && target < nums[0]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo == hi && nums[lo] == target ? lo : -1;
        }
    }
}

//方法二:
class Search_in_Rotated_Sorted_Array_33 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 先根据 nums[0] 与 target 的关系判断目标值是在左半段还是右半段
            if (target >= nums[0]) {
                // 目标值在左半段时，若 mid 在右半段，则将 mid 索引的值改成 inf
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                // 目标值在右半段时，若 mid 在左半段，则将 mid 索引的值改成 -inf
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
