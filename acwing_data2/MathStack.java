package acwing_base1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: ChangSir
 * @Date: 2023/1/16 13:41
 * @Description:
 */
public class MathStack {

    static Stack<Character> op = new Stack<>();
    static Stack<Integer> stack = new Stack<>();
    static Map<Character,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        for (int i = 0; i < s.length(); i++) {
            int x = 0, j = i;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                while (j<s.length()&&s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    x = x * 10 + (s.charAt(j) - '0');
                    j++;
                }
                stack.push(x);
                i = j - 1;
            } else if (s.charAt(i) == '(') op.push('(');
            else if (s.charAt(i) == ')') {
                while (op.peek()!='(')eval();
                op.pop();
            }
            else {
                while (!op.empty()&& op.peek() != '('&&map.get(s.charAt(i))<=map.get(op.peek())){
                    eval();
                }
                op.push(s.charAt(i));
            }
        }
        while (!op.empty())eval();
        System.out.println(stack.peek());
    }

    private static void eval() {
        int b = stack.pop();
        int a= stack.pop();
        int x=0;
        Character c= op.pop();
        if(c=='+'){
            x=a+b;
        }else if(c=='-')x=a-b;
        else if (c=='*')x =a*b;
        else x=a/b;
        stack.push(x);
    }
}
