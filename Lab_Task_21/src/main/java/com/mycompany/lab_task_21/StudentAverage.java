package com.mycompany.lab_task_21;

import java.io.*;

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class StudentAverage {

    public static void main(String[] args) {
        try {
            
            String projectRoot = System.getProperty("user.dir");
            
            System.out.println("Project root: " + projectRoot);
            
            // Look for input.txt in the project root
            String inputPath = projectRoot + File.separator + "input.txt";
            String outputPath = projectRoot + File.separator + "output.txt";
            
            System.out.println("Looking for input.txt at: " + inputPath);
            
            if (!new File(inputPath).exists()) {
                System.err.println("input.txt not found at: " + inputPath);
                System.err.println("Please place input.txt in your project root directory:");
                System.err.println(projectRoot);
                return;
            }
            
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
            
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
            System.out.println("Processing completed. Output written to: " + outputPath);
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}