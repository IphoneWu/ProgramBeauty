package cn.edu.hstc;

/**
 * 中国象棋将帅问题
 */
public class demo2 {
    public static void main(String[] args) {
        int i = 81;
        while (i-- != 0) {
            if (i / 9 % 3 == i % 9 % 3)
                continue;
            System.out.println("A=" + (i / 9 + 1) + " B=" + (i % 9 + 1));

        }
    }
}
