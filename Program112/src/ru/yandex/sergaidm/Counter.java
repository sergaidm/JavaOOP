package ru.yandex.sergaidm;

import java.util.HashMap;
import java.util.Map;

public class Counter<T> {
	private T type;

	public Counter(T type) {
		super();
		this.type = type;
	}

	public Counter() {
		super();
	}

	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}

	public Map<T, Integer> count(Objects<T> objects) {
		T[] array = objects.getObjectsArray();
		Map<T, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			Integer element = map.get(array[i]);
			if (element != null) {
				map.put(array[i], element + 1);
			} else {
				map.put(array[i], 1);
			}
		}
		return map;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Counter<T> other = (Counter<T>) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Counter [type=" + type + "]";
	}

}
