package acwing_base1;

import java.util.Scanner;

/**
 * @Author: ChangSir
 * @Date: 2023/1/16 15:38
 * @Description:
 */
public class ArrayQueue {
    static final int N = 100010;
    static int[] que = new int[N];
    static int front = 0, head = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] action = scanner.nextLine().split(" ");
            if (action[0].equals("push")) {
                push(Integer.parseInt(action[1]));
            } else if(action[0].equals("empty")) {
                empty();
            }else if(action[0].equals("pop")){
                pop();
            }else {
                query();
            }
        }

    }

    static void empty() {
        if ((head + N) % N != front % N) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    static void query() {
        if ((head + N) % N != front % N) {
            System.out.println(que[(head + N) % N]);
        }

    }

    static void pop() {
        if ((head + N) % N != front % N) {
            head++;
        }

    }

    static void push(int x) {
        if ((front + 1) % N != (head + N) % N) {
            que[(front++) % N] = x;
        }
    }
}
