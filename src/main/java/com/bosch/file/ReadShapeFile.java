package com.bosch.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadShapeFile {
	public static void main(String[] args) {
		String fileName = "test.txt";
		String line;

		// Create a map of shape name and its attribute
		Map<String, String> shapeMap = new HashMap<String, String>();

		try {
			// Open the file
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// Read each line in the file
			while ((line = bufferedReader.readLine()) != null) {
				// Extract the info from each line according to the given format
				String[] lineItems = line.split(",");

				// Check if the line follows the given format
				if (lineItems.length == 3 && lineItems[2].contains("=")) {
					String shapeType = lineItems[0];
					String shapeName = lineItems[1];
					String attributeName = lineItems[2].split("=")[0];
					System.out.println(attributeName);
					String attributeValue = lineItems[2].split("=")[1];
					System.out.println(attributeValue);
					System.out.println(shapeType + "-" + shapeName + "-" + attributeName + "-" + attributeValue);
					if ((shapeType.equals("Circle") && attributeName.equals("radius"))
							|| (shapeType.equals("Square") && attributeName.equals("edge"))) {
						// Check if the value is a number
						if (isNumeric(attributeValue)) {
							// Put the shape name and its attribute to the map
							shapeMap.put(shapeName, attributeValue);
						}
					}
				}
			}
			// Close the file
			bufferedReader.close();

			// Print out the map
			System.out.println("Shape Map: ");
			for (Map.Entry<String, String> entry : shapeMap.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}

		} catch (IOException e) {
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
}