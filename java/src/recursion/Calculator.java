package recursion;

public class Calculator {
	private char[] args;
	int i;

	public Calculator(String s) {
		i = 0;
		args = new char[s.length()];
		s.getChars(0, s.length(), args, 0);
	}

	public int expression_value() {
		int result = term_value();
		a:while (i < args.length - 1) {
			switch (args[i + 1]) {
			case '+':
				i += 2;
				result += term_value();
				continue;
			case '-':
				i += 2;
				result -= term_value();
				continue;
			default:
				break a;
			}
		}
		return result;
	}

	private int term_value() {
		int result = factor_value();
		a:while (i < args.length - 1) {
			switch (args[i + 1]) {
			case '*':
				i += 2;
				result *= factor_value();
				continue;
			case '/':
				i += 2;
				result /= factor_value();
				continue;
			default:
				break a;
			}
		}
		return result;
	}

	private int factor_value() {
		if (args[i] == '(') {
			i++;
			int value = expression_value();
			i++;
			return value;
		}
		return args[i] - '0';
	}
}