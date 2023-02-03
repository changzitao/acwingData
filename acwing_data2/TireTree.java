package acwing_base1;

import java.util.Scanner;

/**
 * @Author: ChangSir
 * @Date: 2023/1/19 21:33
 * @Description:
 */
public class TireTree {
    static final  int N = 100010;
    static int[] [] son = new int[N][26];
    static int [] cnt = new int[N];
    static int idx=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String[] str=  sc.nextLine().split(" ");
            if(str[0].equals("I"))insert(str[1]);
            else query(str[1]);
        }

        for(int i=0;i<10;i++){
            for(int j=0;j<26;j++){
                System.out.print(son[i][j]);
            }
            System.out.println();
        }

    }

    private static void query(String s) {
        int p=0;
        for(int i=0;i<s.length();i++){
            int u = s.charAt(i)-'a';
            if(son[p][u]==0){
                System.out.println(0);
                return;
            }
            p = son[p][u];
        }
        if(cnt[p]!=0) System.out.println(cnt[p]);
        else System.out.println(0);
    }

    private static void insert(String s) {
        int p = 0 ;
        for(int i=0;i<s.length();i++){
            int u  = s.charAt(i)-'a';
            if(son[p][u]==0) son[p][u]=++idx;
            p  =son[p][u];
        }
        cnt[p]++;
    }
}
