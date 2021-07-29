package com.company;

import java.util.TreeSet;

public class BestExamScore implements Strategy {
    @Override
    public Student getBestStudent(TreeSet<Grade> grades) {
        Student student = null;
        Double value = 0.0;

        for (Grade grade : grades) {
            if (grade.getExamScore() > value) {
                value = grade.getExamScore();
                student = grade.getStudent();
            }
        }
        return student;
    }
}
