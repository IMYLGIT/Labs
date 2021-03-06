
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
        this(0.0, 0.0,0.0);
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
    public double distanceTo(Point3d point) {
        double compare = isEcual(this, point)
        return compare;
    }
}
