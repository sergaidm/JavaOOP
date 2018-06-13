package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GroupDAOTXTFileImplementation implements GroupDAO {

	private File folder;

	public GroupDAOTXTFileImplementation() {
		super();
	}

	public GroupDAOTXTFileImplementation(File folder) {
		super();
		this.folder = folder;
	}

	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}

	@Override
	public void saveGroupToFile(Group group) {
		try (PrintWriter pw = new PrintWriter(new File(folder, "List of group.txt"))) {
			for (Student student : group.getStudentsArray()) {
				if (student != null) {
					pw.println(student.getSurname() + "," + student.getAge() + "," + student.getGender() + ","
							+ student.getUniversity());
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@Override
	public Group loadGroupFromFile() {
		Group loadedGroup = new Group();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(folder, "List of group.txt")))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				String[] studentDate = text.split(",");
				String surname = studentDate[0];
				double age = Double.valueOf(studentDate[1]);
				String gender = studentDate[2];
				String university = studentDate[3];
				Student student = new Student(surname, age, gender, university);
				loadedGroup.addStudentToGroup(student);

			}
		} catch (IOException | GroupException e) {
			System.out.println(e);
			return null;
		}
		return loadedGroup;
	}

}