package writteFileCode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OutputFileCreator {
	public static void main(String[] args) {
		try {
			String inputFilename = "input.txt";
			String outputFilename = "output.xlsx";
			BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Sheet1");

			List<String> lines = new ArrayList<String>();
			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(",");
				String name = tokens[0].trim();
				String kind = tokens[1].trim();
				double area = Double.parseDouble(tokens[2].trim());
				Shape shape = null;
				if (kind.equalsIgnoreCase("circle")) {
					shape = new Circle(name, Math.sqrt(area / Math.PI));
				} else if (kind.equalsIgnoreCase("square")) {
					shape = new Square(name, Math.sqrt(area));
				}
				if (shape != null) {
					lines.add(shape.toString());
				}
			}
			reader.close();
			Collections.sort(lines, new Comparator<String>() {
				public int compare(String s1, String s2) {
					double area1 = Double.parseDouble(s1.substring(s1.lastIndexOf(" ") + 1, s1.length() - 1));
					double area2 = Double.parseDouble(s2.substring(s2.lastIndexOf(" ") + 1, s2.length() - 1));
					if (area1 < area2) {
						return -1;
					} else if (area1 > area2) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			int rownum = 0;
			for (String s : lines) {
				Row row = sheet.createRow(rownum++);
				Cell cell = row.createCell(0);
				cell.setCellValue(s);
			}
			FileOutputStream outputStream = new FileOutputStream(outputFilename);
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
			System.out.println("Output file created successfully.");
		} catch (FileNotFoundException ex) {
			System.err.println("Input file not found.");
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NumberFormatException ex) {
			System.err.println("Invalid input format.");
		}
	}
}
