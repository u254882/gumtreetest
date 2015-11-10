package org.gumtreetest.analyzers;

import org.gumtreetest.model.PeopleGroup;
import org.gumtreetest.model.Person;
import org.joda.time.Days;

public class DayDifferenceCalculator {
	public int getDaysBetweenTwoFirstNames(Person firstPerson, Person secondPerson) {
		return Days.daysBetween(firstPerson.getBirthDate(), secondPerson.getBirthDate()).getDays();
	}

}
