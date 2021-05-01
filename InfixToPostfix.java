import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {
    static int Hierarchy(char c){
        switch(c){
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    static List<String> parse(String input) {
//        String result = new String("");
    	List<String> result = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            //If the scanned character is an operand, then add to result
            if (Character.isLetterOrDigit(c)) {
//                result += c;
                number = number.append(c);
            } else {
            	if (number.length() > 0) {
            		result.add(number.toString());
            		number = new StringBuilder();
            	}
            	
                //If the scanned character is an open bracket ( , then push to stack
                if (c == '(')
                    stack.push(c);

                    //If the scanned character is a closed bracket ) , then pop and output everything from stack until open bracket (
                else if (c == ')') {
                    while (stack.peek() != '(' && !stack.isEmpty())
                     //   result += stack.pop();
                    	result.add(String.valueOf(stack.pop()));

                    if (stack.peek() != '(' && !stack.isEmpty())
                        return null;

                    else stack.pop();
                }

                //If the scanned character is an operator...
                else {
                    while (!stack.isEmpty() && Hierarchy(c) <= Hierarchy(stack.peek())) {
                        //result += stack.pop();
                    	result.add(String.valueOf(stack.pop()));
                    }
                    stack.push(c);
                }
            }

        }
        //pop whatever is left
        while(!stack.isEmpty()) {
            //result += stack.pop();
        	if (number.length() > 0) {
        		result.add(number.toString());
        		number = new StringBuilder();
        	}
        	result.add(String.valueOf(stack.pop()));
        }
        return result;
    }
}
