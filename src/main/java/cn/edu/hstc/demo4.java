package cn.edu.hstc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 购书问题
 */
public class demo4 {
    //剩余找最小花费。
    public static float minCost(Integer[] num) {
        float c5 = Float.MAX_VALUE,
                c4 = Float.MAX_VALUE,
                c3 = Float.MAX_VALUE,
                c2 = Float.MAX_VALUE,
                c1 = Float.MAX_VALUE;
        /**
         * 状态转移方程,调用递归
         */
        if (num[0] == 0 && num[4] == 0) return 0;
        if (num[4] >= 1) {
            Integer[] tem = newNum(num, 4);
            c5 = (float) (40 * 0.75 + minCost(tem));
        }
        if (num[3] >= 1) {
            Integer[] tem = newNum(num, 3);
            c4 = (float) (32 * 0.8 + minCost(tem));
        }
        if (num[2] >= 1) {
            Integer[] tem = newNum(num, 2);
            c3 = (float) (24 * 0.9 + minCost(tem));
        }
        if (num[1] >= 1) {
            Integer[] tem = newNum(num, 1);
            c2 = (float) (16 * 0.95 + minCost(tem));
        }
        Integer[] tem = newNum(num, 0);
        c1 = (float) (8 + minCost(tem));
        return findMin(c1, c2, c3, c4, c5);
    }

    public static Integer[] newNum(Integer[] num, int n) {
        Integer[] temp = new Integer[num.length];//深复制
        for (int i = 0; i < temp.length; i++) {
            temp[i] = num[i];
        }
        for (int i = 0; i <= n; i++) {
            temp[i] = temp[i] - 1;
        }
        Arrays.sort(temp, new Comparator<Integer>() {//重写排序
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;//保证排序是升序
            }
        });
        return temp;
    }

    /**
     * 全部比较一次，获取最小的价格
     * @param c1
     * @param c2
     * @param c3
     * @param c4
     * @param c5
     * @return
     */
    public static float findMin(float c1, float c2, float c3, float c4, float c5) {
        float min = c1;
        if (c2 < min) min = c2;
        if (c3 < min) min = c3;
        if (c4 < min) min = c4;
        if (c5 < min) min = c5;
        return min;
    }

    public static void main(String[] args) {
        Integer[] res = {9, 6, 5, 4, 3};
        System.out.println(minCost(res));
    }
}
