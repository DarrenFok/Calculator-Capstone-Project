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

    static String method(String input) {
        String result = new String("");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            //If the scanned character is an operand, then add to result
            if (Character.isLetterOrDigit(c))
                result += c;

                //If the scanned character is an open bracket ( , then push to stack
            else if (c == '(')
                stack.push(c);

                //If the scanned character is a closed bracket ) , then pop and output everything from stack until open bracket (
            else if (c == ')') {
                while (stack.peek() != '(' && !stack.isEmpty())
                    result += stack.pop();

                if (stack.peek() != '(' && !stack.isEmpty())
                    return "you played urself";

                else stack.pop();
            }

            //If the scanned character is an operator...
            else {
                while (!stack.isEmpty() && Hierarchy(c) <= Hierarchy(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }
        }
        //pop whatever is left
        while(!stack.isEmpty())
            result += stack.pop();

        return result;
    }
}

public class Addition {
	public int addition (int a, int b) {
		int result = a + b;
		return result;
				
	}

}

public class Multiply {
	public int multiply (int a, int b) {
		int result = a * b;
		return result;
		
	}
}
