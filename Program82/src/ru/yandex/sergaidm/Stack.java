package ru.yandex.sergaidm;

public class Stack {

	private Object[] stack = new Object[10];
	private int indicator;
	private BlackList blackList = new BlackList();

	public Stack(Object[] stack, int indicator, BlackList blackList) {
		super();
		this.stack = stack;
		this.indicator = indicator;
		this.blackList = blackList;
	}

	public Stack() {
		super();
	}

	public Object[] getStack() {
		return stack;
	}

	public void setStack(Object[] stack) {
		this.stack = stack;
	}

	public int getIndicator() {
		return indicator;
	}

	public void setIndicator(int indicator) {
		this.indicator = indicator;
	}

	public BlackList getBlackList() {
		return blackList;
	}

	public void setBlackList(BlackList blackList) {
		this.blackList = blackList;
	}
	
	public boolean stackEmpty() {
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != null) {
				return  false;
			}
		}
		return true;
	}

	public void addToStack(Object obj, BlackList bl) throws ArrayIndexOutOfBoundsException {
		indicator = 0;
		for (int i = 0; i < stack.length; i++) {
			if (bl.checkObject(obj) == false) {
				if (stack[indicator] == null) {
					stack[indicator] = obj;
					break;
				}
			}
			indicator++;
		}
		if (bl.checkObject(obj) == true) {
			System.out.println("This object is located in the 'Black list'. Adding impossible.");
		}
		if (indicator == 10) {
			throw new ArrayIndexOutOfBoundsException("There is no more space on the stack");
		}
	}

	public Object getElement() throws ArrayIndexOutOfBoundsException {
		indicator = 9;
		Object obj = new Object();
		if (stackEmpty() == true) {
			throw new ArrayIndexOutOfBoundsException("Stack no more elements");
		}
		for (int i = 0; i < stack.length; i++) {
			if (stack[indicator] == null) {
				indicator--;
				continue;
			}
			if (stack[indicator] != null) {
				obj = stack[indicator];
				break;
			}
		}
		return obj;
	}

	public Object getElementWithDelete() throws ArrayIndexOutOfBoundsException {
		indicator = 9;
		Object obj = new Object();
		if (stackEmpty() == true) {
			throw new ArrayIndexOutOfBoundsException("Stack no more elements");
		}
		for (int i = 0; i < stack.length; i++) {
			if (stack[indicator] == null) {
				indicator--;
				continue;
			}
			if (stack[indicator] != null) {
				obj = stack[indicator];
				stack[indicator] = null;
				break;
			}
		}
		return obj;
	}

	public void printStack() {
		for (Object obj : stack) {
			System.out.println(obj);
		}
	}

}
