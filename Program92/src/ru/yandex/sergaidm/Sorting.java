package ru.yandex.sergaidm;

import java.util.List;

public class Sorting {

	private static int parameter = 0;

	public Sorting(int parameter) {
		super();
		Sorting.parameter = parameter;
	}

	public Sorting() {
		super();
	}

	public int getParameter() {
		return parameter;
	}

	public void setParameter(int parameter) {
		Sorting.parameter = parameter;
	}

	public static List<Student> ascendingSortingBySurname(List<Student> students) {
		parameter = 1;
		students.sort((a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: (a.getSurname().compareToIgnoreCase(b.getSurname())));
		return students;
	}

	public static List<Student> descendingSortingBySurname(List<Student> students) {
		parameter = 2;
		students.sort((a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: -1 * (a.getSurname().compareToIgnoreCase(b.getSurname())));
		return students;
	}

	public static List<Student> ascendingSortingByAge(List<Student> students) {
		parameter = 3;
		students.sort((a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: Double.compare(a.getAge(), (b.getAge())));
		return students;
	}

	public static List<Student> descendingSortingByAge(List<Student> students) {
		parameter = 4;
		students.sort((a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: -1 * Double.compare(a.getAge(), (b.getAge())));
		return students;
	}

}
