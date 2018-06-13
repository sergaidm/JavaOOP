package ru.yandex.sergaidm;

public class Main {

	public static void main(String[] args) {

		BlackList blackList = new BlackList();

		blackList.addClass(Integer.class);
		blackList.addClass(Character.class);
		blackList.addClass(String.class);
		System.out.println("Classes in black list:" + System.lineSeparator());
		blackList.printBlackList();

		Character c = 'c';

		Stack stack = new Stack();
		System.out.println(System.lineSeparator() + "Adding a forbidden object to the stack:");
		stack.addToStack(c, blackList);

		Double d = 1.0;
		stack.addToStack(d, blackList);
		stack.addToStack(blackList, blackList);
		stack.addToStack(d, blackList);
		stack.addToStack(d, blackList);
		stack.addToStack(blackList, blackList);

		System.out.println(System.lineSeparator() + "Stack with added objects:" + System.lineSeparator());
		stack.printStack();

		System.out.println(System.lineSeparator() + "Getting an element from the stack: " + stack.getElement());

		System.out.println(System.lineSeparator() + "Getting an element from the stack with its deleting: ");
		System.out.println("1 - " + stack.getElementWithDelete());
		System.out.println("2 - " + stack.getElementWithDelete());

		System.out.println(System.lineSeparator() + "Stack without deleted objects:" + System.lineSeparator());
		stack.printStack();

	}

}
