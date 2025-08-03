
package com.mycompany.universitymanagement;

class Enrollment {
    private String studentId;
    private String courseId;

    public Enrollment(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Enrollment{StudentID=" + studentId + ", CourseID=" + courseId + "}";
    }
}