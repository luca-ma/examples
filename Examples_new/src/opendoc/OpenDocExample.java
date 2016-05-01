package opendoc;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class OpenDocExample {

	public void readODS(File file) {
		Sheet sheet;
		Boolean foundHeaderRow = false;
		Integer nameHeaderColumn = 0;
		try {
			// Getting the 0th sheet for manipulation| pass sheet name as string
			sheet = SpreadSheet.createFromFile(file).getSheet(0);

			// Get row count and column count
			int nColCount = sheet.getColumnCount();
			int nRowCount = sheet.getRowCount();

			System.out.println("Rows :" + nRowCount);
			System.out.println("Cols :" + nColCount);
			// Iterating through each row of the selected sheet
			MutableCell cell = null;
			for (int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++) {
				// Iterating through each column
				int nColIndex = 0;
				for (; nColIndex < nColCount; nColIndex++) {
					cell = sheet.getCellAt(nColIndex, nRowIndex);
					if (!foundHeaderRow) {
						if (cell.getValue().toString().equals("nome")) {
							// System.out.println(cell.getValue() + " ");
							System.out.print("found header row, index:"
									+ nColIndex);
							foundHeaderRow = true;
							nameHeaderColumn = nColIndex;
							break;
						}
					} else {
						if (nColIndex == 1) {
							String name = cell.getValue().toString();
							if (!name.equals("")) {
								System.out.println(name);
								String[] split = name.split(" ");
								StringBuilder str = new StringBuilder(split[0]
										+ "." + split[1] + "@a.b.it");
								System.out.println(str);
							}
						}
					}

				}
				// System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Creating File object of .ods file
		// File file = new File("D:\\TestData\\test.ods");
		File file = new File("D:\\Maderna\\luca\\dropbox\\Dropbox\\reg.ods");

		// D:\Maderna\luca\dropbox\Dropbox
		OpenDocExample objODSReader = new OpenDocExample();
		objODSReader.readODS(file);
	}

}
