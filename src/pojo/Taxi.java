package pojo;

import java.util.ArrayList;

public class Taxi {
    private int freeTime;
    private char currentPoint;
    private boolean booked;
    private int totalEarnings;
    private int id;
    private ArrayList<String> trips = new ArrayList<>();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public char getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(char currentPoint) {
        this.currentPoint = currentPoint;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public ArrayList<String> getTrips() {
        return trips;
    }

    public void setTrips(String trip) {
        trips.add(trip);
    }
}
