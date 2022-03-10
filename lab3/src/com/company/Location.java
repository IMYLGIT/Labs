package com.company;

import java.util.Objects;

public class Location
{


    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Location)) return false;
        Location loc = (Location) obj;
        return xCoord == loc.xCoord && yCoord == loc.yCoord;
    }

    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }


    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }
}