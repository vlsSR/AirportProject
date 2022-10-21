public class Passenger {
    private String name;
    private String passport;
    private String nacionality;

    public Passenger(String name, String passport, String nacionality) {
        this.name = name;
        this.passport = passport;
        this.nacionality = nacionality;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    public String getNacionality() {
        return nacionality;
    }
}
