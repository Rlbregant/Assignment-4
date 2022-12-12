package com.coderscampus;

import java.io.*;
import java.util.*;

public class CSVFileParser {

	public static void main(String[] args) {
		// Read the data file and store it in a List of String arrays
		List<String[]> data = readDataFile("student-master-list.csv");

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
		writeCSVFile(compSci, "course1.csv");
		writeCSVFile(stat, "course2.csv");
		writeCSVFile(apMth, "course3.csv");
	}

	// Method to read the data file and return it as a List of String arrays
	public static List<String[]> readDataFile(String filename) {
		List<String[]> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("student-master-list.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				data.add(values);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	// Method to write a List of String arrays to a CSV file
	public static void writeCSVFile(List<String[]> data, String filename) {
		try (PrintWriter pw = new PrintWriter(new File(filename))) {
			data.forEach(pw::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
