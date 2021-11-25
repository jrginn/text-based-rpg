public class Attack {
    private String desc;
    private int dam;
    private String name;

    public Attack(String str, int x, String cur)
    {
        desc = str;
        dam = x;
        name = cur;
    }

    public String getDesc()
    {
        return desc;
    }

    public int getDam()
    {
        return dam;
    }

    public String toString()
    {
        return name + desc + " for " + dam + " damage.";
    }

}
