
package UniversityManagement;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class UniversityManagementSystemFX extends Application {
    private StudentManager studentManager = new StudentManager();
    private CourseManager courseManager = new CourseManager();
    private EnrollmentManager enrollmentManager = new EnrollmentManager(studentManager, courseManager);
    private boolean isDarkTheme = false;

    @Override
    public void start(Stage primaryStage) {
        // Main layout: BorderPane
        BorderPane root = new BorderPane();
        root.getStyleClass().add("root");

        // Top: Header with logo and title
        HBox header = new HBox(10);
        header.getStyleClass().add("header");
        Image logo = new Image(getClass().getResourceAsStream("/logo.png")); // Place logo.png in src/main/resources
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(40);
        logoView.setFitWidth(40);
        Label title = new Label("University Management System 🎓");
        title.getStyleClass().add("header-label");
        header.getChildren().addAll(logoView, title);
        header.setAlignment(Pos.CENTER_LEFT);
        root.setTop(header);

        // Left: Sidebar for navigation
        VBox sidebar = new VBox(10);
        sidebar.getStyleClass().add("sidebar");
        Button studentButton = new Button("Students 📚");
        Button courseButton = new Button("Courses 📖");
        Button enrollmentButton = new Button("Enrollments 📋");
        Button themeButton = new Button("Toggle Theme 🌗");
        studentButton.getStyleClass().add("button");
        courseButton.getStyleClass().add("button");
        enrollmentButton.getStyleClass().add("button");
        themeButton.getStyleClass().add("button");
        sidebar.getChildren().addAll(studentButton, courseButton, enrollmentButton, themeButton);
        sidebar.setPadding(new Insets(10));
        root.setLeft(sidebar);

        // Center: TabPane for sections
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Tab studentTab = new Tab("Students");
        Tab courseTab = new Tab("Courses");
        Tab enrollmentTab = new Tab("Enrollments");
        tabPane.getTabs().addAll(studentTab, courseTab, enrollmentTab);

        // Student Section
        VBox studentSection = createStudentSection();
        studentTab.setContent(studentSection);

        // Course Section
        VBox courseSection = createCourseSection();
        courseTab.setContent(courseSection);

        // Enrollment Section
        VBox enrollmentSection = createEnrollmentSection();
        enrollmentTab.setContent(enrollmentSection);

        root.setCenter(tabPane);

        // Sidebar Actions
        studentButton.setOnAction(e -> tabPane.getSelectionModel().select(studentTab));
        courseButton.setOnAction(e -> tabPane.getSelectionModel().select(courseTab));
        enrollmentButton.setOnAction(e -> tabPane.getSelectionModel().select(enrollmentTab));
        themeButton.setOnAction(e -> {
            isDarkTheme = !isDarkTheme;
            Scene scene = primaryStage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(isDarkTheme ? "/dark.css" : "/styles.css").toExternalForm());
            themeButton.setText(isDarkTheme ? "Switch to Light Theme ☀️" : "Switch to Dark Theme 🌙");
        });

        // Scene and Stage
        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setTitle("University Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createStudentSection() {
        VBox studentSection = new VBox(15);
        studentSection.setPadding(new Insets(20));
        studentSection.setAlignment(Pos.CENTER);

        // Input Form
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setAlignment(Pos.CENTER);

        TextField idField = new TextField();
        idField.setPromptText("Student ID");
        idField.getStyleClass().add("text-field");
        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.getStyleClass().add("text-field");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.getStyleClass().add("text-field");

        form.add(new Label("Student ID:"), 0, 0);
        form.add(idField, 1, 0);
        form.add(new Label("Name:"), 0, 1);
        form.add(nameField, 1, 1);
        form.add(new Label("Email:"), 0, 2);
        form.add(emailField, 1, 2);

        // Buttons
        HBox buttons = new HBox(10);
        Button addButton = new Button("Add Student 📝");
        addButton.getStyleClass().add("button");
        Button updateButton = new Button("Update Student ✏️");
        updateButton.getStyleClass().add("button");
        Button deleteButton = new Button("Delete Student 🗑️");
        deleteButton.getStyleClass().add("button");
        buttons.getChildren().addAll(addButton, updateButton, deleteButton);
        buttons.setAlignment(Pos.CENTER);

        // Student Table
        TableView<Student> studentTable = new TableView<>();
        studentTable.getStyleClass().add("table-view");
        TableColumn<Student, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getStudentId()));
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEmail()));
        studentTable.getColumns().addAll(idColumn, nameColumn, emailColumn);

        // Populate table
        ObservableList<Student> studentData = FXCollections.observableArrayList(studentManager.getStudents());
        studentTable.setItems(studentData);

        // Button Actions
        addButton.setOnAction(e -> {
            try {
                studentManager.addStudent(idField.getText(), nameField.getText(), emailField.getText());
                studentData.setAll(studentManager.getStudents());
                idField.clear();
                nameField.clear();
                emailField.clear();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student added successfully! 🎉");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to add student: " + ex.getMessage());
            }
        });

        updateButton.setOnAction(e -> {
            try {
                studentManager.updateStudent(idField.getText(), nameField.getText(), emailField.getText());
                studentData.setAll(studentManager.getStudents());
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student updated successfully! ✅");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to update student: " + ex.getMessage());
            }
        });

        deleteButton.setOnAction(e -> {
            try {
                studentManager.deleteStudent(idField.getText());
                enrollmentManager.removeEnrollmentsByStudent(idField.getText());
                studentData.setAll(studentManager.getStudents());
                idField.clear();
                nameField.clear();
                emailField.clear();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student deleted successfully! 🗑️");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete student: " + ex.getMessage());
            }
        });

        studentSection.getChildren().addAll(new Label("Manage Students 📚"), form, buttons, studentTable);
        return studentSection;
    }

    private VBox createCourseSection() {
        VBox courseSection = new VBox(15);
        courseSection.setPadding(new Insets(20));
        courseSection.setAlignment(Pos.CENTER);

        // Input Form
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setAlignment(Pos.CENTER);

        TextField idField = new TextField();
        idField.setPromptText("Course ID");
        idField.getStyleClass().add("text-field");
        TextField nameField = new TextField();
        nameField.setPromptText("Course Name");
        nameField.getStyleClass().add("text-field");
        TextField creditsField = new TextField();
        creditsField.setPromptText("Credits");
        creditsField.getStyleClass().add("text-field");

        form.add(new Label("Course ID:"), 0, 0);
        form.add(idField, 1, 0);
        form.add(new Label("Course Name:"), 0, 1);
        form.add(nameField, 1, 1);
        form.add(new Label("Credits:"), 0, 2);
        form.add(creditsField, 1, 2);

        // Buttons
        HBox buttons = new HBox(10);
        Button addButton = new Button("Add Course 📖");
        addButton.getStyleClass().add("button");
        Button updateButton = new Button("Update Course ✏️");
        updateButton.getStyleClass().add("button");
        Button deleteButton = new Button("Delete Course 🗑️");
        deleteButton.getStyleClass().add("button");
        buttons.getChildren().addAll(addButton, updateButton, deleteButton);
        buttons.setAlignment(Pos.CENTER);

        // Course Table
        TableView<Course> courseTable = new TableView<>();
        courseTable.getStyleClass().add("table-view");
        TableColumn<Course, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCourseId()));
        TableColumn<Course, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCourseName()));
        TableColumn<Course, Number> creditsColumn = new TableColumn<>("Credits");
        creditsColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getCredits()));
        courseTable.getColumns().addAll(idColumn, nameColumn, creditsColumn);

        // Populate table
        ObservableList<Course> courseData = FXCollections.observableArrayList(courseManager.getCourses());
        courseTable.setItems(courseData);

        // Button Actions
        addButton.setOnAction(e -> {
            try {
                int credits = Integer.parseInt(creditsField.getText());
                courseManager.addCourse(idField.getText(), nameField.getText(), credits);
                courseData.setAll(courseManager.getCourses());
                idField.clear();
                nameField.clear();
                creditsField.clear();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Course added successfully! 🎉");
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Credits must be a number.");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to add course: " + ex.getMessage());
            }
        });

        updateButton.setOnAction(e -> {
            try {
                int credits = Integer.parseInt(creditsField.getText());
                courseManager.updateCourse(idField.getText(), nameField.getText(), credits);
                courseData.setAll(courseManager.getCourses());
                showAlert(Alert.AlertType.INFORMATION, "Success", "Course updated successfully! ✅");
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Credits must be a number.");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to update course: " + ex.getMessage());
            }
        });

        deleteButton.setOnAction(e -> {
            try {
                courseManager.deleteCourse(idField.getText());
                enrollmentManager.removeEnrollmentsByCourse(idField.getText());
                courseData.setAll(courseManager.getCourses());
                idField.clear();
                nameField.clear();
                creditsField.clear();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Course deleted successfully! 🗑️");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete course: " + ex.getMessage());
            }
        });

        courseSection.getChildren().addAll(new Label("Manage Courses 📖"), form, buttons, courseTable);
        return courseSection;
    }

    private VBox createEnrollmentSection() {
        VBox enrollmentSection = new VBox(15);
        enrollmentSection.setPadding(new Insets(20));
        enrollmentSection.setAlignment(Pos.CENTER);

        // Input Form
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setAlignment(Pos.CENTER);

        TextField studentIdField = new TextField();
        studentIdField.setPromptText("Student ID");
        studentIdField.getStyleClass().add("text-field");
        TextField courseIdField = new TextField();
        courseIdField.setPromptText("Course ID");
        courseIdField.getStyleClass().add("text-field");

        form.add(new Label("Student ID:"), 0, 0);
        form.add(studentIdField, 1, 0);
        form.add(new Label("Course ID:"), 0, 1);
        form.add(courseIdField, 1, 1);

        // Buttons
        HBox buttons = new HBox(10);
        Button enrollButton = new Button("Enroll Student 📋");
        enrollButton.getStyleClass().add("button");
        buttons.getChildren().add(enrollButton);
        buttons.setAlignment(Pos.CENTER);

        // Enrollment Table
        TableView<Enrollment> enrollmentTable = new TableView<>();
        enrollmentTable.getStyleClass().add("table-view");
        TableColumn<Enrollment, String> studentIdColumn = new TableColumn<>("Student ID");
        studentIdColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getStudentId()));
        TableColumn<Enrollment, String> courseIdColumn = new TableColumn<>("Course ID");
        courseIdColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCourseId()));
        enrollmentTable.getColumns().addAll(studentIdColumn, courseIdColumn);

        // Populate table
        ObservableList<Enrollment> enrollmentData = FXCollections.observableArrayList(enrollmentManager.getEnrollments());
        enrollmentTable.setItems(enrollmentData);

        // Button Action
        enrollButton.setOnAction(e -> {
            try {
                enrollmentManager.enrollStudent(studentIdField.getText(), courseIdField.getText());
                enrollmentData.setAll(enrollmentManager.getEnrollments());
                studentIdField.clear();
                courseIdField.clear();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student enrolled successfully! 🎉");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to enroll student: " + ex.getMessage());
            }
        });

        enrollmentSection.getChildren().addAll(new Label("Manage Enrollments 📋"), form, buttons, enrollmentTable);
        return enrollmentSection;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
