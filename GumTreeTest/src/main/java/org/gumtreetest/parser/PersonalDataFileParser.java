package org.gumtreetest.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.gumtreetest.model.PeopleGroup;
import org.gumtreetest.model.Person;

public class PersonalDataFileParser {
	public PeopleGroup parseAddressBook() throws IOException {
		PeopleGroup people = new PeopleGroup();
		String fileName = "temp.txt";
		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
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
		return null;
	}
}
