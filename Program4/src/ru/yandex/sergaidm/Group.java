package ru.yandex.sergaidm;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Group implements MilitaryCommissar {

	private Student student;
	private Student[] group = new Student[10];

	public Group(Student student, Student[] group) {
		super();
		this.student = student;
		this.group = group;
	}

	public Group() {
		super();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}

	public boolean addStudentToGroup(Student student, int place) throws GroupException {
		boolean r = false;
		for (Student anotherStudent : group) {
			if (place > group.length) {
				throw new GroupException("In group there are no more free places");
			} else if (group[place] == null) {
				group[place] = student;
				System.out.println("The student is added to " + (place + 1) + " place of the group");
				return r = true;
			}
			if (group[place] != null) {
				System.out.println("Impossible to add student to " + (place + 1) + " place of the group");
				throw new GroupException("This place of group is taken by another student");
			}
		}
		return r;
	}

	public void interactiveAddStudentToGroup() throws IllegalArgumentException {

		for (;;) {
			Student st = new Student();
			try {
				String surname = InteractiveInputSurname();
				Double age = InteractiveInputAge();
				String gender = InteractiveInputGender();
				String university = InteractiveInputUniversity();
				int place = InteractiveInputPlace();

				if (surname == null | age == 0 | gender == null | university == null) {
					JOptionPane.showMessageDialog(null, "Incorrect parameters of student. Error adding to group");
					throw new IllegalArgumentException();
				} else {
					st = new Student(surname, age, gender, university);
				}

				try {
					addStudentToGroup(st, place);
				} catch (GroupException e) {
					System.out.println(e);
				}
				break;
			} finally {
				System.out.println(st);
			}
		}

	}

	private String InteractiveInputSurname() throws IllegalArgumentException {
		String surname = "";
		for (;;) {
			try {
				surname = JOptionPane.showInputDialog("Input surname of student: ");
				if (surname == null) {
					throw new NullPointerException();
				}
				if (surname == "") {
					throw new NullPointerException();
				}
				if (surname.isEmpty() == true) {
					throw new IllegalArgumentException();
				}
				break;

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid string format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled");
				break;
			}
		}
		return surname;
	}

	private double InteractiveInputAge() {
		double age = 0;
		for (;;) {
			try {
				age = Double.valueOf(JOptionPane.showInputDialog("Input age of student"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled");
				break;
			}
		}
		return age;
	}

	private String InteractiveInputGender() throws IllegalArgumentException {

		String gender = "";
		for (;;) {
			try {
				gender = JOptionPane.showInputDialog("Input gender of student: ");
				if (gender == null) {
					throw new NullPointerException();
				}
				if (gender == "") {
					throw new NullPointerException();
				}
				if (gender.isEmpty() == true) {
					throw new IllegalArgumentException();
				}
				if (!gender.equalsIgnoreCase("male") & !gender.equalsIgnoreCase("female") & gender != null) {
					throw new IllegalCharsetNameException("");
				}
				break;
			} catch (IllegalCharsetNameException e) {
				JOptionPane.showMessageDialog(null, "Gender can be only male or female");
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid string format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled");
				break;
			}
		}
		return gender;
	}

	private String InteractiveInputUniversity() throws IllegalArgumentException {
		String university = "";
		for (;;) {
			try {
				university = JOptionPane.showInputDialog("Input university of student: ");
				if (university == null) {
					throw new NullPointerException();
				}
				if (university == "") {
					throw new NullPointerException();
				}
				if (university.isEmpty() == true) {
					throw new IllegalArgumentException();
				}
				break;

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid string format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled");
				break;
			}
		}
		return university;
	}

	private int InteractiveInputPlace() {
		String input = "";
		int place = 0;
		for (;;) {
			try {
				input = JOptionPane.showInputDialog("Input place of student in group");
				if (input == null) {
					throw new NullPointerException();
				}
				if (input == "") {
					throw new NullPointerException();
				}
				place = Integer.parseInt(input);
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled. Set default value");
				break;
			}
		}
		return place;
	}

	public void delStudentfromGroup(Student student, int place) throws GroupException {

		if (place >= 0 & place < group.length) {
			group[place] = null;
			System.out.println("The " + (place + 1) + " student is expelled from the group");
		} else {
			throw new GroupException("There is no such student in the group");
		}

	}

	public Student searchStudent(String surname) {

		for (Student student : group) {
			if (student != null && student.getSurname().equals(surname)) {
				return student;
			}
		}
		return null;
	}

	public Student[] createStudent() {
		Student[] st = new Student[group.length];
		for (int i = 0; i < group.length; i++) {
			st[i] = group[i];
		}
		return st;
	}

	@Override
	public Student[] isRecruit() {
		Group gr = new Group();
		for (Student student : group) {
			if (student != null && student.getAge() >= 18 && student.getGender().equalsIgnoreCase("male")) {
				for (int j = 0; j < group.length; j++) {
					try {
						gr.addStudentToGroup(student, j);
						break;
					} catch (GroupException e) {
						System.out.println(e);
					}
				}
			}
		}
		return gr.createStudent();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String text = "\tGroup of students: ";
		sb.append(text + System.lineSeparator() + System.lineSeparator() + Arrays.toString(group));
		return sb.toString();
	}

}
