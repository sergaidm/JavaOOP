package ru.yandex.sergaidm;

import java.util.ArrayDeque;

public class DoubleCola {

	private ArrayDeque<ColaFan> queue;

	public DoubleCola(ArrayDeque<ColaFan> queue) {
		super();
		this.queue = queue;
		queue = new ArrayDeque<>();
	}

	public DoubleCola() {
		super();
		queue = new ArrayDeque<>();
	}

	public ArrayDeque<ColaFan> addColaFan(ColaFan cf) {
		queue.push(cf);
		return queue;
	}

	public void printQueue() {
		for (; queue.peek() != null;) {
			System.out.println(queue.pop());
		}
	}

	public void workCola(int drink) {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if (drink == i + 1) {
				workCola(i);
				ColaFan cf = queue.pollLast();
				queue.addFirst(cf);
				queue.addFirst(cf);
			}
		}
	}

}
