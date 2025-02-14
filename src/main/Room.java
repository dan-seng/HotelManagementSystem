/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cx
 */
public class Room {
    private int roomNumber;
    private String roomType;
    private boolean isOccupied;
    private double roomPrice;

    public Room(int roomNumber, String roomType, double roomPrice) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isOccupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    // Method to occupy the room; file update is managed externally
    public void occupyRoom() {
        isOccupied = true;
    }

    // Used when loading data without triggering a file update
    public void occupyRoomWithoutFileUpdate() {
        isOccupied = true;
    }

    public void vacateRoom() {
        isOccupied = false;
    }

    @Override
    public String toString() {
        return roomNumber + "," + roomType + "," + roomPrice + "," + (isOccupied ? "Yes" : "No");
    }

}
