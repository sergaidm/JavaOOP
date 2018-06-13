package ru.yandex.sergaidm;

public class BlackList {

	private Class<?>[] blackList;

	public BlackList() {
		blackList = new Class[0];
	}

	public void addClass(Class<?> classOne) {
		Class<?>[] classTwo = new Class[blackList.length + 1];
		System.arraycopy(blackList, 0, classTwo, 0, blackList.length);
		classTwo[classTwo.length - 1] = classOne;
		blackList = classTwo;
	}

	public boolean checkObject(Object object) {
		boolean result = true;
		for (int i = 0; i < blackList.length; i++) {
			if (object.getClass() == blackList[i]) {
				result = true;
				break;
			} else {
				result = false;
			}
		}
		return result;
	}

	public void printBlackList() {
		for (Class<?> classOne : blackList) {
			System.out.println(classOne);
		}
	}

}
