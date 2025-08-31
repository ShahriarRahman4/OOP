package com.mycompany.lab_final;

;

import java.io.*;
import java.util.*;



public class FileDataLoader extends AbstractDataLoader {

    private String filePath;

    public FileDataLoader(String filePath) {
        this.filePath = filePath;
    }

   
    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        if (!isConnected()) {
            System.out.println("Data source not connected!");
            return books;
        }

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return books;
        }

        if (!file.canRead()) {
            System.out.println("Cannot read file. Access denied: " + filePath);
            System.out.println("Please check file permissions or try a different file.");
            return books;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                lineCount++;

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String isbn = parts[0].trim();
                        String title = parts[1].trim();
                        String author = parts[2].trim();
                        String genre = parts[3].trim();
                        int copies = Integer.parseInt(parts[4].trim());
                        books.add(new Book(isbn, title, author, genre, copies));
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing number on line " + lineCount + ": " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid format on line " + lineCount + ". Expected 5 values separated by commas.");
                    System.out.println("Line content: " + line);
                }
            }
            System.out.println("Successfully loaded " + books.size() + " books from file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return books;
    }
}
