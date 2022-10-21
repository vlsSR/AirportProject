public class Airport {
    private String name;
    private String city;
    private String country;
    private Companie[] listCompanies = new Companie[10];
    private int companieNumber;

    public Airport(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.companieNumber = 0;
    }

    public Airport(String name, String city, String country, Companie[] listCompanies) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.listCompanies = listCompanies;
        this.companieNumber = listCompanies.length;
    }

    public void insertCompanie(Companie companie) {
        listCompanies[companieNumber] = companie;
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

    public Companie[] getListCompanies() {
        return listCompanies;
    }

    public int getCompanieNumber() {
        return companieNumber;
    }

    public Companie getCompanie(int i) {
        return listCompanies[i];
    }

    public Companie getCompanie(String name) {
        for(Companie companie: listCompanies) {
            if(companie.getName().equals(name)) {
                return companie;
            }
        }
        return null;
    }
}
