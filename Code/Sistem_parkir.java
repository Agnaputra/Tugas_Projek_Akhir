import java.util.Scanner;

public class Sistem_parkir{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        System.out.println("  _____        _____  _  _______ _   _  _____    _______     _______ _______ ______ __  __ ");
        System.out.println(" |  __ \\ /\\   |  __ \\| |/ /_   _| \\ | |/ ____|  / ____\\ \\   / / ____|__   __|  ____|  \\/  |");
        System.out.println(" | |__) /  \\  | |__) | ' /  | | |  \\| | |  __  | (___  \\ \\_/ / (___    | |  | |__  | \\  / |");
        System.out.println(" |  ___/ /\\ \\ |  _  /|  <   | | | . ` | | |_ |  \\___ \\  \\   / \\___ \\   | |  |  __| | |\\/| |");
        System.out.println(" | |  / ____ \\| | \\ \\| . \\ _| |_| |\\  | |__| |  ____) |  | |  ____) |  | |  | |____| |  | |");
        System.out.println(" |_| /_/    \\_\\_|  \\_\\_|\\_\\_____|_| \\_|\\_____| |_____/   |_| |_____/   |_|  |______|_|  |_|");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Selamat datang di Sistem Parkir");

        while (true) {
            System.out.println("==============================================================");
            System.out.println("|Pilih jenis kendaraan yang ingin dimasukkan data parkirnya |");
            System.out.println("==============================================================");
            System.out.println("1. Motorcycle");
            System.out.println("2. Car");
            System.out.println("3. Electric");
            System.out.println("0. Keluar");
            System.out.println("==============================================================");

            int vehicleChoice = input.nextInt();

            switch (vehicleChoice) {
                case 1:
                    parkMotorcycle(input);
                    break;
                case 2:
                    parkCar(input);
                    break;
                case 3:
                    parkElectric(input);
                    break;
                case 0:
                    System.out.println("Terima kasih. Keluar dari program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1 untuk Motorcycle, 2 untuk Car, 3 untuk Electric, atau 0 untuk keluar.");
            }
        }
    }

    // Method untuk parkir kendaraan motor
    private static void parkMotorcycle(Scanner input) {
        do {
            double totalCost, motorcycleParkingFee = 2000, parkingDuration, helmetStorageCost = 0, motorcycleStorageCostWash = 0;
            String userName, bikeType, licensePlate;
            boolean isHelmetStored, isMember, isMotorcycleWash;
            String membershipType = "";

            System.out.println("Enter user name:");
            userName = input.next();
            System.out.println("Enter license plate number:");
            licensePlate = input.next();
            System.out.println("Helmet drop off? (yes/no): ");
            isHelmetStored = input.next().equalsIgnoreCase("yes");

            // Helmet drop off
            if (isHelmetStored) {
                System.out.println("Choose helmet type (half/full): ");
                String helmetType = input.next();
                switch (helmetType.toLowerCase()) {
                    case "half":
                        helmetStorageCost = 2000;
                        break;
                    case "full":
                        helmetStorageCost = 3000;
                        break;
                    default:
                        System.out.println("Invalid helmet type. Use 'half' or 'full'.");
                        return;
                }
            }

            // Motorcycle wash
            System.out.println("Want to wash your motorcycle? (yes/no): ");
            isMotorcycleWash = input.next().equalsIgnoreCase("yes");

            if (isMotorcycleWash) {
                System.out.println("Choose motorcycle type (matic/manual): ");
                String motorcycleType = input.next();
                switch (motorcycleType.toLowerCase()) {
                    case "matic":
                        motorcycleStorageCostWash = 15000;
                        break;
                    case "manual":
                        motorcycleStorageCostWash = 20000;
                        break;
                    default:
                        System.out.println("Invalid motorcycle type. Use 'matic' or 'manual'.");
                }
            }

            // Parking time
            System.out.println("Enter parking duration (hours):");
            parkingDuration = input.nextDouble();

            if (parkingDuration <= 5) {
                totalCost = motorcycleParkingFee * parkingDuration;
            } else {
                totalCost = (motorcycleParkingFee * 5) + (motorcycleParkingFee * (parkingDuration - 5));
            }

            // Total harga penitipan helm + harga parkir
            if (isHelmetStored) {
                totalCost += helmetStorageCost;
                System.out.println("Helmet storage cost: " + helmetStorageCost);
            }

            // Membership
            System.out.println("Is the user a member? (yes/no): ");
            isMember = input.next().equalsIgnoreCase("yes");

            if (isMember) {
                System.out.println("Select membership type (1 = Regular, 2 = Premium, 3 = Executive): ");
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

            switch (membershipType) {
                case "Regular":
                    double discount = totalCost * 0.1;
                    totalCost -= discount;
                    System.out.println("Membership status: Regular");
                    System.out.println("Membership discount: " + discount);
                    break;
                case "Premium":
                    double discount2 = totalCost * 0.15;
                    totalCost -= discount2;
                    System.out.println("Membership status: Premium");
                    System.out.println("Membership discount: " + discount2);
                    break;
                case "Executive":
                    double discount3 = totalCost * 0.2;
                    totalCost -= discount3;
                    System.out.println("Membership status: Executive");
                    System.out.println("Membership discount: " + discount3);
                    break;
            }

            System.out.println("Membership Type: " + membershipType);
            System.out.println("Total Cost: " + totalCost);

            System.out.println("Do you want to enter another record? (yes/no): ");
        } while (input.next().equalsIgnoreCase("yes"));
    }

    // Method untuk parkir mobil
    private static void parkCar(Scanner input) {
        //VARIABEL CAR
        double totalharga , waktu, hargaparkir = 5000,hargacucimobil , tambahangin = 2000;
        boolean ingincucimobil , ingintambahangin, inginmember ; 
        String nama_user, platnomor, tipemobil ;

        //sistem pertama
        System.out.println("Input nama user");
        nama_user = input.next();
        System.out.println("Input plat nomor");
        platnomor = input.next();
        System.out.println("Tipe mobil");
        tipemobil = input.next();
        System.out.println("waktu");
        waktu = input.nextDouble();
        System.out.println("ingin cuci mobil atau tidak? (true/false)");
        ingincucimobil = input.nextBoolean();
        System.out.println("tambah angin? (true/false)");
        ingintambahangin = input.nextBoolean();

       
       
       
        // sistem selection
       if (ingincucimobil) 
       System.out.println("pilih jenis layanan cuci mobil (prem/reg)");
       String tipelayanan = input.next();
       if (tipelayanan.equalsIgnoreCase("prem")) {
           hargacucimobil = 20000;
       } else if (tipelayanan.equalsIgnoreCase("reg")){
           hargacucimobil = 30000;
       } else {
           System.out.println("input tidak valid gunakan (prem/reg)");
       return;
       }
      
      
      
      // harga parkir 
      System.out.println("harga parkir perjam = ");
      waktu = input.nextDouble();
       totalharga = (hargaparkir * waktu);


      // harga cuci mobil
       if (ingincucimobil) { 
         totalharga += hargacucimobil;
            System.out.println("harga titip cuci mobil" + hargacucimobil);
       }
       
       
       
           // tambah angin
        if (ingintambahangin) {
       totalharga = (tambahangin + totalharga);
       System.out.println("total pemabayaran = " + totalharga);
       }
       
       

       // menginput member atau tidak member
         System.out.println("apakah pengguna parkir adalah member? ( true/false)");
           inginmember = input.nextBoolean();

           // status dari member
       if (inginmember) {
           System.out.println("input status member (1 =  exsecutive) ( 2  = premium) (3= reguler)");
       int statusmember = input.nextInt();
       if (statusmember == 1) {
           System.out.println("executive"); ;
       } else if (statusmember == 2) {
           System.out.println("premium");;
       } else if (statusmember == 3) {
           System.out.println("reguler");;
       } else {
           System.out.println("input tidak valid (gunakan angka 1,2,3)");
       return;
       }
   }

// jenis status member
String jenismemberparkir = "";
if (jenismemberparkir.equals("executive")) {
   // diskon member parkir executive 20%
    double diskon = totalharga * 0.2;
   totalharga -= diskon;
   System.out.println("status member executive");
   System.out.println("status member executive " + diskon );

} if (jenismemberparkir.equals("premium")) {
// diskon member parkir executive 15% 
double diskon = totalharga * 0.15;
totalharga -= diskon;
System.out.println("status premium");
System.out.println("status member premium " + diskon );

}  if  (jenismemberparkir.equals("reguler")) {
   // diskon member parkir executive 10%
   double diskon = totalharga * 0.1;
   totalharga -= diskon;
   System.out.println("status member reguler");
   System.out.println("status member reguler " + diskon );
}
    }

    // Method untuk parkir kendaraan listrik
    private static void parkElectric(Scanner input) {
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
                    discount = totalCost * 0.05;
                } else if (membershipType.equals("Premium")) {
                    discount = totalCost * 0.1;
                } else if (membershipType.equals("Executive")) {
                    discount = totalCost * 0.15;
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
