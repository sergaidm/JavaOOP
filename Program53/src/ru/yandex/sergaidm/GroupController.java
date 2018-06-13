package ru.yandex.sergaidm;

public class GroupController {
	
	private GroupDAO groupDAO;

	public GroupController(GroupDAO groupDAO) {
		super();
		this.groupDAO = groupDAO;
	}

	public GroupDAO getGroupDAO() {
		return groupDAO;
	}

	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	public Group loadGroupFromFile() {
		if (groupDAO == null) {
			throw new IllegalArgumentException("Empty GroupDAO realisation");
		}
		return groupDAO.loadGroupFromFile();
	}

	public void saveGroupToFile(Group group) {
		if (groupDAO == null) {
			throw new IllegalArgumentException("Empty GroupDAO realisation");
		}
		groupDAO.saveGroupToFile(group);
	}

}
