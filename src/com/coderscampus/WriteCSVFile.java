package com.coderscampus;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class WriteCSVFile {
	public void writeCSVFile(List<String[]> data, String filename) {
	    try (PrintWriter pw = new PrintWriter(new File(filename))) {
	        // Print the column names
	        pw.println("Student ID    Student Name  	      Course  	Grade");

	        // Print a line of dashes to separate the column names from the data
	        pw.println("------------  ------------  	      ------  	-----");

	        // Iterate over the elements of the data list
	        for (String[] record : data) {
	            // Print the elements of the record array with left alignment
	            pw.printf("%-12s  %-20s  %-12s  %-12s%n", record[0], record[1], record[2], record[3]);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
