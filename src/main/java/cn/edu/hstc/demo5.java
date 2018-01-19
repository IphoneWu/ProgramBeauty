package cn.edu.hstc;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速找出机器故障:
 * 1.在某个时间，得到一个数据文件ID的列表，快速找出这个表中仅出现一次的ID  TODO 利用异或运算,假定有2K+1个数，其中有2k个相同，需要找出不相同的那个数，比如：2、3、4、4、3、5、6、6、5。我们利用异或运算符就可以
 * 2.当有两个ID的机器一起出现故障，确定出现故障的机器 TODO 数组相乘，再除以原来的数组，获取
 * 3.当有多个ID的机器一起出现故障，确定出现故障的机器
 */
public class demo5 {
    public static void main(String[] args) {
        Integer arr1[] = {5,3,4,4,10,5,6,6,3,9,9};
        System.out.println(XOR(arr1));

        Integer arr2_1[] = {5,6,7};
        Integer arr2_2[] = {5,6,7,8,9};
        List<Integer> list = XORTwo(arr2_1,arr2_2);
        for (Integer a:list) {
            System.out.println(a);
        }
    }
    //1.异或运算
    public static Integer XOR(Integer[] arr){
        Integer ID = 0;
        for (int i = 0; i < arr.length ; i++) {
            ID ^= arr[i];
        }
        return  ID;
    }
    //2.异或运算,两个Id
    public static List<Integer> XORTwo (Integer[] arr_1, Integer[] arr_2){
        List<Integer> resultList = new ArrayList<Integer>();
        Integer num_1 = arr_1[0];
        Integer sum_1 = arr_1[0];
        Integer SumDouNum_1 = arr_1[0]*arr_1[0];
        for (int i = 1; i < arr_1.length; i++) {
            num_1 = arr_1[i] * num_1;
            sum_1 += arr_1[i];
            SumDouNum_1 += arr_1[i]*arr_1[i];
        }

        Integer num_2 = arr_2[0];
        Integer sum_2 = arr_2[0];
        Integer SumDouNum_2 = arr_2[0]*arr_2[0];
        for (int i = 1; i < arr_2.length; i++) {
            num_2 *= arr_2[i];
            sum_2 += arr_2[i];
            SumDouNum_2 += arr_2[i]*arr_2[i];
        }

        Integer xy = num_2/num_1;
        Integer xSumy = sum_2-sum_1;
        Integer xDouy = SumDouNum_2-SumDouNum_1;

        double x =  Math.sqrt(xDouy/2-(xSumy*xSumy)/4)+xSumy/2;
        double y = xy/x;
        resultList.add((int) x);
        resultList.add((int) y);

        return resultList;
    }
}
