package cn.edu.hstc;

/**
 * CPU利用率分为用户态，系统态和空闲态，分别表示CPU处于用户态执行的时间，系统内核执行的时间，和空闲系统进程执行的时间，三者之和就是CPU的总时间，
 * 当没有用户进程、系统进程等需要执行的时候，CPU就执行系统缺省的空闲进程。从平常的思维方式理解的话，CPU的利用率就是非空闲进程占用时间的比例，
 * 即CPU执行非空闲进程的时间/ CPU总的执行时间。（理想状态）
 * 误差存在:1.cpu 会有用户进程或者系统进程在执行，打开ide测试本程序ide也是一个用户进程，所以也会占有一定量的占有率
 * 2.sleep 时钟计算有误差，因为时钟有一个缓存区
 */
public class demo1 {
    public static void main(String[] args) {
        long time_start;
        int fulltime = 100;
        int runtime = 50;
        while (true) {
            time_start = System.currentTimeMillis();
            //cpu 忙碌时间50%
            while ((System.currentTimeMillis() - time_start) <= runtime) {
            }
            try {
                Thread.sleep(fulltime - runtime);//空闲时间50%
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
