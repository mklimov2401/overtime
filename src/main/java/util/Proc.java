package util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.apache.poi.ss.usermodel.CellType.STRING;

public class Proc {

    public static void processing(FileInputStream file) {
        headerMessage();
        try {
            Sheet sheet = new XSSFWorkbook(file).getSheet("Задачи");
            for (Row row : sheet) {
                if (!row.getCell(0).getStringCellValue().isEmpty()) {
                    if (row.getCell(0).getCellType() == STRING
                            && !row.getCell(1).getStringCellValue().isEmpty()) {
                        System.out.println(row.getCell(0).getStringCellValue());
                    }
                    if (row.getCell(1).getCellType() == STRING) {
                        System.out.println(row.getCell(1).getStringCellValue().trim());
                        System.out.println("");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void headerMessage() {
        System.out.println("Овертайм НПР " + Helper.getDateMinus(1)
                + " - " + Helper.getDateMinus(7));
        System.out.println("Доброе утро.");
        System.out.println("");
        System.out.println("Прошу подтвердить переработки команды НПР в период с "
                + Helper.getDateMinus(1) + " - " + Helper.getDateMinus(7));
        System.out.println("");
    }

    /**
     * Метод для загрузки файла xlsx
     * @return
     */
    public static FileInputStream loadFile() {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File("22.xlsx"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }
}
