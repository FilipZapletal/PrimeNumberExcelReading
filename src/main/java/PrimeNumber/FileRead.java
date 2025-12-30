package PrimeNumber;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileRead {
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
        String filePath = "C:\\Users\\TIGO\\Desktop\\Programování\\Projects\\FilesForExtractingInfo\\vzorek_dat.xlsx";
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        Workbook workbook = new XSSFWorkbook(fis);

        Sheet List1 = workbook.getSheet("List1");

        int last = List1.getLastRowNum();

        for (int r = 0; r <= last; r++) {
            Row row = List1.getRow(r);
            if (row == null) {
                continue;
            }


            Cell cellb = row.getCell(1);

            if (cellb == null) {
                continue;
            }

            if (cellb.getCellType() == CellType.NUMERIC){
                int value = (int) cellb.getNumericCellValue();
                if (isPrime(value)) {
                    System.out.println(value);
                }
            }

            if (cellb.getCellType() == CellType.STRING){
                try {
                    int value = Integer.parseInt(cellb.getStringCellValue().trim());
                    if (isPrime(value)) {
                        System.out.println(value);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Cannot parse to integer: " + cellb.getStringCellValue());
                    continue;
                }

            }

        }


    }
}
