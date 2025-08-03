package com.mycompany.universitymanagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UniversityManagementGUI extends JFrame {
    private StudentManager studentManager;
    private CourseManager courseManager;
    private EnrollmentManager enrollmentManager;
    private JTable studentTable;
    private JTable courseTable;
    private JTable enrollmentTable;

    public UniversityManagementGUI() {
        // Initialize managers
        studentManager = new StudentManager();
        courseManager = new CourseManager();
        enrollmentManager = new EnrollmentManager(studentManager, courseManager);

        // Window setup
        setTitle("University Management System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Apply system look and feel with enhancements
        initLookAndFeel();

        // Add components
        createMenuBar();
        createMainTabs();

        setVisible(true);
    }

    private void initLookAndFeel() {
        try {
            // Try to set Nimbus look and feel (more modern than system default)
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            // Custom UI defaults
            UIManager.put("nimbusBase", new Color(70, 130, 180));
            UIManager.put("nimbusBlueGrey", new Color(150, 190, 230));
            UIManager.put("control", new Color(240, 240, 240));
        } catch (Exception e) {
            try {
                // Fallback to system look and feel
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Show splash screen
            showSplashScreen();
            new UniversityManagementGUI();
        });
    }

    private static void showSplashScreen() {
        JWindow splash = new JWindow();
        JLabel splashLabel = new JLabel(new ImageIcon("splash.png"));
        splashLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        splash.getContentPane().add(splashLabel);
        splash.pack();
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);

        new Timer(2000, e -> {
            splash.dispose();
            ((Timer)e.getSource()).stop();
        }).start();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
        aboutItem.addActionListener(e -> showAboutDialog());
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    private void showAboutDialog() {
        JLabel aboutLabel = new JLabel(
                "<html><center><h2>University Management System</h2>" +
                        "<p>Version 2.0</p>" +
                        "<p>Developed using Java Swing</p></center></html>"
        );
        aboutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JOptionPane.showMessageDialog(this, aboutLabel, "About", JOptionPane.PLAIN_MESSAGE);
    }

    private void createMainTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Create tabs with icons from UIManager
        tabbedPane.addTab("Students", UIManager.getIcon("FileView.directoryIcon"), createStudentPanel());
        tabbedPane.addTab("Courses", UIManager.getIcon("FileView.hardDriveIcon"), createCoursePanel());
        tabbedPane.addTab("Enrollments", UIManager.getIcon("FileView.floppyDriveIcon"), createEnrollmentPanel());
        tabbedPane.addTab("Dashboard", UIManager.getIcon("FileView.computerIcon"), createDashboard());

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createDashboard() {
        JPanel panel = new JPanel(new GridLayout(1, 3, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(createStatCard("Students", studentManager.getStudents().size(), new Color(70, 130, 180)));
        panel.add(createStatCard("Courses", courseManager.getCourses().size(), new Color(50, 150, 100)));
        panel.add(createStatCard("Enrollments", enrollmentManager.getEnrollments().size(), new Color(150, 70, 130)));

        return panel;
    }

    private JComponent createStatCard(String title, int count, Color color) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(color.brighter());
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color.darker(), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JLabel countLabel = new JLabel(String.valueOf(count), SwingConstants.CENTER);
        countLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(countLabel, BorderLayout.CENTER);

        return card;
    }

    private JPanel createStudentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Toolbar with buttons
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        JButton addBtn = new JButton("Add", UIManager.getIcon("OptionPane.informationIcon"));
        addBtn.setToolTipText("Add Student");
        addBtn.addActionListener(e -> showAddStudentDialog());

        JButton deleteBtn = new JButton("Delete", UIManager.getIcon("OptionPane.errorIcon"));
        deleteBtn.setToolTipText("Delete Student");
        deleteBtn.addActionListener(e -> deleteStudent());

        toolBar.add(addBtn);
        toolBar.add(deleteBtn);

        // Student Table
        String[] columns = {"ID", "Name", "Email"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        studentTable = new JTable(model);
        customizeTable(studentTable);

        // Populate table
        refreshStudentTable();

        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(new JScrollPane(studentTable), BorderLayout.CENTER);

        return panel;
    }

    private void refreshStudentTable() {
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        model.setRowCount(0);
        for (Student student : studentManager.getStudents()) {
            model.addRow(new Object[]{student.getStudentId(), student.getName(), student.getEmail()});
        }
    }

    private void showAddStudentDialog() {
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();

        formPanel.add(new JLabel("Student ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        int result = JOptionPane.showConfirmDialog(
                this,
                formPanel,
                "Add Student",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            studentManager.addStudent(idField.getText(), nameField.getText(), emailField.getText());
            refreshStudentTable();
            JOptionPane.showMessageDialog(this, "Student added successfully!");
        }
    }

    private void deleteStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow >= 0) {
            String studentId = (String) studentTable.getValueAt(selectedRow, 0);
            studentManager.deleteStudent(studentId);
            enrollmentManager.removeEnrollmentsByStudent(studentId);
            refreshStudentTable();
            refreshEnrollmentTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel createCoursePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Toolbar
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        JButton addBtn = new JButton("Add", UIManager.getIcon("OptionPane.informationIcon"));
        addBtn.setToolTipText("Add Course");
        addBtn.addActionListener(e -> showAddCourseDialog());

        JButton deleteBtn = new JButton("Delete", UIManager.getIcon("OptionPane.errorIcon"));
        deleteBtn.setToolTipText("Delete Course");
        deleteBtn.addActionListener(e -> deleteCourse());

        toolBar.add(addBtn);
        toolBar.add(deleteBtn);

        // Course Table
        String[] columns = {"Course ID", "Name", "Credits"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        courseTable = new JTable(model);
        customizeTable(courseTable);

        refreshCourseTable();

        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(new JScrollPane(courseTable), BorderLayout.CENTER);

        return panel;
    }

    private void refreshCourseTable() {
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        model.setRowCount(0);
        for (Course course : courseManager.getCourses()) {
            model.addRow(new Object[]{course.getCourseId(), course.getCourseName(), course.getCredits()});
        }
    }

    private void showAddCourseDialog() {
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JSpinner creditsSpinner = new JSpinner(new SpinnerNumberModel(3, 1, 10, 1));

        formPanel.add(new JLabel("Course ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Course Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Credits:"));
        formPanel.add(creditsSpinner);

        int result = JOptionPane.showConfirmDialog(
                this,
                formPanel,
                "Add Course",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            courseManager.addCourse(
                    idField.getText(),
                    nameField.getText(),
                    (Integer) creditsSpinner.getValue()
            );
            refreshCourseTable();
            JOptionPane.showMessageDialog(this, "Course added successfully!");
        }
    }

    private void deleteCourse() {
        int selectedRow = courseTable.getSelectedRow();
        if (selectedRow >= 0) {
            String courseId = (String) courseTable.getValueAt(selectedRow, 0);
            courseManager.deleteCourse(courseId);
            enrollmentManager.removeEnrollmentsByCourse(courseId);
            refreshCourseTable();
            refreshEnrollmentTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a course to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel createEnrollmentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Toolbar
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        JButton enrollBtn = new JButton("Enroll", UIManager.getIcon("OptionPane.informationIcon"));
        enrollBtn.setToolTipText("Enroll Student");
        enrollBtn.addActionListener(e -> showEnrollDialog());

        JButton deleteBtn = new JButton("Remove", UIManager.getIcon("OptionPane.errorIcon"));
        deleteBtn.setToolTipText("Remove Enrollment");
        deleteBtn.addActionListener(e -> deleteEnrollment());

        toolBar.add(enrollBtn);
        toolBar.add(deleteBtn);

        // Enrollment Table
        String[] columns = {"Student ID", "Student Name", "Course ID", "Course Name"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        enrollmentTable = new JTable(model);
        customizeTable(enrollmentTable);

        refreshEnrollmentTable();

        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(new JScrollPane(enrollmentTable), BorderLayout.CENTER);

        return panel;
    }

    private void refreshEnrollmentTable() {
        DefaultTableModel model = (DefaultTableModel) enrollmentTable.getModel();
        model.setRowCount(0);

        for (Enrollment enrollment : enrollmentManager.getEnrollments()) {
            Student student = studentManager.getStudents().stream()
                    .filter(s -> s.getStudentId().equals(enrollment.getStudentId()))
                    .findFirst().orElse(null);

            Course course = courseManager.getCourses().stream()
                    .filter(c -> c.getCourseId().equals(enrollment.getCourseId()))
                    .findFirst().orElse(null);

            if (student != null && course != null) {
                model.addRow(new Object[]{
                        enrollment.getStudentId(),
                        student.getName(),
                        enrollment.getCourseId(),
                        course.getCourseName()
                });
            }
        }
    }

    private void showEnrollDialog() {
        JComboBox<String> studentCombo = new JComboBox<>();
        JComboBox<String> courseCombo = new JComboBox<>();

        // Populate comboboxes
        for (Student student : studentManager.getStudents()) {
            studentCombo.addItem(student.getStudentId() + " - " + student.getName());
        }
        for (Course course : courseManager.getCourses()) {
            courseCombo.addItem(course.getCourseId() + " - " + course.getCourseName());
        }

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Student:"));
        panel.add(studentCombo);
        panel.add(new JLabel("Course:"));
        panel.add(courseCombo);

        int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Enroll Student",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String studentId = studentCombo.getSelectedItem().toString().split(" - ")[0];
            String courseId = courseCombo.getSelectedItem().toString().split(" - ")[0];

            if (enrollmentManager.enrollStudent(studentId, courseId)) {
                refreshEnrollmentTable();
                JOptionPane.showMessageDialog(this, "Enrollment successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid student or course ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteEnrollment() {
        int selectedRow = enrollmentTable.getSelectedRow();
        if (selectedRow >= 0) {
            String studentId = (String) enrollmentTable.getValueAt(selectedRow, 0);
            String courseId = (String) enrollmentTable.getValueAt(selectedRow, 2);
            enrollmentManager.removeEnrollmentsByStudent(studentId); // Simplified removal
            refreshEnrollmentTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an enrollment to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void customizeTable(JTable table) {
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setRowHeight(25);
        table.setSelectionBackground(new Color(200, 200, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    }
}