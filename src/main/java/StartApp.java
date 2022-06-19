import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static org.apache.poi.ss.usermodel.CellType.STRING;

public class StartApp {
    public static void main(String[] args) {
        FileInputStream file = loadFile();
        processing(file);
    }

    private static void processing(FileInputStream file) {
        try {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("Задачи");

            /*String endDate = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
            String startDate = new SimpleDateFormat("dd.MM.yyyy").format(LocalDate.now().minusDays(8));*/

            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd.MM");
            LocalDate date1 = LocalDate.now().minusDays(8);
            LocalDate date2 = LocalDate.now().minusDays(1);
            String startDate = date1.format(formatters);
            String endDate = date2.format(formatters);
            System.out.println();

            System.out.println("Овертайм НПР " + startDate + " - " + endDate);
            System.out.println("Доброе утро.");
            System.out.println("");
            System.out.println("Прошу подтвердить переработки команды НПР в период с " + startDate + " - " + endDate);
            System.out.println("");

            for (Row row : sheet) {
                if (!row.getCell(0).getStringCellValue().isEmpty()) {
                    if (row.getCell(0).getCellType() == STRING
                            && !row.getCell(1).getStringCellValue().isEmpty()) {
                        System.out.println(row.getCell(0).getStringCellValue());
                    }
                    if (row.getCell(1).getCellType() == STRING) {
                        System.out.println(row.getCell(1).getStringCellValue());
                        System.out.println("");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static FileInputStream loadFile() {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File("src/main/resources/11.xlsx"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }
}
