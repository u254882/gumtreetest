package org.gumtreetest.model;

public enum Gender {
	MALE("Male"), FEMALE("Female"), UNKNOWN("Unkown");
	private final String gender;

	Gender(String gender) {
		this.gender = gender;
	}

	public String getGenderString() {
		return gender;
	}
}
