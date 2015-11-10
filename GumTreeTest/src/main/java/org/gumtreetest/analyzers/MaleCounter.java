package org.gumtreetest.analyzers;

import org.gumtreetest.model.Gender;
import org.gumtreetest.model.PeopleGroup;
import org.gumtreetest.model.Person;

public class MaleCounter {
	public int getNumberOfMales(PeopleGroup people) {
		int result = 0;
		for (Person person : people.getPeople()) {
			if (person.getGender().equals(Gender.MALE)) {
				result++;
			}
		}
		return result;
	}
}
