package acwing_base1;
import java.util.Scanner;

/*
   *题目:
   * 实现一个单链表，链表初始为空，支持三种操作：
    * 向链表头插入一个数；删除第 k个插入的数后面的数；在第 k个插入的数后插入一个数。现在要对该链表进行 M次操作，进行完所有操作后，从头到尾输出整个链表。
    * 接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：
H x，表示向链表头插入一个数 x
D k，表示删除第 k 个插入的数后面的数（当 k 为 0 时，表示删除头结点）。
I k x，表示在第 k 个插入的数后面插入一个数 x（此操作中 k 均大于 0）。

 */
public class ArrayLinkedImpl {
    final static int N = 100010;
    static int head ,idx;

    static int [] e = new int[N];
    static int[] ne = new int[N];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();//吸收一个空格
        init();
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String []action  = s1.split(" ");
            if(action[0].equals("H")){
                headAdd(Integer.parseInt(action[1]));
            }else if(action[0].equals("D")){
                remove(Integer.parseInt(action[1])-1);
            }else{
                kAdd(Integer.parseInt(action[1])-1,Integer.parseInt(action[2]));
            }
        }
        print();
    }

    static void init() {
        head =-1;
        idx=0;
    }
    static void headAdd(int val){
        e[idx] =  val;
        ne[idx] = head;
        head =idx;
        idx++;
    }
    static void remove(int k){
        ne[k]=ne[ne[k]];
    }
    static void kAdd(int k,int val){
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }
    static void print(){
        int index=head;
        while (index!=-1){
            System.out.print(e[index]);
            index = ne[index];
        }
    }


}