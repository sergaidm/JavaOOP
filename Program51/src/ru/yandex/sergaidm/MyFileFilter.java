package ru.yandex.sergaidm;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {

	private String[] filteredArray;

	public MyFileFilter(String... filteredArray) {
		super();
		this.filteredArray = filteredArray;
	}

	private boolean check(String ext) {
		for (String stringExt : filteredArray) {
			if (stringExt.equals(ext)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean accept(File pathname) {
		int pointerIndex = pathname.getName().lastIndexOf(".");
		if (pointerIndex == -1) {
			return false;
		}
		String ext = pathname.getName().substring(pointerIndex + 1);
		return check(ext);
	}

}
