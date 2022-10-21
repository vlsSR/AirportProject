import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    final static int num = 2;
    static Airport airports[] = new Airport[num];

    public static void main(String[] args) {

        insertDataAirports(airports);
        menu();

    }

    public static void insertDataAirports(Airport[] air) {
        air[0] = new PublicAirport("Barajas", "Madrid", "Spain",80000000);
        air[0].insertCompanie(new Companie("Iberia"));
        air[0].insertCompanie(new Companie("AirEuropa"));
        air[0].getCompanie("Iberia").insertFly(new Fly("AA01","Madrid","Paris", 150.90, 100));
        air[0].getCompanie("Iberia").insertFly(new Fly("AA02", "Paris", "Madrid", 175, 120));
        air[0].getCompanie("AirEuropa").insertFly(new Fly("BB03", "London", "Madrid", 220.99, 200));
        air[0].getCompanie("Iberia").getFly("AA01").insertPassenger(new Passenger("Alex", "486XJ", "Spanish"));
        air[0].getCompanie("Iberia").getFly("AA01").insertPassenger(new Passenger("Maria", "PJK35", "Mexican"));
        air[0].getCompanie("AirEuropa").getFly("BB03").insertPassenger(new Passenger("Luis", "858FJ", "Spanish"));

        air[1] = new PublicAirport("privateAirportExample" , "Barcelona" ,"Spain");
        air[1].insertCompanie(new Companie("RyanAir"));
        String[] enterprises = {"Iberdrola", "Amazon"};
        ((PrivateAirport)air[1]).insertEnterprises(enterprises);
        air[1].getCompanie("RyanAir").insertFly(new Fly("CC03", "Barcelona", "London", 500, 50));
        air[1].getCompanie("RyanAir").getFly("CC03").insertPassenger(new Passenger("Juan", "58F89", "Spanish"));
    }

    public static void menu() {
        int option;

        do{
            System.out.println("\tMENU");
            System.out.println("1. Consult gestioned airports (Public or Private)");
            System.out.println("2. Check enterprises (Private) or subvention (Public)");
            System.out.println("3. Companie list of an airport");
            System.out.println("4. Check fly list in companies");
            System.out.println("5. Check all flies from city to destiny");
            System.out.println("6. EXIT");
            System.out.print("Option: ");

            option = sc.nextInt();

            switch (option){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6: break;
                default:
                    System.out.println("Incorrect option");
            }
        }while(option != 6);
    }
}