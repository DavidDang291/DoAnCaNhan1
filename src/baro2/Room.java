
package baro2;
import java.util.Scanner;

public abstract class Room implements IRoom {

    private String id;
    private String name;
    private double baseCost;

    public Room() {
    }

    public Room(String id, String name, double baseCost) {
        this.id = id;
        this.name = name;
        this.baseCost = baseCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public void addRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        setId(scanner.nextLine());
        System.out.print("Name: ");
        setName(scanner.nextLine());
        System.out.print("Base cost: ");
        setBaseCost(Double.parseDouble(scanner.nextLine()));
    }

    public void updateRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        setName(scanner.nextLine());
        System.out.print("Base cost: ");
        setBaseCost(Double.parseDouble(scanner.nextLine()));
    }

    public void displayDetails() {
        System.out.print("ID: " + getId() + ", Name: " + getName() + ", Base cost: " + getBaseCost());
    }

    public abstract double calculateCost();
}
