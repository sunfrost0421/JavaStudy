package ch21_1;

import java.util.ArrayList;
import java.util.Arrays;

class A{}
public class ArrayTest {
    public A[] makeArray(int n){
        A[] aa = new A[n];
        return aa;
    }

    public static void main(String[] args) {
        //int [] a = new int[];//创建数组实例的时候一定要加初始数组长度，否则报错
        int[] a1 = new int[5];
        int[] a2 = {1,2,3,4,5};
        int[] a3 = new int[]{1,2,3,4,5};
        String[] s = new String[5];
        //int[] a3;//未初始化的本地变量，指向一个数组实例前不能使用
        System.out.println(Arrays.toString(a1));
        System.out.println(a2.length);
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(s));
        //System.out.println(a3);//报错，没有初始化，不能使用

        ArrayList<Integer> b1 = new ArrayList<>();//初始容量为0
        ArrayList<Integer> b2 = new ArrayList<>(5);//初始容量为5
        ArrayList<Integer> b3 = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        int[][] m = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(m));
        A[][] n = new A[3][];//n中存放了三个数组引用
        for(A[] x:n){
            x = new A[2];
        }
        Arrays.setAll(a1,p->p);


    }
}
