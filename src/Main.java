import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    final static int airportsLimit = 2;
    static Airport airports[] = new Airport[airportsLimit];

    public static void main(String[] args) {

        insertDataAirports(airports);
        menu();

    }

    public static void insertDataAirports(Airport[] air) {
        air[0] = new PublicAirport("Barajas", "Madrid", "Spain", 80000000);
        air[0].insertCompanie(new Company("Iberia"));
        air[0].insertCompanie(new Company("AirEuropa"));
        air[0].getCompanie("Iberia").insertFly(new Fly("AA01", "Madrid", "Paris", 150.90, 100));
        air[0].getCompanie("Iberia").insertFly(new Fly("AA02", "Paris", "Madrid", 175, 120));
        air[0].getCompanie("AirEuropa").insertFly(new Fly("BB03", "London", "Madrid", 220.99, 200));
        air[0].getCompanie("Iberia").getFly("AA01").insertPassenger(new Passenger("Alex", "486XJ", "Spanish"));
        air[0].getCompanie("Iberia").getFly("AA01").insertPassenger(new Passenger("Maria", "PJK35", "Mexican"));
        air[0].getCompanie("AirEuropa").getFly("BB03").insertPassenger(new Passenger("Luis", "858FJ", "Spanish"));

        air[1] = new PrivateAirport("privateAirportExample", "Barcelona", "Spain");
        air[1].insertCompanie(new Company("RyanAir"));
        String[] enterprises = {"Iberdrola", "Amazon"};
        ((PrivateAirport) air[1]).insertEnterprises(enterprises);
        air[1].getCompanie("RyanAir").insertFly(new Fly("CC03", "Madrid", "Paris", 500, 50));
        air[1].getCompanie("RyanAir").getFly("CC03").insertPassenger(new Passenger("Juan", "58F89", "Spanish"));
    }

    public static void menu() {
        int option;
        String airportName, companyName, origin, destiny;
        Airport airport;
        Company company;

        do {
            System.out.println("\n\tMENU");
            System.out.println("1. Consult gestioned airports (Public or Private)");
            System.out.println("2. Check enterprises (Private) or subvention (Public)");
            System.out.println("3. Check all companies of an airport");
            System.out.println("4. Check flies in a companie");
            System.out.println("5. Check all flies from city to destiny");
            System.out.println("6. EXIT");
            System.out.print("Option: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    consultAirports();
                    break;
                case 2:
                    checkModel();
                    break;
                case 3:
                    System.out.println("Introduce the name of the airport: ");
                    sc.nextLine();
                    airportName = sc.nextLine();
                    airport = searchAirport(airportName, airports);
                    if (airport == null) {
                        System.out.println("The airport does not exist");
                    }
                    else {
                        showCompanies(airport);
                    }
                    break;
                case 4:
                    System.out.println("Introduce the name of the airport: ");
                    sc.nextLine();
                    airportName = sc.nextLine();
                    airport = searchAirport(airportName, airports);
                    if (airport == null) {
                        System.out.println("The airport does not exist");
                    }
                    else {
                        System.out.println("Introduce the name of the company");
                        companyName = sc.nextLine();
                        company = airport.getCompanie(companyName);
                        checkFlies(company);
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("\nIntroduce the origin city:");
                    origin = sc.nextLine();
                    System.out.println("Introduce the destiny city");
                    destiny = sc.nextLine();
                    showDestinyOriginFly(origin,destiny,airports);
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        } while (option != 6);
    }

    public static void consultAirports() {
        for (int i = 0; i < airportsLimit; i++) {
            System.out.println("The airport number " + i + " details are the next ones: ");
            System.out.println("Name: " + airports[i].getName());
            System.out.println("City: " + airports[i].getCity());
            System.out.println("Country: " + airports[i].getCountry());

            if (airports[i] instanceof PublicAirport) {
                System.out.println("Airport model: Public");
            }
            else {
                System.out.println("Airport model: Private");
            }
            System.out.println("");
        }
    }

    public static void checkModel() {
        for (int i = 0; i < airportsLimit; i++) {
            if (airports[i] instanceof PublicAirport) {
                System.out.println("The airport number " + i + " is public.");
                System.out.println("The subvention is: " + ((PublicAirport) airports[i]).getSubvention() + " dollars");
            }
            else {
                System.out.println("The airport number " + i + " is private.\nThe enterprises that finance it are the following ones: ");

                for (String e : ((PrivateAirport) airports[i]).getEnterprises()) {
                    System.out.println(i + ". " + e);
                }
            }
        }
    }

    public static Airport searchAirport(String name, Airport airports[]) {
        for (Airport a : airports) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

    public static void showCompanies(Airport airport) {
        System.out.println("\nThe companies are the following ones: ");
        for (int i = 0; i < airport.getCompanieNumber(); i++) {
            System.out.println(airport.getCompanie(i).getName());
        }
    }

    public static void checkFlies(Company company) {
        Fly fly;
        System.out.println("The flies are the following ones: ");
        for (int i = 0; i < company.getFlyNumber(); i++) {
            fly = company.getFly(i);
            System.out.println("Identifier: " + fly.getIdentifier());
            System.out.println("Origin city: " + fly.getOriginCity());
            System.out.println("Destiny city: " + fly.getDestinyCity());
            System.out.println("Price: " + fly.getPrice() + " $");
            System.out.println("");
        }
    }

    public static Fly[] searchDestinyOriginFly(String origin, String destiny, Airport[] airports) {
        Fly fly;
        int counter = 0;
        Fly[] flies;
        for (int i = 0; i < airports.length; i++) {
            for (int j = 0; j < airports[i].getCompanieNumber(); j++) {
                for (int k = 0; k < airports[i].getCompanie(j).getFlyNumber(); k++) {
                    fly = airports[i].getCompanie(j).getFly(k);
                    if ((origin.equals(fly.getOriginCity())) && (destiny.equals(fly.getDestinyCity()))) {
                        counter++;
                    }
                }
            }
        }

        flies = new Fly[counter];
        int q = 0;

        for (int i = 0; i < airports.length; i++) {
            for (int j = 0; j < airports[i].getCompanieNumber(); j++) {
                for (int k = 0; k < airports[i].getCompanie(j).getFlyNumber(); k++) {
                    fly = airports[i].getCompanie(j).getFly(k);
                    if ((origin.equals(fly.getOriginCity())) && (destiny.equals(fly.getDestinyCity()))) {
                        flies[q] = fly;
                        q++;
                    }
                }
            }
        }

        return flies;
    }

    public static void showDestinyOriginFly(String origin, String destiny, Airport[] airports) {
        Fly flies[];
        flies = searchDestinyOriginFly(origin, destiny, airports);
        if (flies.length == 0) {
            System.out.println("No flies existant with that origin and destiny");
        }
        else {
            for (int i = 0; i < flies.length; i++) {
                System.out.println("Identifier: " + flies[i].getIdentifier());
                System.out.println("Origin: " + flies[i].getOriginCity());
                System.out.println("Destiny: " + flies[i].getDestinyCity());
                System.out.println("Price: " + flies[i].getPrice() + " $");
                System.out.println("");
            }
        }
    }
}