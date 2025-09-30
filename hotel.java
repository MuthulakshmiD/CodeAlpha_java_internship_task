import java.util.*;

class Room {
    String type;
    boolean isBooked;

    Room(String type) {
        this.type = type;
        this.isBooked = false;
    }
}

class Hotel {
    List<Room> rooms = new ArrayList<>();

    Hotel() {
        // Add rooms
        for (int i = 0; i < 5; i++) rooms.add(new Room("Standard"));
        for (int i = 0; i < 3; i++) rooms.add(new Room("Deluxe"));
        for (int i = 0; i < 2; i++) rooms.add(new Room("Suite"));
    }

    void viewRooms() {
        System.out.println("Available Rooms:");
        for (int i = 0; i < rooms.size(); i++) {
            Room r = rooms.get(i);
            if (!r.isBooked) System.out.println(i + 1 + ". " + r.type);
        }
    }

    void bookRoom(int index) {
        if (index >= 0 && index < rooms.size() && !rooms.get(index).isBooked) {
            rooms.get(index).isBooked = true;
            System.out.println("Room booked: " + rooms.get(index).type);
        } else {
            System.out.println("Invalid selection or already booked!");
        }
    }

    void cancelBooking(int index) {
        if (index >= 0 && index < rooms.size() && rooms.get(index).isBooked) {
            rooms.get(index).isBooked = false;
            System.out.println("Booking canceled: " + rooms.get(index).type);
        } else {
            System.out.println("Invalid selection or room not booked!");
        }
    }
}

public class HotelReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n1. View Rooms 2. Book Room 3. Cancel Booking 4. Exit");
            int choice = sc.nextInt();
            if (choice == 4) break;

            switch (choice) {
                case 1 -> hotel.viewRooms();
                case 2 -> {
                    System.out.println("Enter room number to book:");
                    int roomNum = sc.nextInt() - 1;
                    hotel.bookRoom(roomNum);
                }
                case 3 -> {
                    System.out.println("Enter room number to cancel booking:");
                    int roomNum = sc.nextInt() - 1;
                    hotel.cancelBooking(roomNum);
                }
            }
        }

        sc.close();
        System.out.println("Exiting Hotel Reservation System.");
    }
}
 
