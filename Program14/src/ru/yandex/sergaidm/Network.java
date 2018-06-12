package ru.yandex.sergaidm;

import java.util.HashSet;
import java.util.Set;

public class Network {

	private String name;
	private Set<Phone> phones = new HashSet<>();

	public Network(String name) {
		super();
		this.name = name;
		phones = new HashSet<>();
	}

	public Network() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void printNetwork() {
		System.out.println(phones);
	}

	public void addPhone(Phone phone) {
		phones.add(phone);
	}

	public Phone getPhoneByNumber(String phoneNumber) {
		for (Phone phone : phones) {
			if (phone.getNumber() == phoneNumber) {
				return phone;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Network [name=" + name + "]";
	}

}
