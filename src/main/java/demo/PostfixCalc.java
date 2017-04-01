package demo;

import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Calvus on 2017-04-01.
 */
public class PostfixCalc {

    public String calculate(String input) {
        //Process the list into an ArrayList
        List<String> processedList = new ArrayList<String>();

        if (!input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                processedList.add(st.nextToken());
            }
        } else {
            return "Error";
        }
        //A Stack, we will use this for the calculation
        Stack<String> tempList = new Stack<String>();

        //Iterate over the whole processed list
        Iterator<String> iter = processedList.iterator();
        while (iter.hasNext()) {
            String temp = iter.next();
            if (temp.matches("[0-9]*")) {
                //If the current item is a number (aka operand), push it onto the stack
                tempList.push(temp);
            }

            else if (temp.matches("[*-/+]")) {
                //If the current item is an operator we pop off the last two elements
                //of our stack and calculate them using the operator we are looking at.
                //Push the result onto the stack.
                if (temp.equals("*")) {
                    int rs = Integer.parseInt(tempList.pop());
                    int ls = Integer.parseInt(tempList.pop());
                    int result = ls * rs;
                    tempList.push("" + result);
                }

                else if (temp.equals("-")) {
                    int rs = Integer.parseInt(tempList.pop());
                    int ls = Integer.parseInt(tempList.pop());
                    int result = ls - rs;
                    tempList.push("" + result);
                }

                else if (temp.equals("/")) {
                    int rs = Integer.parseInt(tempList.pop());
                    int ls = Integer.parseInt(tempList.pop());
                    int result = ls / rs;
                    tempList.push("" + result);
                }

                else if (temp.equals("+")) {
                    int rs = Integer.parseInt(tempList.pop());
                    int ls = Integer.parseInt(tempList.pop());
                    int result = ls + rs;
                    tempList.push("" + result);
                }
            } else {
                return "Error";
            }
        }
        //Return the last element on the Stack.
        return tempList.pop();
    }

    public static void main(String [] args) {

        PostfixCalc calc = new PostfixCalc();
        String result = calc.calculate("65 3 5 * + 83 -");
        System.out.println(result);
    }
}
