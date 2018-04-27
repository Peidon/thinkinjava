package recursion;

public class PolishNotation {
	public int evalRPN(String[] tokens) {
		int length = tokens.length - 1;
		if (length == 0) {
			return Integer.parseInt(tokens[0]);
		}
		while (tokens[length] == null) {
			length--;
		}
		switch (tokens[length]) {
		case "+":
			tokens[length] = null;
			return evalRPN(tokens) + evalRPN(tokens);
		case "-":
			tokens[length] = null;
			return 0 - evalRPN(tokens) + evalRPN(tokens);
		case "*":
			tokens[length] = null;
			return evalRPN(tokens) * evalRPN(tokens);
		case "/":
			tokens[length] = null;
			int i = evalRPN(tokens);
			int j = evalRPN(tokens);
			return j / i;
		default:
			Integer r = Integer.parseInt(tokens[length]);
			tokens[length] = null;
			return r;
		}
	}
}
