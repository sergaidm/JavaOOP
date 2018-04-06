package ru.yandex.sergaidm;

import java.util.ArrayList;
import java.util.List;

public class ListOperations {

	public List<Integer> createList() {
		List<Integer> list = new ArrayList<>();		
		for (int i = 1; i <= 10; i++) {
			int r = (int) (Math.random() * 10);
			Integer number = new Integer(r);
			list.add(number);
		}
		System.out.println(list);
		list.remove(0);		
		list.remove(0);		
		list.remove(list.size()-1);
		System.out.println(list);
		return list;
	}

}
