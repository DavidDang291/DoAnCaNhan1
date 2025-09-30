
package baro2;
import java.util.Scanner;

import java.util.ArrayList;
public class RoomList {

    ArrayList<Room> roomList = new ArrayList<>();

    public void addRoom(Room room) {
        room.addRoom();
        roomList.add(room);
        System.out.println("-> Add success");
    }

    public void displayAllRooms() {
        for (int i = 0; i < roomList.size(); i++) {
            roomList.get(i).displayDetails();
        }
    }

    public void updateRoomById(String id) {
        boolean found = true;
        for (int i = 0; i < roomList.size(); i++) {
            if (id.equals(roomList.get(i).getId())) {
                roomList.get(i).updateRoom();
                System.out.println("-> Update success");
                break;
            }
        }
        if (!found) {
            System.out.println("The room with id " + id + " not found!");
        }
    }

    public void deleteRoomById(String id) {
        boolean found = true;
        for (int i = 0; i < roomList.size(); i++) {
            if (id.equals(roomList.get(i).getId())) {
                roomList.remove(i);
                System.out.println("-> Delete success");
                break;
            }
        }
        if (!found) {
            System.out.println("The room with id " + id + " not found!");
        }
    }

    public void findRoomById(String id) {
        boolean found = true;
        for (int i = 0; i < roomList.size(); i++) {
            if (id.equals(roomList.get(i).getId())) {
                roomList.get(i).displayDetails();
                System.out.println("-> Find success");
                break;
            }
        }
        if (!found) {
            System.out.println("The room with id " + id + " not found!");
        }
    }

    public void findMostExpensiveRoom() {
        double max = 0;
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).calculateCost() > max) {
                max = roomList.get(i).calculateCost();
            }
        }
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).calculateCost() == max) {
                roomList.get(i).displayDetails();
                System.out.println("-> Find most expensive room success");
                break;
            }
        }
    }

    public void countRooms() {
        int countMeetingRoom = 0;
        int countBedRoom = 0;
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i) instanceof MeetingRoom) {
                countMeetingRoom++;
            } else {
                countBedRoom++;
            }
        }
        System.out.println("-> Number of meeting room: " + countMeetingRoom);
        System.out.println("-> Number of bed room: " + countBedRoom);
        System.out.println("-> Total number of room: " + roomList.size());
    }
}