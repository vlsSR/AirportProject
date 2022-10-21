public class Airport {
    private String name;
    private String city;
    private String country;
    private Company[] listCompanies = new Company[10];
    private int companieNumber;

    public Airport(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.companieNumber = 0;
    }

    public Airport(String name, String city, String country, Company[] listCompanies) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.listCompanies = listCompanies;
        this.companieNumber = listCompanies.length;
    }

    public void insertCompanie(Company company) {
        listCompanies[companieNumber] = company;
        companieNumber++;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Company[] getListCompanies() {
        return listCompanies;
    }

    public int getCompanieNumber() {
        return companieNumber;
    }

    public Company getCompanie(int i) {
        return listCompanies[i];
    }

    public Company getCompanie(String name) {
        for(Company company : listCompanies) {
            if(company.getName().equals(name)) {
                return company;
            }
        }
        return null;
    }
}
