package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write cord of first point");
        double cord0X = in.nextDouble();
        double cord0Y = in.nextDouble();
        double cord0Z = in.nextDouble();
        System.out.println("Write cord of second point");
        double cord1X = in.nextDouble();
        double cord1Y = in.nextDouble();
        double cord1Z = in.nextDouble();
        System.out.println("Write cord of theard point");
        double cord2X = in.nextDouble();
        double cord2Y = in.nextDouble();
        double cord2Z = in.nextDouble();

        Point3d point0 = new Point3d(cord0X, cord0Y, cord0Z);
        Point3d point1 = new Point3d(cord1X, cord1Y, cord1Z);
        Point3d point2 = new Point3d(cord2X, cord2Y, cord2Z);

        double area =  Point3d.computeArea(point0, point1, point2);
        System.out.println("area of triug: " + area);

    }

}

