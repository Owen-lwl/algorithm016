package week02;
//77.组合
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//递归法一:
public class Combinations_77 {
    public class Solution {

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n < k) {
                return res;
            }
            Deque<Integer> path = new ArrayDeque<>();
            dfs(n, k, 1, path, res);
            return res;
        }

        private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> res) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i <= n - (k - path.size()) + 1; i++) {
                path.addLast(i);
                dfs(n, k, i + 1, path, res);
                path.removeLast();
            }
        }
    }
}

//递归法二:
public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k < 0 || n < k) return ans;
        dfs(ans, new ArrayList<Integer>(), k, 1, n - k + 1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, int k, int start, int end) {
        if (k == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= end; i++) {
            list.add(i);
            dfs(ans, list, k - 1, i + 1, end + 1);
            list.remove(list.size() - 1);
        }
    }
}
