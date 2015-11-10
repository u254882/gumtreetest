package org.gumtreetest.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.gumtreetest.model.FullName;
import org.gumtreetest.model.Gender;
import org.gumtreetest.model.PeopleGroup;
import org.gumtreetest.model.Person;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class PersonalDataFileParser {
	public PeopleGroup parseAddressBook() throws IOException {
		PeopleGroup people = new PeopleGroup();
		String fileName = "src/main/resources/personaldata/AddressBook";
		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				people.getPeople().add(parseLine(line));
			}

			bufferedReader.close();
		} catch (FileNotFoundException ffnex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
		return people;
	}

	private Person parseLine(String line) {
		Person person = new Person();
		List<String> list = Arrays.asList(line.split(","));
		// these numbers should be constants for a changing format, no time now
		person.setFullName(parseFullName(list.get(0)));
		person.setGender(parseGender(list.get(1)));
		person.setBirthDate(parseDate(list.get(2)));
		return person;
	}

	private FullName parseFullName(String token) {
		FullName fullName = new FullName();
		fullName.setFirstName(token.split(" ")[0].trim());
		fullName.setSurName(token.split(" ")[0].trim());
		return fullName;
	}

	private DateTime parseDate(String token) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");
		return formatter.parseDateTime(token.trim());
	}

	private Gender parseGender(String token) {

		if (Gender.FEMALE.getGenderString().equals(token.trim())) {
			return Gender.FEMALE;
		}
		if (Gender.MALE.getGenderString().equals(token.trim())) {
			return Gender.MALE;
		}
		return Gender.UNKNOWN;
	}
}
