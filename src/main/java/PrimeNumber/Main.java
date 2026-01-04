package PrimeNumber;

import java.io.IOException;

import static PrimeNumber.FileRead.processFile;

public class Main {
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
