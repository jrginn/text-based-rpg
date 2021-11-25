public class Weapon {
    private String name;
    private int power;
    private int req;
    private int cost;

    public Weapon(String name, int power, int req, int cost)
    {
        this.name = name;
        this.power = power;
        this.req = req;
        this.cost = cost;
    }

    public String getName()
    {
        return name;
    }

    public int getPower()
    {
        return power;
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
        return "This is a " + name + " with " + power + " power \nThe hero must be at least level " + " to use it.";
    }
}
