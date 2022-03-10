package com.company;

import java.util.HashMap;
import java.util.Map;

public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;
    private HashMap<Location, Waypoint> openDots = new HashMap<Location, Waypoint>();
    private HashMap<Location, Waypoint> closedDots = new HashMap<Location, Waypoint>();


    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }



    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
       Waypoint sol = null;

       float min = Float.POSITIVE_INFINITY;
       float totalCost = 0;

       for (Waypoint point : openDots.values()) {
           totalCost = point.getTotalCost();

           if (min > totalCost) {
               min = totalCost;
               sol = point;
           }
       }
       return sol;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWaypoint)
    {
        Waypoint other = openDots.get(newWaypoint.getLocation());

        if (other == null || newWaypoint.getPreviousCost() < other.getPreviousCost()) {
            openDots.put(newWaypoint.getLocation(), newWaypoint);
            return true;
        }

        return false;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        int openDots = this.openDots.size();
        return openDots;
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
       Waypoint point = openDots.remove(loc);

       if (point != null) {
           closedDots.put(loc, point);
       }
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        return closedDots.containsKey(loc);
    }
}
