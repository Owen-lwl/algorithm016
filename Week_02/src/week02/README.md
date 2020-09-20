# 哈希表、二叉树、N叉树 #

## 哈希表的使用 ##

**哈希表其实是一种解题方法。实现哈希这个方法，可以用数组，也可以用链表，也可以直接用库函数。**

1. 通过数组实现哈希表

LeetCode 第 242 题：有效的字母异位词

    public class Valid_Anagram_242 {
    	public boolean isAnagram(String s, String t) {
        	if (s.length() != t.length()) return false;
        	int[] counter = new int[26];
        	for (int i = 0; i < s.length(); i++) {
            	counter[s.charAt(i) - 'a']++;
            	counter[t.charAt(i) - 'a']--;
        	}
        	for (int count : counter) {
            	if (count != 0) return false;
        	}
        	return true;
    	}
	}


2.通过库函数实现哈希表

LeetCode 第 1 题: 两数之和

    public class Two_Sum_1 {
    	public int[] twoSum(int[] nums, int target) {
        	Map<Integer, Integer> map = new HashMap<>();
        	for (int i = 0; i < nums.length; i++) {
            	int complement = target - nums[i];
            	if (map.containsKey(complement)) {
                	return new int[] { map.get(complement), i};
            	}
            	else {
                	map.put(nums[i], i);
            	}
        	}
        	throw new IllegalArgumentException("No two sum solution");
    	}
	}

3.结合数组和库函数

LeetCode 第 49 题：字母异位词分组

    public class Group_Anagrams_49 {
    	public List<List<String>> groupAnagrams(String[] strs) {
        	if (strs == null || strs.length == 0) return new ArrayList();
        	Map<String, List> map = new HashMap<>();
        	for (String s : strs) {
            	char[] ca = new char[26];
            	for (char c : s.toCharArray()) {
                	ca[c - 'a']++;
            	}
            	String key = String.valueOf(ca);
            	if (!map.containsKey(key)) {
                	map.put(key, new ArrayList());
            	}
            	map.get(key).add(s);
        	}
        	return new ArrayList(map.values());
    	}
	}

## 二叉树和 N 叉树 ##

**要熟练掌握二叉树的前、中、后序遍历的递归法和非递归法，以及 N 叉树的递归法（非递归法也可以看看）**

1.LeetCode 第 144 题：二叉树的前序遍历

（1）递归法一：

    public class Binary_Tree_Preorder_Traversal_144 {
    	public List<Integer> preorderTraversal(TreeNode root) {
        	List<Integer> ans = new LinkedList<>();
        	if (root == null) return ans;
        	ans.add(root.val);
        	ans.addAll(preorderTraversal(root.left));
        	ans.addAll(preorderTraversal(root.right));
        	return ans;
    	}
	}

（2）递归法二：（利用递归辅助函数）

    public class Binary_Tree_Preorder_Traversal_144 {
    	public List<Integer> preorderTraversal(TreeNode root) {
        	List<Integer> ans = new LinkedList<>();
        	preorder(root, ans);
        	return ans;
    	}

    	public void preorder(TreeNode root, List<Integer> ans) {
        	if (root == null) return;
        	ans.add(root.val);
        	preorder(root.left, ans);
        	preorder(root.right, ans);
    	}
	}

（3）迭代法一：（使用栈）

    public class Binary_Tree_Preorder_Traversal_144 {
    	public List<Integer> preorderTraversal(TreeNode root) {
        	List<Integer> ans = new LinkedList<>();
        	if (root == null) return ans;
        	Deque<TreeNode> stack = new LinkedList<>();
        	stack.push(root);
        	while (!stack.isEmpty()) {
            	TreeNode node = stack.pop();
            	ans.add(node.val);
            	if (node.right != null) {
                	stack.push(node.right);
            	}
            	if (node.left !=null) {
                	stack.push(node.left);
            	}
        	}
        	return ans;
    	}
	}

（4）迭代法二：（使用栈）

此解法只把 node 的右儿子入栈

    public class Binary_Tree_Preorder_Traversal_144 {
    	public List<Integer> preorderTraversal(TreeNode root) {
        	List<Integer> ans = new LinkedList<>();
        	if (root == null) return ans;
        	Deque<TreeNode> stack = new LinkedList<>();
        	TreeNode node = root;
        	while (node != null || !stack.isEmpty()) {
            	if (node != null) {
                	ans.add(node.val);
                	stack.push(node.right);
                	node = node.left;
            	}
            	else {
                	node = stack.pop();
            	}
        	}
        	return ans;
    	}
	}

2.LeetCode 第 94 题：二叉树的中序遍历

