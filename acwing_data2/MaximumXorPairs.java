package acwing_base1;

import java.util.Scanner;

/**
 * @Author: ChangSir
 * @Date: 2023/1/19 21:48
 * @Description:
 */
public class MaximumXorPairs {
    static final int M = 3100010;
    static int [] []tire = new int[M][2];
    static int idx=0;
    static int [] a = new int[100010];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            insert(a[i]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max(res,query(a[i]));
        }
        System.out.println(res);

    }

    private static int query(int x) {
        int p=0,res=0;
        for(int i=30;i>=0;i--){
            int j = (x>>i)&1;
            if(tire[p][1-j]!=0){
                res+=1<<i;
                p =tire[p][1-j];
            }
            else p=tire[p][j];
        }


        return res;
    }

    private static void insert(int x) {
        int p=0;
        for (int i=30;i>=0;i--){
            int s = (x>>i)&1;
            if(tire[p][s]==0){
                tire[p][s]= ++idx;
            }
            p = tire[p][s];
        }
    }


}
