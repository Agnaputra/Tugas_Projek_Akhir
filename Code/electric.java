
import java.util.Scanner;

public class electric {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

 // VARIABLES
        double parkingPrice, chargingRate;
        String name, platenumber;
        boolean isMember = false;
        double parkingDurationHours = 0;

        do {
            System.out.println("Input name user");
            name = input.next();
            System.out.println("Do you have a membership? (yes/no):");
            isMember = input.next().equalsIgnoreCase("yes");

            String membershipType = "Non-Member";

            if (isMember) {
                System.out.println("Select membership type (1 = Regular(5%), 2 = Premium(10%), 3 = Executive(15%)): ");
                int membershipChoice = input.nextInt();
                switch (membershipChoice) {
                    case 1:
                        membershipType = "Regular";
                        break;
                    case 2:
                        membershipType = "Premium";
                        break;
                    case 3:
                        membershipType = "Executive";
                        break;
                    default:
                        System.out.println("Invalid membership type. Use 1 for Regular, 2 for Premium, or 3 for Executive.");
                        return;
                }
            }

            System.out.println("Choose a vehicle: ");
            System.out.println("1. Electric Car");
            System.out.println("2. Electric Motorcycle");
            int choicetype = input.nextInt();

            switch (choicetype) {
                case 1:
                    System.out.println("You chose an Electric Car.");
                    System.out.println("Input plate number");
                    platenumber = input.next();
                    parkingPrice = 5000.00; //parking price for electric cars
                    chargingRate = 1000.00; //charging rate for electric cars
                    break;
                case 2:
                    System.out.println("You chose an Electric Motorcycle.");
                    System.out.println("Input plate number");
                    platenumber = input.next();
                    parkingPrice = 2000.00; //parking price for electric motorcycles
                    chargingRate = 500.00; //charging rate for electric motorcycles
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1 for Electric Car or 2 for Electric Motorcycle.");
                    return;
            }

            System.out.println("Press '1' to calculate cost without charging or '2' to calculate cost with charging.");
            System.out.print("Enter your choice: ");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter parking duration (in hours): ");
                    parkingDurationHours = input.nextDouble();
                    break;
                case 2:
                    System.out.print("Enter parking duration (in hours): ");
                    parkingDurationHours = input.nextDouble();
                    System.out.println("Charging started...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter '1' or '2'.");
                    return;
            }

            double parkingCost = parkingDurationHours * parkingPrice;
            double chargingCost = (userChoice == 2) ? parkingDurationHours * chargingRate : 0;

            double totalCost = parkingCost + chargingCost;

            double discount = 0.0;
            if (isMember) { // Check the membership status
                if (membershipType.equals("Regular")) {
                    discount = totalCost * 0.1;
                } else if (membershipType.equals("Premium")) {
                    discount = totalCost * 0.15;
                } else if (membershipType.equals("Executive")) {
                    discount = totalCost * 0.2;
                }
            }

            totalCost -= discount;

            System.out.println("==============================================================");
            System.out.println("Membership Type: " + membershipType);
            System.out.println("Parking Duration: " + parkingDurationHours + " hours");
            System.out.println("Parking Cost: Rp" + parkingCost);
            if (userChoice == 2) {
                System.out.println("Charging Duration: " + parkingDurationHours + " hours");
                System.out.println("Charging Cost: Rp" + chargingCost);
            }
            System.out.println("==============================================================");
            System.out.println("Total Cost: " + totalCost);
            System.out.println("==============================================================");

            System.out.println("Do you want to calculate cost again? (yes/no):");
        } while (input.next().equalsIgnoreCase("yes"));
    }
}