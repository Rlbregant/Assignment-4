package com.coderscampus;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class WriteCSVFile {
	public void writeCSVFile(List<String[]> data, String filename) {
	    try (PrintWriter pw = new PrintWriter(new File(filename))) {
	        pw.print("Student ID,Student Name,Course,Grade" + System.lineSeparator());
	        data.stream().map(Arrays::toString).forEach(pw::println);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
