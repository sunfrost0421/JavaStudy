package ch13_2;

import java.util.Arrays;

public class FibonacciTest
{
    static Fibonacci f;
    public static void main(String[] args) {
        f = i -> {
            if(i==0)
                return 0;
            else if(i==1)
                return 1;
            else if(i<0)
                return -1;
            else{
                return f.getFibonacci(i-1)+ f.getFibonacci(i-2);
            }
        };
        for(int j=0;j<11;j++)
        {
            System.out.println(f.getFibonacci(j));
        }
    }
}
