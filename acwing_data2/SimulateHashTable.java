package acwing_base1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ChangSir
 * @Date: 2023/1/28 15:19
 * @Description:
 */
public class SimulateHashTable {
    static int N   = 100003;
    static  int [] h = new int[100003];
    static int [] e = new int[100003];
    static int []ne = new int[100003];
    static  int idx=0;
    static void insert(int x){
        int k = (x%N+N)%N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }
    static boolean query(int x){
        int k = (x%N+N)%N;
        for (int i = h[k]; i !=-1 ; i=ne[i]) {
            if(e[i]==x){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Arrays.fill(h,-1);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int x=  sc.nextInt();

            if(s.equals("I")){
                insert(x);
            }else {
                if(query(x)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
