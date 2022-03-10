package com.company;

public class Point3d {
    private double xCoord;
    private double yCoord;
    private double zCoord;

    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Point3d() {
        this(0.0, 0.0, 0.0);
    }

    public double getX() {
        return xCoord;
    }

    public double getY() {
        return yCoord;
    }

    public double getZ() {
        return zCoord;
    }

    public void setX(double val) {
        xCoord = val;
    }

    public void setY(double val) {
        yCoord = val;
    }

    public void setZ(double val) {
        zCoord = val;
    }

    static public boolean isEcual(Point3d point1, Point3d point2) {
        boolean compairX = point1.xCoord == point2.xCoord;
        boolean compairY = point1.yCoord == point2.yCoord;
        boolean compairZ = point1.zCoord == point2.zCoord;
        if (compairX && compairY && compairZ) {
            return true;
        }
        return false;
    }
    public static boolean checkPoints(Point3d point0, Point3d point1, Point3d point2) {
        if (((point0.getX() == point1.getX()) && (point0.getY() == point1.getY()) && (point0.getZ() == point1.getZ())) || ((point1.getX() == point2.getX()) && (point1.getY() == point2.getY()) && (point1.getZ() == point2.getZ())) || ((point0.getX() == point2.getX()) && (point0.getY() == point2.getY()) && (point0.getZ() == point2.getZ()))) {
            return false;
        }
        return true;

    }
    public double distanceTo(Point3d point) {
        double r = (Math.sqrt(Math.pow((this.xCoord - point.xCoord), 2) + Math.pow((this.yCoord - point.yCoord), 2) + Math.pow((this.zCoord - point.zCoord), 2)));
         r = Math.round(r * 100.0) / 100.0;
        return r;
    }

    static public double computeArea(Point3d point0, Point3d point1, Point3d point2) {
        double a = point0.distanceTo(point1);
        double b = point1.distanceTo(point2);
        double c = point2.distanceTo(point0);
        double p = (a + b + c) / 2;
        System.out.println(p);
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        area = Math.round(area * 100.0) / 100.0;
        return area;
    }
}
