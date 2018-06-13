package ru.yandex.sergaidm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Faculty implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Group> faculty;

	public Faculty() {
		faculty = new ArrayList<>();
	}

	public void addGroup(Group group) {
		faculty.add(group);
	}

	public void printFaculty() {
		for (Group group : faculty) {
			group.printGroup();
		}
	}

	public void writeFaculty(Faculty faculty, File file) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(faculty);
		} catch (IOException e) {
			System.out.println("Faculty save error");
		}
	}

	public void readFaculty(File file) {
		Faculty faculty = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			faculty = (Faculty) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Faculty load error");
		}
		System.out.println("List of faculty groups:" + System.lineSeparator());
		faculty.printFaculty();
	}

}
