package level2.tasks;

import java.util.Scanner;
import java.util.Stack;

public class Task2VerificationOfString {
    public static void run() {
        Stack stk = new Stack();
        Scanner s = new Scanner(System.in);
        boolean balance = true;

        System.out.println("Enter a string:");
        String str = s.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stk.push(str.charAt(i));
            } else if (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {
                if (!stk.isEmpty()) {
                    System.out.println(stk.peek());
                    if ((stk.peek().equals('(') && str.charAt(i) != ')') ||
                            (stk.peek().equals('[') && str.charAt(i) != ']') ||
                            (stk.peek().equals('{') && str.charAt(i) != '}')) {

                        balance = false;
                        System.out.println("Brackets don't match.");
                        break;
                    }
                } else {
                    balance = false;
                    System.out.println("There is no opening bracket.");
                    break;
                }
            }
        }
        if (balance == true) {
            System.out.println("The equation is balanced.");
        } else {
            System.out.println("The equation is not balanced.");
        }
    }
}