package edu.umb.cs681.hw9;
import java.util.List;
import java.util.ArrayList;

public record Position(double latitude, double longitude, double altitude) {
    // Returns a list containing the latitude, longitude, and altitude
    public List<Double> coordinate() {
        List<Double> coordinateList = new ArrayList<>();
        coordinateList.add(latitude);
        coordinateList.add(longitude);
        coordinateList.add(altitude);
        return coordinateList;
    }

    // Creates a new Position instance with the specified latitude, longitude, and altitude
    public Position change(double newLat, double newLon, double newAlt) {
        return new Position(newLat, newLon, newAlt);
    }

    // Returns true if this Position has a higher altitude than anotherPosition
    public boolean higherAltThan(Position anotherPosition) {
        return altitude > anotherPosition.altitude;
    }

    // Returns true if this Position has a lower altitude than anotherPosition
    public boolean lowerAltThan(Position anotherPosition) {
        return altitude < anotherPosition.altitude;
    }

    // Returns true if this Position is north of anotherPosition
    public boolean northOf(Position anotherPosition) {
        return latitude > anotherPosition.latitude;
    }

    // Returns true if this Position is south of anotherPosition
    public boolean southOf(Position anotherPosition) {
        return latitude < anotherPosition.latitude;
    }
}