package acwing_base1;

import java.util.Scanner;

/**
 * @Author: ChangSir
 * @Date: 2023/1/28 13:53
 * @Description:
 */
public class SimulateHeap {
    static int[] h = new int[100010];
    static int[] hp = new int[100010];
    static int[] ph = new int[100010];


    static int size = 0;
    static int m = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String action = sc.next();
            if (action.equals("I")) {
                int x = sc.nextInt();
                h[++size] = x;
                m++;
                ph[m] = size;
                hp[size] = m;
                up(size);
            } else if (action.equals("PM")) System.out.println(h[1]);
            else if (action.equals("DM")) {
                swap_heap(1, size);

                size--;
                down(1);
            } else if (action.equals("D")) {
                int k = sc.nextInt();
                k = ph[k];
                swap_heap(k, size);
                size--;
                down(k);
                up(k);
            } else {
                int k = sc.nextInt();
                int x = sc.nextInt();
                k = ph[k];
                h[k] = x;
                down(k);
                up(k);
            }

        }
    }

    static void down(int x) {
        int t = x;
        if (x * 2 <= size && h[t] > h[x * 2]) t = 2 * x;
        if (2 * x + 1 <= size && h[t] > h[2 * x + 1]) t = 2 * x + 1;
        if (t != x) {
            swap_heap(t, x);
            down(t);
        }
    }

    static void up(int x) {
        int t = x;
        while (x / 2 > 0 && h[x / 2] > h[x]) {
            swap_heap(x / 2, x);
            x = x / 2;
        }
    }

    static void swap_heap(int a, int b) {
        swap(ph, hp[a], hp[b]);
        swap(hp, a, b);
        swap(h, a, b);
    }

    static void swap(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }
}
