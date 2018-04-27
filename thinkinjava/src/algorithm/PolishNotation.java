package algorithm;

import java.util.Stack;

public class PolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			int temp;
			switch (tokens[i]) {
			case "+":
				s.push(s.pop() + s.pop());
				continue;
			case "-":
				temp = s.pop();
				s.push(s.pop() - temp);
				continue;
			case "*":
				s.push(s.pop() * s.pop());
				continue;
			case "/":
				temp = s.pop();
				s.push(s.pop() / temp);
				continue;
			default:
				s.push(Integer.parseInt(tokens[i]));
				continue;
			}
		}
		return s.pop();
	}
}
