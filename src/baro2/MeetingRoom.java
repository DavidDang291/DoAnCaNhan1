
package baro2;

import java.util.*;
import java.util.Scanner;

public class MeetingRoom extends Room {

    private int capacity;

    public MeetingRoom() {
    }

    public MeetingRoom(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addRoom() {
        Scanner scanner = new Scanner(System.in);
        super.addRoom();
        System.out.print("Capacity: ");
        setCapacity(Integer.parseInt(scanner.nextLine()));
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Capacity: " + getCapacity() + ", Meeting room cost: " + calculateCost());
    }

    public void updateRoom() {
        Scanner scanner = new Scanner(System.in);
        super.updateRoom();
        System.out.print("Capacity: ");
        Integer.parseInt(scanner.nextLine());
    }

    @Override
    public double calculateCost() {
        double result;
        if (getCapacity() > 50) {
            result = getBaseCost() + getBaseCost() * 0.2;
        } else {
            result = getBaseCost();
        }
        return result;
    }

}
