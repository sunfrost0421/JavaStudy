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
        //int [] a = new int[];//��������ʵ����ʱ��һ��Ҫ�ӳ�ʼ���鳤�ȣ����򱨴�
        int[] a1 = new int[5];
        int[] a2 = {1,2,3,4,5};
        int[] a3 = new int[]{1,2,3,4,5};
        String[] s = new String[5];
        //int[] a3;//δ��ʼ���ı��ر�����ָ��һ������ʵ��ǰ����ʹ��
        System.out.println(Arrays.toString(a1));
        System.out.println(a2.length);
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(s));
        //System.out.println(a3);//����û�г�ʼ��������ʹ��

        ArrayList<Integer> b1 = new ArrayList<>();//��ʼ����Ϊ0
        ArrayList<Integer> b2 = new ArrayList<>(5);//��ʼ����Ϊ5
        ArrayList<Integer> b3 = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        int[][] m = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(m));
        A[][] n = new A[3][];//n�д����������������
        for(A[] x:n){
            x = new A[2];
        }
        Arrays.setAll(a1,p->p);


    }
}
