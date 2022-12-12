package com.coderscampus;

import java.util.ArrayList;
import java.util.List;
public class RunMe {
	
	public static void main(String[] args) {
		new RunMe().execute();

	}

	private void execute() {
		// Read the data file and store it in a List of String arrays
		ReadDataFile dataReader = new ReadDataFile();
		List<String[]> data = dataReader.readDataFile("student-master-list.csv");

		// Create three lists to store the students for each course
		List<String[]> compSci = new ArrayList<>();
		List<String[]> stat = new ArrayList<>();
		List<String[]> apMth = new ArrayList<>();

		// Loop through the data and add each student to the appropriate course list
		for (String[] student : data) {
			if (student[2].contains("COMPSCI")) {
				compSci.add(student);
			} else if (student[2].contains("STAT")) {
				stat.add(student);
			} else if (student[2].contains("APMTH")) {
				apMth.add(student);
			}
		}

		// Sort each course's list of students by grade in descending order
		compSci.sort((s1, s2) -> Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3])));
		stat.sort((s1, s2) -> Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3])));
		apMth.sort((s1, s2) -> Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3])));

		// Write the sorted students for each course to a separate CSV file
		WriteCSVFile fileWriter = new WriteCSVFile();
		fileWriter.writeCSVFile(compSci, "course1.csv");
		fileWriter.writeCSVFile(stat, "course2.csv");
		fileWriter.writeCSVFile(apMth, "course3.csv");
	}

}
