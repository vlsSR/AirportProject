public class PrivateAirport extends Airport{


    private String[] enterprises = new String[10];
    private int enterpriseCounter;

    public PrivateAirport(String name, String city, String country) {
        super(name, city, country);

    }

    public PrivateAirport(String name, String city, String country, Company[] listCompanies, String[] enterprises) {
        super(name, city, country, listCompanies);
        this.enterprises = enterprises;
        this.enterpriseCounter = enterprises.length;
    }

    public String[] getEnterprises() {
        return enterprises;
    }

    public void insertEnterprises(String[] enterprises) {
        this.enterprises = enterprises;
        this.enterpriseCounter = enterprises.length;
    }

    public void insertEnterprise(String enterprise) {
        enterprises[enterpriseCounter] = enterprise;
    }
}
