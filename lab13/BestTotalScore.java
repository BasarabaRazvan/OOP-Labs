package com.company;

import java.util.TreeSet;

public class BestTotalScore implements Strategy {
    @Override
    public Student getBestStudent(TreeSet<Grade> grades) {
        Student student = null;
        Double value = 0.0;

        for (Grade grade : grades) {
            if (grade.getTotal() > value) {
                value = grade.getTotal();
                student = grade.getStudent();
            }
        }

        return student;
    }
}