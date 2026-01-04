# Prime Number Finder

Java application that reads numbers from an Excel file and identifies prime numbers.

## How to Build

mvn clean install

## How to Run

### Option 1: Using Maven exec plugin

mvn exec:java

To use a custom Excel file:

mvn exec:java -Dexec.args="path to your file"

### Option 2: Using JAR file
After building, run:

java -jar target/PrimeNumberFileRead-1.0-SNAPSHOT.jar vzorek_dat.xlsx

Or with custom file:

java -jar target/PrimeNumberFileRead-1.0-SNAPSHOT.jar path/to/your/file

## Running Tests

mvn test

## Project Structure
- `src/main/java/PrimeNumber/Main.java` - Entry point
- `src/main/java/PrimeNumber/FileRead.java` - Excel processing and prime checking logic
- `vzorek_dat.xlsx` - Sample data file

## Excel File Format
- Data should be in column B of the first sheet
- Valid data: positive whole numbers
- Invalid data (text, negative numbers) will be ignored
