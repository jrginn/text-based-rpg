import java.util.*;

public class Player {
    private int hp;
    private int level;
    private String name;
    private int exp;
    private int power;
    private int resist;
    private Armor armor;
    private Weapon weapon;
    private int req;
    private ArrayList<Magic> pos;
    private ArrayList<Magic> magics;
    private int stamina;
    private int mp;

    public Player(int theHp, int theLevel, String theName, int theExp, int thePower, int theResist, ArrayList<Magic> possible)
    {
        hp = theHp;
        level = theLevel;
        name = theName;
        exp = theExp;
        armor = new Armor("Weak Leather", 0, 0);
        weapon = new Weapon("Rusty Sword", 0, 0, 0);
        power = thePower;
        resist = theResist;
        req = 70;
        pos = possible;
        magics = new ArrayList<>();
        stamina = 3;
        mp = 2;
        for(int i = 0; i < pos.size(); i++)
        {
            if(pos.get(i).getReq() <= level && !magics.contains(pos.get(i)))
            {
                magics.add(pos.get(i));
                System.out.println(name + " can now use " + pos.get(i).getName());
            }
        }
    }

    public int getHp()
    {
        return hp;
    }

    public void addExp(int amount)
    {
        exp += amount;
        if(exp >= req)
        {
            level++;
            System.out.println(name + " is now level " + level + "!");
            hp += 2;
            exp -= req;
            req += 5;
            power++;
            resist++;
            if(Randomizer.nextBoolean(.3))
            {
                mp += 3;
            }
            else
            {
                mp+= 2;
            }
            for(int i = 0; i < pos.size(); i++)
            {
                if(pos.get(i).getReq() <= level && !magics.contains(pos.get(i)))
                {
                    magics.add(pos.get(i));
                    System.out.println(name + " can now use " + pos.get(i).getName());
                }
            }
        }
    }

    public void equip(Armor equippable)
    {
        resist -= armor.getResist();
        armor = equippable;
        resist +=  equippable.getResist();
    }

    public void equip(Weapon equippable)
    {
        power -= weapon.getPower();
        weapon = equippable;
        power += equippable.getPower();
    }

    public int getPower()
    {
        return power;
    }

    public int getResist()
    {
        return resist;
    }

    public int getLevel()
    {
        return level;
    }

    public String getName()
    {
        return name;
    }

    public int getStamina()
    {
        return stamina;
    }

    public int getMp()
    {
        return mp;
    }

    public List<Magic> getMagics()
    {
        return magics;
    }

    public String toString()
    {
        return "The hero " + name + " has " + hp + " HP. \nThey are level " + level + " and have " + exp + " exp. \nThey are equipped with " + armor.getName() + " and " + weapon.getName() + "." + "\nTheir power is " + power + " and their resist is " + resist + ".";
    }
}
