package com.bosch.writefile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriter {

	private static String[] columns = { "Name", "Kind", "Area" };
	private static List<Shape> shapes = new ArrayList<Shape>();

	public static void writeExcel() throws IOException {
//		shapes.add(new Circle("Circle1", 10));
//		shapes.add(new Square("Square2", 5));
//		// sort the shapes based on area
//		Collections.sort(shapes, (o1, o2) -> Double.compare(o1.calculateArea(), o2.calculateArea()));
//		workbook workbook = new XSSFWorkbook();
//		Sheet sheet = workbook.createSheet("Shapes");
//
//		// header row
//		Row headerRow = sheet.createRow(0);
//		for (int i = 0; i < columns.length; i++) {
//			Cell cell = headerRow.createCell(i);
//			cell.setCellValue(columns[i]);
//		}
//
//		// data rows
//		int rowNum = 1;
//		for (Shape shape : shapes) {
//			Row row = sheet.createRow(rowNum++);
//			row.createCell(0).setCellValue(shape.getName());
//			row.createCell(1).setCellValue(shape.getKind());
//			row.createCell(2).setCellValue(shape.calculateArea());
//		}
//
//		try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\output.xlsx")) {
//			workbook.write(outputStream);
//		}
	}
}