package acwing_base1;

import java.util.Scanner;

/**
 * @Author: ChangSir
 * @Date: 2023/1/16 13:26
 * @Description:
 */
public class AnalogStack {
    static  final  int N = 100010;
    static int []stack = new int[N];
    static int head =-1,end=-1;
    public static void main(String[] args) {
        int n ;
        Scanner scanner  =new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<n;i++){
            String  str=  scanner.nextLine();

            String []action = str.split(" ");
            if(action[0].equals("push")){
                int x = Integer.parseInt(action[1]);
                stack[++end] = x;
            }
            else if ( action[0].equals("pop")){
                end--;
            }
            else if(action[0].equals("empty")){
                if(end==-1){
                    System.out.println("YES");
                }else System.out.println("NO");
            }
            else {
                System.out.println(stack[end]);
            }
        }
    }
}
