package acwing_base1;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: ChangSir
 * @Date: 2023/1/16 15:52
 * @Description:
 */
public class MonotonicStack {
    static final  int N = 100010;
    static int[] MonStack = new int[N];
    public static void main(String[] args) {
        int tt=0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x= scanner.nextInt();
            while(tt!=0&&MonStack[tt]>=x)tt--;
            if(tt!=0)System.out.print(MonStack[tt]+" ");
            else System.out.print(-1+" ");
            MonStack[++tt] = x;
        }
    }
}
