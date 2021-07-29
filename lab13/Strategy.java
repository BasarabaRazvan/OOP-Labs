package com.company;

import java.util.TreeSet;

public interface Strategy {
    Student getBestStudent(TreeSet<Grade> grades);
}


