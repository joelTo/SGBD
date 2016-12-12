package fr.ihm.action;

public abstract class ActionClient {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract void doAction();

	public abstract void describeAction();
}