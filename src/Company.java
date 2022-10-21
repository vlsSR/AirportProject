public class Company {
    private String name;
    private Fly[] listFlies = new Fly[10];
    private int flyNumber = 0;

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, Fly[] listFlies) {
        this.name = name;
        this.listFlies = listFlies;
        flyNumber = listFlies.length;
    }

    public void insertFly(Fly fly){
        listFlies[flyNumber] = fly;
        flyNumber++;
    }

    public String getName() {
        return name;
    }

    public int getFlyNumber() {
        return flyNumber;
    }

    public Fly getFly(int i) {
        return listFlies[i];
    }

    public Fly getFly(String id) {
        for(Fly f: listFlies){
            if(f.getIdentifier().equals(id)){
                return f;
            }
        }
        return null;
    }
}
