package acwing_base1;

import java.util.Scanner;

/**
 * @Author: ChangSir
 * @Date: 2023/1/28 19:16
 * @Description:
 */
public class SimulateString {
    public static void main(String[] args) {
        char[] a;
        Scanner sc=  new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        long [] p = new long[n+10];
        long[]h =new long[n+10];
        p[0]=1;
        int P=131;
        a= sc.next().toCharArray();
        for(int i=1;i<=n;i++){
            p[i] = p[i-1]*P;
            h[i] = h[i-1]*P+a[i-1];
        }

        while (m-->0){
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int l2 = sc.nextInt();
            int r2 = sc.nextInt();
            if(h[r1]-h[l1-1]*p[r1-l1+1]==h[r2]-h[l2-1]*p[r2-l2+1]) System.out.println("Yes");
            else System.out.println("No");

        }
    }
}
