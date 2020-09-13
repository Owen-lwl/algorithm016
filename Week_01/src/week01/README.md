学习笔记

# 学习原则 #

## 五毒神掌刷题法 ##

第一遍：五分钟思考，若无思路直接看题解，比较不同的解法的优劣，直接背诵、默写好的解法

第二遍：马上自己写出来并提交，不断优化不同的解法

第三遍：第二天再写一遍

第四遍：一周后再写一遍

第五遍：面试前一周恢复性训练

# 解题技巧 #

## 双指针法 ##

第 26 题 删除排序数组中的重复项（快慢指针）

该题的前提是已经排序好了的数组，因此可直接使用双指针。

j 为快指针，遍历除第一个元素以外的所有元素，i 为慢指针，记录非重复项

    class Solution {
    	public int removeDuplicates(int[] nums) {
        	if (nums.length == 0) return 0;
        	int i = 0;
        	for (int j = 1; j < nums.length; j++) {
            	if (nums[i] != nums[j]) {
                	nums[++i] = nums[j];
            	}
        	}
        return ++i;
    	}
	}

第 283 题 移动零 （快慢指针）

思路和第 26 题类似

    class Solution {
    	public void moveZeroes(int[] nums) {
        	int i = 0;
        	for (int j = 0; j < nums.length; j++) {
            	if (nums[j] != 0) {
                	nums[i++] = nums[j];
            	}
        	}
        		while (i < nums.length) {
            nums[i++] = 0;
        	}
    	}
	}

第 141 题 环形链表（快慢指针）  另：也可以用哈希表

慢指针 walker 每次走一步，快指针 runner 每次走两步，如果该链表有环装结构，二者一定会相遇。

有一个简化代码的小技巧：本题只有当快慢指针相遇时这一种情况（即有环）才会返回 true，其余情况都会返回 false，那就把返回 true 的情况放到循环中，把返回 false 的情况放到循环之外。 

    /**
 	* Definition for singly-linked list.
 	* class ListNode {
 	*     int val;
 	*     ListNode next;
 	*     ListNode(int x) {
 	*         val = x;
 	*         next = null;
 	*     }
 	* }
 	*/
	public class Solution {
    	public boolean hasCycle(ListNode head) {
        	ListNode walker = head;
        	ListNode runner = head;
        	while (runner != null && runner.next != null) {
            	walker = walker.next;
            	runner = runner.next.next;
            	if (walker == runner) return true;
        	}
        	return false;
    	}
	}


## 哈希表 ##

第 1 题 两数之和

与建两个哈希表不同，只建一个哈希表的思路是一边检索一边存——当正在检索的元素与已存入哈希表中某一键值对的某一 key 时相加等于 target 时，答案就找到了；如果找不到这样的 key，就把正在检索的存入哈希表中

    class Solution {
    	public int[] twoSum(int[] nums, int target) {
        	Map<Integer, Integer> map = new HashMap<>();
        	for (int i = 0; i < nums.length; i++) {
            	int complement = target - nums[i];
            	if (map.containsKey(complement)) {
                	return new int[] { map.get(complement), i };
            	}
            	map.put(nums[i], i);
        	}
        	throw new IllegalArgumentException("No two sum solution");
    	}
	}

 



    




