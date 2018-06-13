package ru.yandex.sergaidm;

public interface GroupDAO {

	public void saveGroupToFile(Group group);

	public Group loadGroupFromFile();

}
