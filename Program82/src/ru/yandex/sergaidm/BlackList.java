package ru.yandex.sergaidm;

public class BlackList {

	private Class[] blackList;

	public BlackList() {
		blackList = new Class[0];
	}

	public void addClass(Class c) {
		Class[] cl = new Class[blackList.length + 1];
		System.arraycopy(blackList, 0, cl, 0, blackList.length);
		cl[cl.length - 1] = c;
		blackList = cl;
	}

	public boolean checkObject(Object obj) {
		boolean res = true;
		for (int i = 0; i < blackList.length; i++) {
			if (obj.getClass() == blackList[i]) {
				res = true;
				break;
			} else {
				res = false;
			}
		}
		return res;
	}

	public void printBlackList() {
		for (Class cl : blackList) {
			System.out.println(cl);
		}
	}

}
