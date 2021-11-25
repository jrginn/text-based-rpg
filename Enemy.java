public class Enemy {
    private int hp;
    private String name;
    private int exp;
    private int power;
    private int resist;
    private Armor dropA;

    public Enemy()
    {
        hp = 0;
        name = "";
        exp = 0;
        power = 0;
        resist = 0;
        dropA = null;
    }


    public Enemy(int theHp, String theName, int theExp, int thePower, int theResist, Armor theDropA)
    {
        hp = theHp;
        name = theName;
        exp = theExp;
        power = thePower;
        resist = theResist;
        dropA = theDropA;
    }

    public int getPower()
    {
        return power;
    }

    public int getHp()
    {

        return hp;
    }

    public int getResist()
    {
        return resist;
    }

    public Armor dropArmor()
    {
        return dropA;
    }

    public int giveExp()
    {
        return exp;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return "This is a " + this.getName() +  " that gives " + exp + " exp points. \nIt has " + power + " power and " + resist + " resist. \nIt drops a "  + dropA.getName() + ".";
    }
}
