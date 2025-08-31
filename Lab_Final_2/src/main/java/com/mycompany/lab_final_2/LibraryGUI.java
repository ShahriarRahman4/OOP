package com.mycompany.lab_final_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;

public class LibraryGUI extends JFrame {

    private LibraryCatalog catalog;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTextArea resultArea;

    public LibraryGUI() {
        catalog = new LibraryCatalog();
        LibraryApp.loadSampleBooks(catalog);

        initializeGUI();

        catalog.setOutputArea(resultArea);
    }

    private void initializeGUI() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        resultArea.setTabSize(8);
        resultArea.setMargin(new Insets(10, 10, 10, 10));

        mainPanel.add(createWelcomePanel(), "WELCOME");
        mainPanel.add(createMainMenuPanel(), "MENU");
        mainPanel.add(createAddBookPanel(), "ADD_BOOK");
        mainPanel.add(createSearchPanel("Title"), "SEARCH_TITLE");
        mainPanel.add(createSearchPanel("Author"), "SEARCH_AUTHOR");
        mainPanel.add(createSearchPanel("Genre"), "SEARCH_GENRE");
        mainPanel.add(createBorrowReturnPanel("Borrow"), "BORROW");
        mainPanel.add(createBorrowReturnPanel("Return"), "RETURN");
        mainPanel.add(createShowAllPanel(), "SHOW_ALL");
        mainPanel.add(createTopBorrowedPanel(), "TOP_BORROWED");
        mainPanel.add(createLoadFilePanel(), "LOAD_FILE");

