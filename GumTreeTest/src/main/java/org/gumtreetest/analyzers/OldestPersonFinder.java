package org.gumtreetest.analyzers;

import java.util.HashSet;

import org.gumtreetest.model.PeopleGroup;
import org.gumtreetest.model.Person;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;

public class OldestPersonFinder {

	public HashSet<Person> getOldestPerson(PeopleGroup peopleGroup) {
		HashSet<Person> people = peopleGroup.getPeople();
		//there are people who are the same old, so it's a set
		HashSet<Person> oldestPeople = new HashSet<Person>();
		DateTime minBirthday = DateTime.now();
		//find the earliest birthday
		for (Person person : people) {
			if (DateTimeComparator.getDateOnlyInstance().compare(person.getBirthDate(),minBirthday) <= 0) {
				minBirthday = person.getBirthDate();
			}
		}
		//find the people born on that earliest birthday
		for (Person person : people) {
			if (DateTimeComparator.getDateOnlyInstance().compare(person.getBirthDate(),minBirthday) == 0) {
				oldestPeople.add(person);
			}
		}
		return oldestPeople;
	}
}
