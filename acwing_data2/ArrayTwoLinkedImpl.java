package acwing_base1;

import java.util.Scanner;

//题目:
// 实现一个双链表，双链表初始为空，支持5种操作：
//1.在最左侧插入一个数：
//2.在最右侧插入一个数；
//3.将第k个插入的数删除；
//4.在第k个插入的数左侧插入一个数；
//5.在第k个插入的数右侧插入一个数
//接下来M行，每行包含一个操作命令，操作命令可能为以下几种：
//1.Lx,表示在链表的最左端插入数x。
//2.R×,表示在链表的最右端插入数x。
//3.Dk,表示将第k个插入的数删除。
//4.Lk×,表示在第k个插入的数左侧插入一个数。
//5.IRkx,表示在第k个插入的数右侧插入一个数。

public class ArrayTwoLinkedImpl {
    static int N =100010;
    static  int idx;
    static int []l = new int [N];
    static int []r = new int[N];
    static int [] e =new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        init();
        for (int i=0;i<n;i++){
            String str=sc.nextLine();
            String []action = str.split(" ");
            if(action[0].equals("L")){
                rKAdd(0,Integer.parseInt(action[1]));
            }else if(action[0].equals("R")){
                rKAdd(l[1],Integer.parseInt(action[1]));
            } else if (action[0].equals("IL")) {
                rKAdd(l[Integer.parseInt(action[1])+1],Integer.parseInt(action[2]));

            } else if (action[0].equals("D")) {
                remove(Integer.parseInt(action[1])+1);
            }else {
                rKAdd(Integer.parseInt(action[1])+1,Integer.parseInt(action[2]));
            }
        }
        for(int i=r[0];i!=1;i=r[i]){
            System.out.print(e[i]+" ");
        }
    }
    static void init(){
        //初始化相当于有一个头节点一个尾节点(0,1)idx从2开始
        l[1]=0;
        r[0]=1;
        idx=2;
    }
    //在k的右侧插入
    static void rKAdd(int k,int val){
        e[idx] = val;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }
    static void remove(int k){
        r[l[k]] =r[k];
        l[r[k]] = l[k];
    }

}