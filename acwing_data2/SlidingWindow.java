package acwing_base1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @Author: ChangSir
 * @Date: 2023/1/16 16:18
 * @Description:
 */
public class SlidingWindow {

    public static void main(String[] args) throws IOException {
        int n,k;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String []str =bufferedReader.readLine().split(" ");
        n=Integer.parseInt(str[0]);k=Integer.parseInt(str[1]);
        str =bufferedReader.readLine().split(" ");
        int [] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        int hh=0,tt=-1;
        int []q = new int[n];
        for(int i=0;i<n;i++){
            if(hh<=tt&& q[hh]<i-k+1)hh++;
            while(hh<=tt&&num[q[tt]]>num[i])tt--;
            q[++tt] = i;
            if(i>=k-1) System.out.print(num[q[hh]]+" ");
        }
        System.out.println();
        hh=0;tt=-1;
        for(int i=0;i<n;i++){
            if(hh<=tt&& q[hh]<i-k+1)hh++;
            while(hh<=tt&&num[q[tt]]<num[i])tt--;
            q[++tt] = i;
            if(i>=k-1) System.out.print(num[q[hh]]+" ");
        }
    }
}
