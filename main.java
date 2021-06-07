import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class main {
	public static void main(String[] args) {
		//Allow for user input
		Scanner scanner = new Scanner(System.in);

		//Reading and storing user input
		System.out.println("Enter your equation here:");
		String input = scanner.nextLine();
		String noSpace = input.replaceAll("\\s", ""); //removes all blank spaces

		//infix to postfix
		InfixToPostfix converter = new InfixToPostfix();
		List<String> postFix = converter.parse(noSpace);

		//print postfix equation and answer
		System.out.println("Postfix equation: " + converter.parse(noSpace));
		System.out.println("Your answer is: " + evaluate(postFix));
	}

	private static String evaluate(List<String> postFix) {
		// define operation stack
		Stack<String> stack = new Stack<>();
		// walk through postFix expression
		for (String token : postFix) { 
			// If operation then pop next two integers and do the operation to them
			if ("+".equals(token)) {
				double op1 = Double.parseDouble(stack.pop());
				double op2 = Double.parseDouble(stack.pop());
				Addition operation = new Addition();
				double addResult = operation.execute(op1, op2);
				stack.push(String.valueOf(addResult));
				
			} 
			else if ("-".equals(token)) {
				double op2 = Double.parseDouble(stack.pop());
				double op1 = Double.parseDouble(stack.pop());
				Subtraction operation = new Subtraction();
				double addResult = operation.execute(op1, op2);
				stack.push(String.valueOf(addResult));
				
			} 			
			else if ("*".equals(token)) {
				double op1 = Double.parseDouble(stack.pop());
				double op2 = Double.parseDouble(stack.pop());
				Multiplication operation = new Multiplication();
				double addResult = operation.execute(op1, op2);
				stack.push(String.valueOf(addResult));
				
			} 			
			else if ("/".equals(token)) {
				double op2 = Double.parseDouble(stack.pop());
				double op1 = Double.parseDouble(stack.pop());
				Division operation = new Division();
				double addResult = operation.execute(op1, op2);
				stack.push(String.valueOf(addResult));				
			}else{ // push last number
				stack.push(token);
				
			}
		}
		// return result
		return stack.pop();

	}
}
