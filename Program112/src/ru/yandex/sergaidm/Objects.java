package ru.yandex.sergaidm;

public class Objects<T> {

	private int element;
	private T[] objectsArray = (T[]) new Object[element];
	private int i = 0;

	public Objects(int element) {
		super();
		this.element = element;
		objectsArray = (T[]) new Object[element];
	}

	public Objects() {
		super();
	}

	public int getI() {
		return i;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public T[] getObjectsArray() {
		return objectsArray;
	}

	public void addObjectToArray(T object) {
		for (int i = 0; i < objectsArray.length; i++) {
			if (objectsArray[i] == null) {
				objectsArray[i] = object;
				this.i++;
				return;
			}
		}
	}

	public void printArray(Objects<T> objects) {
		T[] array = objects.getObjectsArray();
		for (T element : array) {
			System.out.print("[" + element + "] ");
		}
	}

}
