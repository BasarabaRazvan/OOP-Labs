package com.company;

import java.util.ArrayList;

public class UserFactory {
    public static User createUser(String type, String firstName, String lastName) {
        if(type.equals("Parent")) {
            return new Parent(firstName, lastName);
        } else if(type.equals("Teacher")) {
            return new Teacher(firstName, lastName);
        } else if(type.equals("Student")) {
            return new Student(firstName, lastName);
        } else if(type.equals("Assistant")) {
            return new Assistant(firstName, lastName);
        }
        return null;
    }
}

class Parent extends User implements Observer {
    private ArrayList<Notification> notifications;

    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
        notifications = new ArrayList<>();
    }

    @Override
    public void update(Notification notification) {
        notifications.add(notification);
        System.out.println(this.firstName + " " + this.lastName + "\t" + notification);
    }
}

class Teacher extends User {
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }
}

class Student extends User {
    private Parent mother;
    private Parent father;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Parent getMother() {
        return mother;
    }

    public void setMother(Parent mother) {
        this.mother = mother;
    }

    public Parent getFather() {
        return father;
    }

    public void setFather(Parent father) {
        this.father = father;
    }

    public boolean isParent(Observer observer) {
        if (observer.equals(father) || observer.equals(mother)) {
            return true;
        }
        return false;
    }
}

class Assistant extends User {
    public Assistant(String firstName, String lastName) {
        super(firstName, lastName);
    }
}

