package ru.yandex.sergaidm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Group {

	private List<Student> group;

	public Group() {
		group = new ArrayList<>();
	}

	public void addStudent(String surname, double age, char gender, String groupName) {
		group.add(new Student(surname, age, gender, groupName));
	}

	public void printGroup() {
		System.out.println(group);
	}

	public void deleteStudent(int place) throws GroupException {
		if (place >= 0 & place < group.size()) {
			System.out.println(group.get(place).getSurname() + " is expelled from the group");
			group.remove(place);
		} else {
			throw new GroupException("There is no such student in the group");
		}
	}

	public List<Student> searchStudentByLetter (char letter) {
		return group.stream()
		.filter(n -> (n.getSurname().charAt(0) == letter))
		.collect(Collectors.toCollection(ArrayList::new));
	}

}
