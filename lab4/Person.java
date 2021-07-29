package com.company;

import javax.print.DocFlavor;
import java.util.Vector;

public class Person {
    String name;
    String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    void addCourseGrade(String address) {
        this.address = address;
    }

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Teacher extends Person {
    Vector courses;

    public Teacher(String name, String address) {
        super(name, address);
        courses = new Vector();
    }
    public boolean addCourse(String course) {
        if(courses.contains(course))
            return false;
        courses.add(course);
        return true;
    }
    public boolean removeCourse(String course) {
        if(courses.contains(course))
            return false;
        courses.remove(course);
        return true;
    }
}
class Student extends Person {
    Vector courses;
    Vector grades;

    public Student(String name, String address) {
        super(name, address);
        courses = new Vector();
        grades = new Vector();
    }

    void addCourseGrade(String course, int grade) {
        courses.add(course);
        grades.add(grade);
    }

    void printGrades() {
        for(int i = 0; i < grades.size(); i++)
            System.out.println(grades.get(i) + " ");
    }

    double getAverageGrade() {
        double medie, suma = 0;
        for(int i = 0; i < grades.size(); i++)
            suma = suma + (double)grades.get(i);
        medie = suma / grades.size();
        return medie;
    }
}
class Test4 {
    public static void main(String args[]) {
        Person student, teacher, person;
        student = new Student("Popescu Ion", "Bucuresti");
        teacher = new Teacher("Ionescu Gigel", "Bucuresti");
        person = new Person("Maria", "Iasi");
        assert (person.getName().equals("Maria")) : "Metoda getName din clasa Person nu este implementata corect";
        assert (((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Algoritmica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Matematica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).removeCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        ((Student) student).addCourseGrade("Programare", 10);
        ((Student) student).addCourseGrade("Algoritmica", 9);
        ((Student) student).addCourseGrade("Matematica", 8);
        assert (Math.abs(((Student) student).getAverageGrade() - 9.00) <= 0.001) : "Metoda getAverageGrade din clasa " +
                "Student nu a fost implementat corect";
        ((Student) student).printGrades();
        //Ce metoda toString se va apela? Din ce clasa?
        System.out.println(student);
        System.out.println(person);
        System.out.println("Felicitari! Problema a fost rezolvata corect!");
    }
}
