
package baro2;
import java.util.Scanner;

import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomList roomList = new RoomList();
        int choose;
        do {
            System.out.println("\n-MENU:");
            System.out.println("0. Exit");
            System.out.println("1. Add room");
            System.out.println("2. Display list");
            System.out.println("3. Update room");
            System.out.println("4. Delete room");
            System.out.println("5. Find room");
            System.out.println("6. Find the most expensive room");
            System.out.println("7. Count");
            System.out.print("Choose method: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.print("Which room? 1-Meeting room, 2-Bed room: ");
                    int chooseRoom = Integer.parseInt(scanner.nextLine());
                    if (chooseRoom == 1) {
                        MeetingRoom meetingRoom = new MeetingRoom();
                        roomList.addRoom(meetingRoom);
                    } else {
                        BedRoom bedRoom = new BedRoom();
                        roomList.addRoom(bedRoom);
                    }
                    break;
                case 2:
                    roomList.displayAllRooms();
                    break;
                case 3:
                    System.out.print("Enter ID of the room to be updated: ");
                    roomList.updateRoomById(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter ID of the room to be deleted: ");
                    roomList.deleteRoomById(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Enter ID of the room you are looking for: ");
                    roomList.findRoomById(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("The most expensive room is:");
                    roomList.findMostExpensiveRoom();
                    break;
                case 7:
                    roomList.countRooms();
                    break;
                default:
                    System.out.println("Wrong selection, please select again!");
                    break;
            }
            System.out.print("Continue? 1-Yes, 0-No: ");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose != 0);
    }
}
