package com.coderscampus;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteCSVFile {
	public void writeCSVFile(List<String[]> data, String filename) {
	    try (PrintWriter pw = new PrintWriter(new File(filename))) {
	        // Print the column names
	        pw.println("Student ID,    Student Name,  	      Course,  	Grade");

	        // Print a line of dashes to separate the column names from the data
	        pw.println("------------,  ------------,  	      ------------,  	---------------");

	        // Iterate over the elements of the data list
	        for (String[] student : data) {
	            // Print the elements of the record array with left alignment
	            pw.println(student[0] + ", " + student[1] + ", " + student[2] + ", " + student[3]);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
