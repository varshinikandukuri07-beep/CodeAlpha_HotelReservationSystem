
 import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] roomType = {"Standard", "Deluxe", "Suite"};
        boolean[] available = {true, true, true};
        String[] customer = {"", "", ""};

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nRoom Status:");

                    for (int i = 0; i < roomType.length; i++) {
                        System.out.println((i + 1) + ". "
                                + roomType[i] + " - "
                                + (available[i] ? "Available" : "Booked"));
                    }
                    break;

                case 2:
                    System.out.print("Enter Room Number (1-3): ");
                    int room = sc.nextInt();
                    sc.nextLine();

                    if (available[room - 1]) {

                        System.out.print("Enter Customer Name: ");
                        customer[room - 1] = sc.nextLine();

                        System.out.print("Enter Payment Amount: ₹");
                        int payment = sc.nextInt();

                        System.out.println("Payment Successful!");
                        available[room - 1] = false;

                        System.out.println("Room Booked Successfully!");

                    } else {
                        System.out.println("Room Already Booked!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel: ");
                    int cancel = sc.nextInt();

                    if (!available[cancel - 1]) {

                        available[cancel - 1] = true;
                        customer[cancel - 1] = "";

                        System.out.println("Reservation Cancelled!");

                    } else {
                        System.out.println("Room is already available.");
                    }
                    break;

                case 4:
                    System.out.println("\n===== BOOKING DETAILS =====");

                    boolean found = false;

                    for (int i = 0; i < roomType.length; i++) {

                        if (!available[i]) {

                            System.out.println("Customer Name : " + customer[i]);
                            System.out.println("Room Type     : " + roomType[i]);
                            System.out.println("-------------------------");

                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No Bookings Found.");
                    }

                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}