public class PublicAirport extends Airport{
    private double subvention;

    public PublicAirport(String name, String city, String country) {
        super(name, city, country);
    }

    public PublicAirport(String name, String city, String country, Companie[] listCompanies, double subvention) {
        super(name, city, country, listCompanies);
        this.subvention = subvention;
    }

    public PublicAirport(String name, String city, String country, double subvention) {
        super(name, city, country);
        this.subvention = subvention;
    }

    public double getSubvention() {
        return subvention;
    }
}
