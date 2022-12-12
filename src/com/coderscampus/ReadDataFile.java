package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFile {
	public List<String[]> readDataFile(String filename) {
	    List<String[]> data = new ArrayList<>();
	    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
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

}

