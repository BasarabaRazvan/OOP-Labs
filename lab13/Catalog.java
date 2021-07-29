package com.company;

import java.util.ArrayList;

public class Catalog implements Subject {
    private static Catalog catalog;
    private ArrayList<Course> courses;
    private ArrayList<Observer> observers;

    private Catalog() {
        courses = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Catalog getInstance() {
        if(catalog == null)
            return new Catalog();
        return catalog;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "courses=" + courses +
                '}';
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        for (Observer observer : observers) {
            if (grade.getStudent().isParent(observer)) {
                observer.update(new Notification("Fiul/Fiica a obtinut nota: " + grade.getTotal()));
            }
        }
    }
}
