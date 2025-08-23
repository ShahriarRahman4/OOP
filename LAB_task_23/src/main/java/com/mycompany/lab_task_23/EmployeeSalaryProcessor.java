
package com.mycompany.lab_task_23;

import java.io.*;
import java.util.*;

public class EmployeeSalaryProcessor {
    
    public static void main(String[] args) {
        try {
            processEmployeeSalaries("employees.txt", "averages.txt");
            System.out.println("Successfully processed employee salaries!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (NegativeNumberException e) {
            System.out.println("Error: Negative salary found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: IO Exception - " + e.getMessage());
        }
    }
    
    public static void processEmployeeSalaries(String inputFile, String outputFile) 
            throws FileNotFoundException, NegativeNumberException, IOException {
        
        Map<String, List<Double>> employeeSalaries = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    continue;
                }
                
                String name = parts[0].trim();
                double salary1 = Double.parseDouble(parts[1].trim());
                double salary2 = Double.parseDouble(parts[2].trim());
                double salary3 = Double.parseDouble(parts[3].trim());
                
                if (salary1 < 0 || salary2 < 0 || salary3 < 0) {
                    throw new NegativeNumberException("Negative salary found for employee: " + name);
                }
                
                if (!employeeSalaries.containsKey(name)) {
                    employeeSalaries.put(name, new ArrayList<>());
                }
                employeeSalaries.get(name).add(salary1);
                employeeSalaries.get(name).add(salary2);
                employeeSalaries.get(name).add(salary3);
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, List<Double>> entry : employeeSalaries.entrySet()) {
                String name = entry.getKey();
                List<Double> salaries = entry.getValue();
                
                double sum = 0;
                for (double salary : salaries) {
                    sum += salary;
                }
                double average = sum / salaries.size();
                
                writer.write(name + "," + String.format("%.2f", average));
                writer.newLine();
            }
        }
    }
}