        add(mainPanel);
        showWelcomeScreen();
    }

    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Welcome to Library Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(25, 25, 112));

        JButton enterButton = createStyledButton("ENTER");
        enterButton.setFont(new Font("Arial", Font.BOLD, 18));
        enterButton.setPreferredSize(new Dimension(150, 50));
        enterButton.addActionListener(e -> showMainMenu());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.add(enterButton);

        panel.add(titleLabel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createMainMenuPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setBackground(new Color(245, 245, 245));

        String[] buttons = {
            "Add Book", "Search by Title", "Search by Author", "Search by Genre",
            "Borrow Book", "Return Book", "Show All Books", "Show Top Borrowed",
            "Load from File", "Exit"
        };

        for (String text : buttons) {
            JButton button = createStyledButton(text);
            button.addActionListener(e -> handleMenuAction(text));
            panel.add(button);
        }

        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text) {

            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(new Color(50, 100, 150));
                } else if (getModel().isRollover()) {
                    g.setColor(new Color(100, 150, 200));
                } else {
                    g.setColor(new Color(70, 130, 180));
                }
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(Color.WHITE);
                FontMetrics fm = g.getFontMetrics();
                int textX = (getWidth() - fm.stringWidth(getText())) / 2;
                int textY = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g.drawString(getText(), textX, textY);
            }
        };

        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(false);

        return button;
    }

    private void handleMenuAction(String action) {
        switch (action) {
            case "Add Book":
                showPanel("ADD_BOOK");
                break;
            case "Search by Title":
                showPanel("SEARCH_TITLE");
                break;
            case "Search by Author":
                showPanel("SEARCH_AUTHOR");
                break;
            case "Search by Genre":
                showPanel("SEARCH_GENRE");
                break;
            case "Borrow Book":
                showPanel("BORROW");
                break;
            case "Return Book":
                showPanel("RETURN");
                break;
            case "Show All Books":
                showAllBooks();
                break;
            case "Show Top Borrowed":
                showPanel("TOP_BORROWED");
                break;
            case "Load from File":
                showPanel("LOAD_FILE");
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    private JPanel createAddBookPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 245));

        JTextField isbnField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField genreField = new JTextField();
        JTextField copiesField = new JTextField();

        panel.add(new JLabel("ISBN:"));
        panel.add(isbnField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("Genre:"));
        panel.add(genreField);
        panel.add(new JLabel("Copies:"));
        panel.add(copiesField);

        JButton addButton = createStyledButton("Add Book");
        JButton backButton = createStyledButton("Back");

        addButton.addActionListener(e -> {
            try {
                String isbn = isbnField.getText();
                String title = titleField.getText();
                String author = authorField.getText();
                String genre = genreField.getText();
                int copies = Integer.parseInt(copiesField.getText());

                if (isbn.isEmpty() || title.isEmpty() || author.isEmpty() || genre.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all fields!");
                    return;
                }

                catalog.addBook(new Book(isbn, title, author, genre, copies));
                JOptionPane.showMessageDialog(this, "Book added successfully!");

                isbnField.setText("");
                titleField.setText("");
                authorField.setText("");
                genreField.setText("");
                copiesField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for copies!");
            }
        });

        backButton.addActionListener(e -> showMainMenu());

        panel.add(addButton);
        panel.add(backButton);

        return panel;
    }

    private JPanel createSearchPanel(String type) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 245));

        JTextField searchField = new JTextField();
        JTextArea localResultArea = new JTextArea();
        localResultArea.setEditable(false);
        localResultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        localResultArea.setTabSize(8);
        localResultArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(localResultArea);

        JButton searchButton = createStyledButton("Search " + type);
        JButton backButton = createStyledButton("Back");

        searchButton.addActionListener(e -> {
            String query = searchField.getText().trim();
            if (query.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a search term!");
                return;
            }

            localResultArea.setText("");

            catalog.setOutputArea(localResultArea);
            switch (type) {
                case "Title":
                    catalog.searchByTitle(query);
                    break;
                case "Author":
                    catalog.searchByAuthor(query);
                    break;
                case "Genre":
                    catalog.searchByGenre(query);
                    break;
            }

            catalog.setOutputArea(resultArea);
        });

        backButton.addActionListener(e -> showMainMenu());

        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.add(new JLabel("Enter " + type + ":"), BorderLayout.WEST);
        inputPanel.add(searchField, BorderLayout.CENTER);
        inputPanel.add(searchButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createBorrowReturnPanel(String action) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 245));

        JTextField isbnField = new JTextField();
        JTextArea localResultArea = new JTextArea();
        localResultArea.setEditable(false);
        localResultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        localResultArea.setTabSize(8);
        localResultArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(localResultArea);

        JButton actionButton = createStyledButton(action + " Book");
        JButton backButton = createStyledButton("Back");

        actionButton.addActionListener(e -> {
            String isbn = isbnField.getText().trim();
            if (isbn.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter ISBN!");
                return;
            }

            localResultArea.setText("");

            catalog.setOutputArea(localResultArea);
            if (action.equals("Borrow")) {
                catalog.borrowBook(isbn);
            } else {
                catalog.returnBook(isbn);
            }

            catalog.setOutputArea(resultArea);
        });

        backButton.addActionListener(e -> showMainMenu());

        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.add(new JLabel("Enter ISBN:"), BorderLayout.WEST);
        inputPanel.add(isbnField, BorderLayout.CENTER);
        inputPanel.add(actionButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createShowAllPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 245));

        JTextArea localResultArea = new JTextArea();
        localResultArea.setEditable(false);
        localResultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        localResultArea.setTabSize(8);
        localResultArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(localResultArea);

        JButton refreshButton = createStyledButton("Refresh");
        JButton backButton = createStyledButton("Back");

        refreshButton.addActionListener(e -> {
            localResultArea.setText("");

            catalog.setOutputArea(localResultArea);
            catalog.showAllBooks();

            catalog.setOutputArea(resultArea);
        });

        backButton.addActionListener(e -> showMainMenu());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(refreshButton);
        buttonPanel.add(backButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createTopBorrowedPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 245));

        JTextField numberField = new JTextField("5");
        JTextArea localResultArea = new JTextArea();
        localResultArea.setEditable(false);
        localResultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        localResultArea.setTabSize(8);
        localResultArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(localResultArea);

        JButton showButton = createStyledButton("Show Top");
        JButton backButton = createStyledButton("Back");

        showButton.addActionListener(e -> {
            try {
                int topN = Integer.parseInt(numberField.getText());
                localResultArea.setText("");

                catalog.setOutputArea(localResultArea);
                catalog.showTopBorrowed(topN);

                catalog.setOutputArea(resultArea);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number!");
            }
        });

        backButton.addActionListener(e -> showMainMenu());

        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.add(new JLabel("Number of top books:"), BorderLayout.WEST);
        inputPanel.add(numberField, BorderLayout.CENTER);
        inputPanel.add(showButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createLoadFilePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 245));

        JTextField filePathField = new JTextField();
        JButton browseButton = createStyledButton("Browse");
        JButton loadButton = createStyledButton("Load File");
        JButton backButton = createStyledButton("Back");

        JTextArea localResultArea = new JTextArea();
        localResultArea.setEditable(false);
        localResultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        localResultArea.setTabSize(8);
        localResultArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(localResultArea);

        browseButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                filePathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        loadButton.addActionListener(e -> {
            String filePath = filePathField.getText().trim();
            if (filePath.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a file!");
                return;
            }

            localResultArea.setText("");

            catalog.setOutputArea(localResultArea);

            FileDataLoader fileLoader = new FileDataLoader(filePath);
            fileLoader.connect();
            List<Book> loadedBooks = fileLoader.loadBooks();

            if (!loadedBooks.isEmpty()) {
                for (Book book : loadedBooks) {
                    catalog.addBook(book);
                }
                JOptionPane.showMessageDialog(this, "Successfully loaded " + loadedBooks.size() + " books!");
            } else {
                JOptionPane.showMessageDialog(this, "No books were loaded from the file.");
            }
            fileLoader.disconnect();

            catalog.setOutputArea(resultArea);
        });

        backButton.addActionListener(e -> showMainMenu());

        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.add(new JLabel("File Path:"), BorderLayout.WEST);
        inputPanel.add(filePathField, BorderLayout.CENTER);
        inputPanel.add(browseButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadButton);
        buttonPanel.add(backButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void showWelcomeScreen() {
        cardLayout.show(mainPanel, "WELCOME");
    }

    private void showMainMenu() {
        cardLayout.show(mainPanel, "MENU");
    }

    private void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    private void showAllBooks() {
        catalog.setOutputArea(resultArea);
        catalog.showAllBooks();
        showPanel("SHOW_ALL");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            LibraryGUI gui = new LibraryGUI();
            gui.setVisible(true);
        });
    }
}
