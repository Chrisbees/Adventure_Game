package com.chrisbees;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private String descriptions;
    public Map<String, Integer> exits;

    public Location(int locationID, String descriptions) {
        this.locationID = locationID;
        this.descriptions = descriptions;
        this.exits = new HashMap<>();
        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }

    public void addExits(String directions, int location) {
        exits.put(directions, location);
    }


}
