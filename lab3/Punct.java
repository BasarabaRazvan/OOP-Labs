package com.company;
import java.lang.Math;

public class Punct {
    private int x, y;

    public Punct() {
        y = 0;
        x = 0;
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y =y;
    }

    @Override
    public String toString() {
        return "Punct{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    double distance(int a, int b) {
        return Math.sqrt((x-a) * (x - a) + (y - b) * (y - b));
    }

    double distance(Punct p1) {
        return Math.sqrt((x-p1.x) * (x - p1.x) + (y - p1.y) * (y - p1.y));
    }

    public static void main(String[] args) {
        Punct A = new Punct();
        Punct B = new Punct();

        A.setX(1); A.setY(1);
        B.setX(7); B.setY(-4);

        System.out.println("A: " + A + " B: " + B);
        System.out.println("Distance = " + A.distance(B));
    }
}
