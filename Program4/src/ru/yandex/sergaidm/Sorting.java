package ru.yandex.sergaidm;

import java.util.Arrays;

public class Sorting {

	private static int parameter = 0;

	public int getParameter() {
		return parameter;
	}

	public void setParameter(int parameter) {
		Sorting.parameter = parameter;
	}

	public static Student[] ascendingSortingBySurname(Student[] studentArray) {
		parameter = 1;
		Arrays.sort(studentArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: a.getSurname().compareToIgnoreCase(b.getSurname()));
		return studentArray;
	}

	public static Student[] descendingSortingBySurname(Student[] studentArray) {
		parameter = 2;
		Arrays.sort(studentArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: -1 * (a.getSurname().compareToIgnoreCase(b.getSurname())));
		return studentArray;
	}

	public static Student[] ascendingSortingByAge(Student[] studentArray) {
		parameter = 3;
		Arrays.sort(studentArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: Double.compare(a.getAge(), b.getAge()));
		return studentArray;
	}

	public static Student[] descendingSortingByAge(Student[] studentArray) {
		parameter = 4;
		Arrays.sort(studentArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: -1 * Double.compare(a.getAge(), b.getAge()));
		return studentArray;
	}

	public static Student[] ascendingSortingByGender(Student[] studentArray) {
		parameter = 5;
		Arrays.sort(studentArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: a.getGender().compareToIgnoreCase(b.getGender()));
		return studentArray;
	}

	public static Student[] descendingSortingByGender(Student[] studentArray) {
		parameter = 6;
		Arrays.sort(studentArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: -1 * (a.getGender().compareToIgnoreCase(b.getGender())));
		return studentArray;
	}

	public static Student[] ascendingSortingByUniversity(Student[] studentArray) {
		parameter = 7;
		Arrays.sort(studentArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: a.getUniversity().compareToIgnoreCase(b.getUniversity()));
		return studentArray;
	}

	public static Student[] descendingSortingByUniversity(Student[] studentArray) {
		parameter = 8;
		Arrays.sort(studentArray, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: -1 * (a.getUniversity().compareToIgnoreCase(b.getUniversity())));
		return studentArray;
	}

}
