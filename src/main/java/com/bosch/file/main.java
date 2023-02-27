package com.bosch.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main {

	public static void readFile(String path) {
		Map<String, String> shapeMap = new HashMap<String, String>();

		try {
			File fileName = new File(path);
			if (!fileName.exists()) {
				fileName.createNewFile();
			}
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bfr = new BufferedReader(fileReader);

			String line = bfr.readLine();
			while (line != null) {
				//solution one
				if (line.matches("(Circle),(.*),(radius)=(\\d+\\.?\\d?)")) {
					System.out.println(line);
				} else if (line.matches("(Square),(.*),(edge)=(\\d+\\.?\\d?)")) {
					System.out.println(line);
				}
				String[] lineItems = line.split(",");
				//solution two
//				if (lineItems.length == 3 && lineItems[2].contains("=")) {
//					String shapeType = lineItems[0];
//					String shapeName = lineItems[1];
//					String attributeName = lineItems[2].split("=")[0];
//					String attributeValue = lineItems[2].split("=")[1];
//					if ((shapeType.equals("Circle") && attributeName.equals("radius") && !attributeValue.isEmpty())
//							|| (shapeType.equals("Square") && attributeName.equals("edge")
//									&& !attributeValue.isEmpty())) {
//						if (isNumeric(attributeValue)) {
//							shapeMap.put(attributeName, attributeValue);
//						}
//						System.out.println(line);
//					} else {
//						line = bfr.readLine();
//					}
//
//				}

				line = bfr.readLine();
			}
			fileReader.close();
			bfr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Check if a string is a number
	public static boolean isNumeric(String strNum) {
		try {
			double d = Double.parseDouble(strNum);
		} catch (Exception nfe) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		readFile("test.txt");
	}
}
