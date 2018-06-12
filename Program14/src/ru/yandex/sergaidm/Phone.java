package ru.yandex.sergaidm;

public class Phone {

	private String model;
	private String number;
	private Network network;

	public Phone(String model, String number) {
		super();
		this.model = model;
		this.number = number;
	}

	public Phone() {
		super();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNetwork() {
		return network.getName();
	}

	public void registerToNetwork(Network network) {
		this.network = network;
		if (!this.network.getPhones().contains(this)) {
			network.addPhone(this);
			System.out.println("Phone " + this + " registered in the network \"" + this.network.getName() + "\"");
		} else if (this.network.getPhones().contains(this)) {
			System.out.println("This phone number " + this.number + " is already registered in \""
					+ this.network.getName() + "\"");
		}
	}

	public void call(String phoneNumber) {
		if (this.network == null) {
			System.out.println("This phone doesn't register in network");
			return;
		}
		Phone phone = this.network.getPhoneByNumber(phoneNumber);
		if (phone != null) {
			System.out.println(this + " , calls to dialed number. Wait for the subscriber's answer");
		} else {
			System.out.println("Dialed number does not exist");
		}
	}

	@Override
	public String toString() {
		return "\"" + model + "\", " + number;
	}

}
