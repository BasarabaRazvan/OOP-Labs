package com.company;

import java.util.ArrayList;
import java.util.TreeSet;

public class Course {
    private String name;
    private Teacher teacher;
    private ArrayList<Assistant> assistants;
    private TreeSet<Grade> grades;
    private ArrayList<Student> students;
    private Strategy strategy;


    public Course(CourseBuilder builder) {
        this.name = builder.name;
        this.teacher = builder.teacher;
        this.assistants = builder.assistants;
        this.grades = builder.grades;
        this.students = builder.students;
        this.strategy = builder.strategy;
    }

    public Course(String name, Teacher teacher, ArrayList<Assistant> assistants, TreeSet<Grade> grades, ArrayList<Student> students, Strategy strategy) {
        this.name = name;
        this.teacher = teacher;
        this.assistants = assistants;
        this.grades = grades;
        this.students = students;
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "Course name:\t" + name +
                "\nTeacher:\t" + teacher +
                "\nAssistants:\n" + assistants +
                "\nGrades\n" + grades +
                "\nStudents\n" + students;
    }

    static class CourseBuilder {
        private String name;
        private Teacher teacher;
        private ArrayList<Assistant> assistants;
        private TreeSet<Grade> grades;
        private ArrayList<Student> students;
        private Strategy strategy;

        public CourseBuilder(String name) {
            this.name = name;
            assistants = new ArrayList<>();
            grades = new TreeSet<>();
            students = new ArrayList<>();
        }

        public CourseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CourseBuilder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder assistant(Assistant assistant) {
            assistants.add(assistant);
            return this;
        }

        public CourseBuilder grade(Grade grade) {
            grades.add(grade);
            return this;
        }

        public CourseBuilder student(Student stdent) {
            students.add(stdent);
            return this;
        }

        public CourseBuilder strategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}
