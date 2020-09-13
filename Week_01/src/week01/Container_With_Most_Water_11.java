package week01;

public class Container_With_Most_Water_11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0;
        //或者：for (int i = 0, j = height.length - 1; i < j; )
        while (i < j) {
            int minheight = height[i] < height[j] ?
                    height[i++] : height[j--];
            ans = Math.max(ans, (j - i + 1) * minheight);
        }
        return ans;
    }
}
