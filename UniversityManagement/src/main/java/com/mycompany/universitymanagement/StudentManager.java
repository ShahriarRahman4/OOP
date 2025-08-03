
package com.mycompany.universitymanagement;


import java.util.ArrayList;
import java.util.List;

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(String studentId, String name, String email) {
        students.add(new Student(studentId, name, email));
        System.out.println("Student added: " + name);
    }

    public void updateStudent(String studentId, String name, String email) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setName(name);
                student.setEmail(email);
                System.out.println("Student updated: " + studentId);
                return;
            }
        }
        System.out.println("Student not found: " + studentId);
    }

    public void deleteStudent(String studentId) {
        students.removeIf(student -> student.getStudentId().equals(studentId));
        System.out.println("Student deleted: " + studentId);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public boolean studentExists(String studentId) {
        return students.stream().anyMatch(student -> student.getStudentId().equals(studentId));
    }
    public List<Student> getStudents() {
        return new ArrayList<>(students); // Return a copy
    }
}
