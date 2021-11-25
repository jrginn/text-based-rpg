public class Magic {
    private int dam;
    private String name;
    private int req;
    private int cost;

    public Magic(int theDam, String theName, int theReq, int theCost) {
        dam = theDam;
        name = theName;
        req = theReq;
        cost = theCost;
    }

    public int getDam() {
        return dam;
    }

    public String getName() {
        return name;
    }

    public int getReq()
    {
        return req;
    }

    public int getCost()
    {
        return cost;
    }

    public String toString()
    {
        return name + ": cost: " + cost;
    }
}
