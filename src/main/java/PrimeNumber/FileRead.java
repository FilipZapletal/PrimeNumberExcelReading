package PrimeNumber;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileRead {
    private static final Logger logger = LoggerFactory.getLogger(FileRead.class);

    public static void processFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        Workbook workbook = new XSSFWorkbook(fis);

        Sheet List1 = workbook.getSheetAt(0);

        int last = List1.getLastRowNum();

        for (int r = 0; r <= last; r++) {
            Row row = List1.getRow(r);
            if (row == null) {
                continue;
            }
            processRow(row);
        }
    }

    public static void processRow(Row row) {
        Cell cellb = row.getCell(1);

        if (cellb == null) {
            return;
        }

        if (cellb.getCellType() == CellType.NUMERIC){
            int value = (int) cellb.getNumericCellValue();
            if (isPrime(value)) {
                logger.info(String.valueOf(value));
            }
        }

        if (cellb.getCellType() == CellType.STRING){
            try {
                int value = Integer.parseInt(cellb.getStringCellValue().trim());
                if (isPrime(value)) {
                    logger.info(String.valueOf(value));
                }
            } catch (NumberFormatException e) {
                // případné kontrolní hlášení pro nečíselné hodnoty
                //logger.info("Nelze konvertovat na integer (data nejsou číselné): {}", cellb.getStringCellValue());
            }

        }

    }

    public static boolean isPrime(int number){
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String filePath;

        if (args.length > 0) {
            filePath = args[0];
        } else {
            filePath = ".\\vzorek_dat.xlsx";
        }

        processFile(filePath);


    }
}
