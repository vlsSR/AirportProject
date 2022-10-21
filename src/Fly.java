public class Fly {
    private String identifier;
    private String originCity;
    private String destinyCity;
    private double price;
    private int maxPassenger;
    private int counterPassenger;
    private Passenger[] listPassengers;


    public Fly(String identifier, String originCity, String destinyCity, double price, int maxPassenger) {
        this.identifier = identifier;
        this.originCity = originCity;
        this.destinyCity = destinyCity;
        this.price = price;
        this.maxPassenger = maxPassenger;
        this.counterPassenger = 0;
        this.listPassengers = new Passenger[maxPassenger];
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getOriginCity() {
        return originCity;
    }

    public String getDestinyCity() {
        return destinyCity;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public int getCounterPassenger() {
        return counterPassenger;
    }

    public void insertPassenger(Passenger passenger){
        listPassengers[counterPassenger] = passenger;
        counterPassenger++;
    }

    public Passenger getPassenger(int i) {
        return listPassengers[i];
    }

    public Passenger getPassenger(String passport) {
        for(Passenger i: listPassengers) {
            if (i.getPassport().equals(passport)) {
                return i;
            }
        }
        return null;
    }
}
