package week02;
//22.括号生成
import java.util.ArrayList;
import java.util.List;

//回溯法一:
/*
* java.lang.StringBuilder.deleteCharAt() 方法移除在此序列中的指定位置的char值。此序列是由一个字符缩短。
* StringBuilder类的toString（）方法是一种内置方法，用于返回表示StringBuilder对象包含的数据的字符串。
* 创建并初始化一个新的String对象，以从此StringBuilder对象获取字符序列，然后toString（）返回String。
* Object包含的对该序列的后续更改不会影响String的内容。
* 所以作者个人认为使用 StringBuilder 比直接用 String 会使代码的健壮性更好
* */
public class Generate_Parentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

//回溯法二:
public class Generate_Parentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, 0, 0, n, "");
        return ans;
    }

    public void generate(List<String> ans, int left, int right, int max, String s) {
        if (left == max && right == max) {
            ans.add(s);
            return;
        }
        if (left < max) generate(ans, left + 1, right, max, s + "(");
        if (right < left) generate(ans, left, right + 1, max, s + ")");
    }
}