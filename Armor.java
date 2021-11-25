public class Armor {
    private String name;
    private int resist;
    private int req;

    public Armor(String name, int resist, int req)
    {
        this.name = name;
        this.resist = resist;
        this.req = req;
    }

    public String getName()
    {
        return name;
    }

    public int getResist()
    {
        return resist;
    }

    public boolean isWeapon()
    {
        return false;
    }

    public int getReq()
    {
        return req;
    }

    public String toString()
    {
        return "This is a " + name + " with " + resist + " resist. \nIt requires level " + req + ".";
    }
}
