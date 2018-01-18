package cn.edu.hstc;


/**
 * 烙饼排序
 */
public class demo3 {
    private static int[] bing = {4,8,1,3,15,22,10,99,21,2,77,13};//饼数组
    private static int revertCount;//交换次数
    public static void main(String[] args) {
        System.out.print("翻转前:");
        for (int i = 0; i < bing.length ; i++) {
            System.out.print(bing[i]+" ");
        }

        System.out.println();
        System.out.print("翻转后:");
        sort(bing.length);
        for (int i = 0; i < bing.length; i++) {
            System.out.print(bing[i]+" ");
        }
        System.out.println();
        System.out.println("翻转次数:"+revertCount);
    }

    /**
     * 传入最值尾索引，排除已排好序的索引
     * 比较获取出最大值的索引
     * @param endIndex
     * @return
     */
    private static int maxIndex(int endIndex){
        int temp = bing[0];
        int maxIndex = 0;
        for (int i = 1; i < endIndex ; i++) {
            if (bing[i]>temp){
                temp = bing[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * 交换数组位置
     * @param beginIndex
     * @param endIndex
     */
    private static void revert(int beginIndex,int endIndex){
        for (int i = beginIndex,j = endIndex;i<j;i++,j--){
            int temp = bing[i];
            bing[i] = bing[j];
            bing[j] = temp;
        }
        revertCount++;
    }

    private static void sort(int length){
        if (isSorted()){
            return;
        }
        int maxIndex = maxIndex(length);//获取数组最大值索引
        revert(0,maxIndex);//第一次翻转，大的先翻到上面
        revert(0,length-1);//第二次翻转，大的翻到后面

        if (length <= 0)//若已经全部翻转完，结束递归
            return;
        sort(length - 1);//递归调用
    }

    /**
     * 判断是否排好序
     * @return
     */
    private static boolean isSorted() {
        for (int i = 1; i < bing.length; i++) {
            if (bing[i - 1] > bing[i])
                return false;
        }
        return true;
    }

}
