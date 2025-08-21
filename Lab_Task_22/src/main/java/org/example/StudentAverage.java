

import java.io.*;

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class StudentAverage {

    public static void main(String[] args) {
        // Get the current directory path
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDir);

        // Use ./ to explicitly indicate current directory
        String inputFile = "./input.txt";
        String outputFile = "./output.txt";

        // Check if input file exists
        File file = new File(inputFile);
        if (!file.exists()) {
            System.err.println("Input file not found at: " + file.getAbsolutePath());
            System.err.println("Please make sure input.txt is in the same directory as the Java file");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(" ");
                    String name = parts[0];
                    int num1 = Integer.parseInt(parts[1]);
                    int num2 = Integer.parseInt(parts[2]);
                    int num3 = Integer.parseInt(parts[3]);

                    if (num1 < 0 || num2 < 0 || num3 < 0) {
                        throw new NegativeNumberException("Negative numbers are not allowed for student: " + name);
                    }

                    double average = (num1 + num2 + num3) / 3.0;
                    writer.write(name + ": " + String.format("%.2f", average));
                    writer.newLine();
                } catch (NegativeNumberException e) {
                    System.err.println("Skipping student - " + e.getMessage());
                    writer.write("Error: " + e.getMessage());
                    writer.newLine();
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in line: " + line);
                    writer.write("Error: Invalid number format for student data");
                    writer.newLine();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Insufficient data in line: " + line);
                    writer.write("Error: Insufficient data for student");
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
            System.out.println("Processing completed. Output written to: " + outputFile);
            System.out.println("Full output path: " + new File(outputFile).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("IO error: " + e.getMessage());
        }
    }
}