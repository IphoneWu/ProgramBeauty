package cn.edu.hstc;

public class demo2 {
    public static void main(String[] args) {
        for (int i = 81; i> 0; i--) {
            if (i/9%3 == i%9%3){
                continue;
            }
            System.out.println("A="+i/9+1+",B="+i%9+1);
        }
    }
}
