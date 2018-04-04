package ru.yandex.sergaidm;

public class Main {

	public static void main(String[] args) {

		BlackList bl = new BlackList();

		bl.addClass(Integer.class);
		bl.addClass(Character.class);
		bl.addClass(String.class);
		System.out.println("Classes in black list:" + System.lineSeparator());
		bl.printBlackList();

		Character c = 'c';

		Stack s = new Stack();
		System.out.println(System.lineSeparator() + "Adding a forbidden object to the stack:");
		s.addToStack(c, bl);

		Double d = 1.0;
		s.addToStack(d, bl);
		s.addToStack(bl, bl);
		s.addToStack(d, bl);
		s.addToStack(d, bl);
		s.addToStack(bl, bl);

		System.out.println(System.lineSeparator() + "Stack with added objects:" + System.lineSeparator());
		s.printStack();

		System.out.println(System.lineSeparator() + "Getting an element from the stack: " + s.getElement());

		System.out.println(System.lineSeparator() + "Getting an element from the stack with its deleting: ");
		System.out.println("1 - " + s.getElementWithDelete());
		System.out.println("2 - " + s.getElementWithDelete());

		System.out.println(System.lineSeparator() + "Stack without deleted objects:" + System.lineSeparator());
		s.printStack();

	}

}
