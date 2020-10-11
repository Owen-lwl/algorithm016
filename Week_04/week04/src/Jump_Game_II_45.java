//45. 跳跃游戏 II

//方法一: 从后往前
public class Jump_Game_II_45 {
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}

//方法二: 从前往后 ①
class Jump_Game_II_45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}

//方法二: 从前往后 ②
class Jump_Game_II_45 {
    public int jump(int[] nums) {
        int curEnd = 0, curFarthest = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            //增加了一个 if 判断语句, 可以提前结束
            if (curFarthest >= nums.length - 1) {
                steps++;
                break;
            }
            if (i == curEnd) {
                steps++;
                curEnd = curFarthest;
            }
        }
        return steps;
    }
}