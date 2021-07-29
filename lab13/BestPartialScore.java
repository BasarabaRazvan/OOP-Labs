package com.company;

import java.util.TreeSet;

public class BestPartialScore implements Strategy {
    @Override
    public Student getBestStudent(TreeSet<Grade> grades) {
        Student student = null;
        Double value = 0.0;

        for (Grade grade : grades) {
            if (grade.getPartialScore() > value) {
                value = grade.getPartialScore();
                student = grade.getStudent();
            }
        }

        return student;
    }
}