package org.easymock.sample;

public class Demo implements IMathDemo{
	public int add(int a, int b) {
		return a + b;
	}

	public int div(int a, int b) {
		return a / b;
	}
}
