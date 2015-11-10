package org.gumtreetest.model;

import java.util.HashSet;

public class PeopleGroup {
	private HashSet<Person> people = new HashSet<Person>();

	public HashSet<Person> getPeople() {
		return people;
	}

	public void setPeople(HashSet<Person> people) {
		this.people = people;
	}
}