（1）递归法一：

    public class Binary_Tree_Inorder_Traversal_94 {
    	public List<Integer> inorderTraversal(TreeNode root) {
        	List<Integer> ans = new LinkedList<>();
        	if (root == null) return ans;
        	ans.addAll(inorderTraversal(root.left));
        	ans.add(root.val);
        	ans.addAll(inorderTraversal(root.right));
        	return ans;
    	}
	}

（2）递归法二：（利用递归辅助函数）

    public class Binary_Tree_Inorder_Traversal_94 {
    	public List<Integer> inorderTraversal(TreeNode root) {
        	List<Integer> ans = new LinkedList<>();
        	inorder(root, ans);
        	return ans;
    	}

    	public void inorder(TreeNode root, List<Integer> ans) {
        	if (root == null) return;
        	inorder(root.left, ans);
        	ans.add(root.val);
        	inorder(root.right, ans);
    	}
	}

(3) 迭代法（使用栈）

递归函数我们也可以用迭代的方式实现，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来，其他都相同。

    public class Binary_Tree_Inorder_Traversal_94 {
    	public List<Integer> inorderTraversal(TreeNode root) {
        	List<Integer> res = new ArrayList<Integer>();
        	Deque<TreeNode> stk = new LinkedList<TreeNode>();
        	while (root != null || !stk.isEmpty()) {
            	while (root != null) {
                	stk.push(root);
                	root = root.left;
            	}
            	root = stk.pop();
            	res.add(root.val);
            	root = root.right;
        	}
        	return res;
    	}
	}

3.LeetCode 第 145 题：二叉树的后序遍历

（1）递归法一：

    public class Binary_Tree_Postorder_Traversal_145 {
    	public List<Integer> postorderTraversal(TreeNode root) {
        	List<Integer> ans = new LinkedList<>();
        	if (root == null) return ans;
        	ans.addAll(postorderTraversal(root.left));
        	ans.addAll(postorderTraversal(root.right));
        	ans.add(root.val);
        	return ans;
    	}
	}

（2）递归法二：（使用递归辅助函数）

    public class Binary_Tree_Postorder_Traversal_145 {
    	public List<Integer> postorderTraversal(TreeNode root) {
        	List<Integer> ans = new LinkedList<>();
        	postorder(root, ans);
        	return ans;
    	}

    	public void postorder(TreeNode root, List<Integer> ans) {
        	if (root == null) return;
        	postorder(root.left, ans);
        	postorder(root.right, ans);
        	ans.add(root.val);
    	}
	}

（3）迭代法：（使用栈）

    public class Binary_Tree_Postorder_Traversal_145 {
    	public List<Integer> postorderTraversal(TreeNode root) {
        	LinkedList<TreeNode> stack = new LinkedList<>();
        	//是LinkedList<Integer>而不是List<Integer>
        	LinkedList<Integer> output = new LinkedList<>();
        	if (root == null) {
            	return output;
        	}

        	stack.add(root);
        	while (!stack.isEmpty()) {
            	TreeNode node = stack.pollLast();
            	output.addFirst(node.val);
            	if (node.left != null) {
                	stack.add(node.left);
            	}
            	if (node.right != null) {
                	stack.add(node.right);
            	}
        	}
        	return output;
    	}
	}

4.LeetCode 第 589 题: N 叉树的前序遍历

迭代法

    // Definition for a Node.
	class Node {
    	public int val;
    	public List<Node> children;

    	public Node() {}

    	public Node(int _val) {
        	val = _val;
    	}

    	public Node(int _val, List<Node> _children) {
        	val = _val;
        	children = _children;
    	}
	};

    public class N_ary_Tree_Preorder_Traversal_589 {
    	public List<Integer> ans = new ArrayList<>();
    	public List<Integer> preorder(Node root) {
        	if (root == null) return ans;
        	ans.add(root.val);
        	for (Node node : root.children) {
            	preorder(node);
        	}
        	return ans;
    	}
	}

5.LeetCode 第 590 题: N 叉树的后序遍历

迭代法

    // Definition for a Node.
	class Node {
    	public int val;
    	public List<Node> children;

    	public Node() {}

    	public Node(int _val) {
        	val = _val;
    	}

    	public Node(int _val, List<Node> _children) {
        	val = _val;
        	children = _children;
    	}
	};

	public class N_ary_Tree_Postorder_Traversal_590 {
    	public List<Integer> ans = new ArrayList<>();
    	public List<Integer> postorder(Node root) {
        	if (root == null) return ans;
        	for (Node node : root.children) {
            	postorder(node);
        	}
        	ans.add(root.val);
        	return ans;
    	}
	}
