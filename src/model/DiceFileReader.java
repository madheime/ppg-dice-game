package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
import java.util.Iterator;
//import java.util.List;
//import java.util.Map;

import model.DiceGame;
import model.Die;
import model.Face;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class is used to read input files and build neural network based on
 * input files.
 */
public class DiceFileReader {

	private static final org.apache.logging.log4j.Logger LOG = LogManager
			.getLogger(DiceFileReader.class);

	private String path;
	private DiceGame diceGame;

	/**
	 * builds a neural network by reading files
	 * 
	 * @param fileName
	 *            name of the excel workbook that has all information to build a
	 *            network
	 * @param diceGame
	 *            diceGame instance that gets built
	 */
	// @SuppressWarnings("resource")
	public DiceFileReader(String fileName, DiceGame diceGame) {
		path = this.getClass().getClassLoader().getResource(fileName).getFile();
		this.diceGame = diceGame;
	}

	/**
	 * builds a map of gas id against gas object by reading excel sheet
	 * 
	 * @param sheet
	 *            Excel sheet that contains information of faces
	 */
	public void readDiceFaces() {

		InputStream fis = null;
		try {
			fis = new FileInputStream(path);

			// Using XSSF for xlsx format, for xls use HSSF
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			// iterating over each row
			while (rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();

				// Read first row differently because it contains headers
				// TODO: verify column names.
				if (row.getRowNum() == 0)
					continue;

				Iterator<Cell> cellIterator = row.cellIterator();
				String curr_die_id = "0";
				Colors face_color = Colors.RED;
				Numbers face_value = Numbers.ONE;

				// Iterating over each cell in a particular row.
				while (cellIterator.hasNext()) {
					Cell cell = (Cell) cellIterator.next();

					switch (cell.getColumnIndex()) {
					// die id
					case 0:
						curr_die_id = Double.toString(cell.getNumericCellValue());
						break;
					// face color
					case 1:
						face_color = Colors.valueOf(cell.getStringCellValue());
						break;
					// face value
					case 2:
						face_value = Numbers.valueOf(cell.getStringCellValue());
						break;
					default:
						LOG.error("Tried to read past the end of the row!");
						break;
					}
				}

				// Check whether this die exists yet
				if (diceGame.getDice().get(curr_die_id) == null) {
					ArrayList<Face> face_array = new ArrayList<Face>();
					face_array.add(new Face(face_color, face_value));
					diceGame.getDice().put(curr_die_id, new Die(curr_die_id, face_array));
				} else {
					diceGame.getDice().get(curr_die_id).addFace(
							new Face(face_color, face_value));
				}

			}

			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


