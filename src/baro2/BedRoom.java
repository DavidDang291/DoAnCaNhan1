
package baro2;
import java.util.Scanner;

public class BedRoom extends Room {

    private int numberOfBeds;

    public BedRoom() {
    }

    public BedRoom(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void addRoom() {
        Scanner scanner = new Scanner(System.in);
        super.addRoom();
        System.out.print("Number of beds: ");
        setNumberOfBeds(Integer.parseInt(scanner.nextLine()));
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Number of beds: " + getNumberOfBeds() + ", Bed room cost: " + calculateCost());
    }

    public void updateRoom() {
        Scanner scanner = new Scanner(System.in);
        super.updateRoom();
        System.out.print("Number of beds: ");
        setNumberOfBeds(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public double calculateCost() {
        if (getNumberOfBeds() > 3) {
            return getBaseCost() + getBaseCost() * 0.1;
        } else {
            return getBaseCost();
        }
    }
}