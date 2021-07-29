package com.company;

public class Grade implements Comparable {
    private Double partialScore, examScore;
    private Student student;
    private String course;

    public Double getPartialScore() {
        return partialScore;
    }

    public Double getExamScore() {
        return examScore;
    }

    public Grade(String course, Student student) {
        partialScore = 0.0;
        examScore = 0.0;
        this.course = course;
        this.student = student;
    }

    public Grade(String course, Student student, Double partialScore, Double examScore ) {
        this.partialScore = partialScore;
        this.examScore = examScore;
        this.course = course;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setPartialScore(Double score) {
        partialScore = score;
    }
    public void setExamScore(Double score) {
        examScore = score;
    }
    public Double getTotal() {
        return partialScore + examScore;
    }

    @Override
    public int compareTo(Object o) {
        Grade grade = (Grade) o;
        if(this.getTotal() >= grade.getTotal())
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "partialScore=" + partialScore +
                ", examScore=" + examScore +
                ", student=" + student +
                ", course='" + course + '\'' +
                '}';
    }
}