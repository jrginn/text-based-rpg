public class Boss extends Enemy{
    private int hp;
    private String name;
    private int exp;
    private int power;
    private int resist;
    private Attack spec;

    public Boss(int theHp, String theName, int theExp, int thePower, int theResist, Attack theSpec)
    {
        hp = theHp;
        name = theName;
        exp = theExp;
        power = thePower;
        resist = theResist;
        spec = theSpec;
    }

    public Attack getSpec()
    {
        return spec;
    }

    @Override
    public int getHp() {
        return hp;
    }

    public String getName()
    {
        return name;
    }

    public int getPower()
    {
        return power;
    }

    @Override
    public int getResist() {
        return resist;
    }
}
