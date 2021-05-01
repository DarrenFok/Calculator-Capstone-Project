import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class main {
	public static void main(String[] args) {
		Scanner sus = new Scanner(System.in);
		System.out.println("Enter your equation here (no spaces or you're oafed lol ( ͡° ͜ʖ ͡°)  ):");
		String input = sus.nextLine(); // 24*14+241+17441
		InfixToPostfix converter = new InfixToPostfix();
		
		
		List<String> postFix = converter.parse(input);

		// debug
		System.out.println(postFix);
		System.out.println(evaluate(postFix));
		// evaluate postFix expression
		System.out.println("Postfix equation: " + converter.parse(input));
		System.out.println("Your answer is: " + evaluate(postFix));
	}

	private static String evaluate(List<String> postFix) {
		// define operation stack
		Stack<String> stack = new Stack<>();
		// walk through postFix expression
		for (String token : postFix) { 
			// If operation then pop next two integers and do the operation to them
			if ("+".equals(token)) { 
				int op1 = Integer.parseInt(stack.pop());
				int op2 = Integer.parseInt(stack.pop());
				Addition operation = new Addition();
				int addResult = operation.execute(op1, op2);
				stack.push(String.valueOf(addResult));
				
			} 
			else if ("-".equals(token)) {
				int op2 = Integer.parseInt(stack.pop());
				int op1 = Integer.parseInt(stack.pop());
				Subtraction operation = new Subtraction();
				int addResult = operation.execute(op1, op2);
				stack.push(String.valueOf(addResult));
				
			} 			
			else if ("*".equals(token)) {
				int op1 = Integer.parseInt(stack.pop());
				int op2 = Integer.parseInt(stack.pop());
				Multiplication operation = new Multiplication();
				int addResult = operation.execute(op1, op2);
				stack.push(String.valueOf(addResult));
				
			} 			
			else if ("/".equals(token)) {
				int op2 = Integer.parseInt(stack.pop());
				int op1 = Integer.parseInt(stack.pop());
				Division operation = new Division();
				int addResult = operation.execute(op1, op2);
				stack.push(String.valueOf(addResult));				
			}else{ // push last number
				stack.push(token);
				
			}
		}
		// return result
		return stack.pop();

	}
}
