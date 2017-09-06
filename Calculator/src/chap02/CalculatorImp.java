package chap02;

public class CalculatorImp implements Calculator {

	@Override
	public int add(int a, int b) {
		return 0;
	}

	@Override
	public int sub(int a, int b) {
		return 0;
	}

	@Override
	public int mult(int a, int b) {
		return 0;
	}

	@Override
	public int div(int a, int b) {
		if (b==0) {
			throw new ArithmeticException();
		}
		return a / b;
	}
}
