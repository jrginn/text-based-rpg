import java.util.*;
public class MyProgram
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // initializes "inventory"
        HashMap<Integer, Armor> invA = new HashMap<Integer, Armor>();
        HashMap<Integer, Weapon> invW = new HashMap<Integer, Weapon>();
        int newKeyA = 1;
        int newKeyW = 1;
        // initializes armor
        Armor brLe = new Armor("Broken leather armor", 2, 1);
        Armor weLe = new Armor("Weak leather armor", 3, 1);
        Armor meLe = new Armor("Medium leather armor", 4, 2);
        Armor stLe = new Armor("Strong leather armor", 5, 3);
        Armor weIr = new Armor("Weak iron armor", 7, 7);
        Armor meIr = new Armor("Medium iron armor", 9, 9);
        Armor stIr = new Armor("Strong iron armor", 11, 11);
        Armor weSt = new Armor("Weak steel armor", 12, 14);
        Armor meSt = new Armor("Medium steel armor", 15,  17);
        Armor stSt = new Armor("Strong steel armor", 20, 19);
        Armor ult =  new Armor("Aegis", 40, 20);
        // initializes weapons
        Weapon weKn = new Weapon("Weak knife", 2, 1, 30);
        Weapon meKn = new Weapon("Medium knife", 3, 2, 70);
        Weapon stKn= new Weapon("Strong knife", 5, 3, 100);
        Weapon weSp= new Weapon("Weak spear", 6, 7, 125);
        Weapon meSp= new Weapon("Medium spear", 8, 9, 145);
        Weapon stSp= new Weapon("Strong spear", 11, 11, 170);
        Weapon weGs = new Weapon("Weak greatsword", 12, 14, 190);
        Weapon meGs = new Weapon("Medium greatsword", 15, 17, 235);
        Weapon stGs = new Weapon("Strong greatsword", 20, 19, 400);
        Weapon pow = new Weapon("Excalibur", 40, 20, 750);
        // initializes magic
        Magic emb = new Magic(2, "ember", 1, 1);
        Magic spa = new Magic(3, "spark", 2, 2);
        Magic fir = new Magic(5, "fire", 3, 3);
        Magic rce = new Magic(7, "force", 8, 5);
        Magic sum = new Magic(10, "weak summon", 10, 7);
        Magic fre = new Magic(13, "freeze", 13, 10);
        Magic thu = new Magic(16,  "thunderbolt", 16, 13);
        Magic inf = new Magic(19, "inferno", 19, 16);
        Magic moo = new Magic(23, "great cow summon", 22, 22);
        ArrayList<Magic> poss = new ArrayList<>();
        poss.add(emb);
        poss.add(spa);
        poss.add(fir);
        poss.add(rce);
        poss.add(sum);
        poss.add(fre);
        poss.add(thu);
        poss.add(inf);
        poss.add(moo);
        // initializes shop
        Weapon[] shop1 = {weKn, meKn, stKn};
        Weapon[] shop2 = {weSp, meSp, stSp};
        Weapon[] shop3 = {weGs, meGs, stGs, pow};
        // initializes enemies
        Enemy tree = new Enemy(4, "Tree", 30, 0, 0, brLe);
        Enemy thief = new Enemy(7, "Thief", 35, 1, 1, weLe);
        Enemy merc = new Enemy(9, "Mercenary", 40, 2, 2, meLe);
        Enemy chief = new Enemy(12, "Chief", 50, 4, 3, stLe);
        Enemy gob = new Enemy(16, "Goblin", 60, 9, 8, weIr);
        Enemy orc = new Enemy(20, "Orc", 75, 13, 12, meIr);
        Enemy troll = new Enemy(23, "Troll", 80, 16, 13, stIr);
        Enemy liz = new Enemy(37, "Lizard", 95, 23, 20, weSt);
        Enemy hat = new Enemy(40, "Dragon Hatchling", 110, 26, 22, meSt);
        Enemy ghast = new Enemy(43, "Ghast",  125, 29, 24, stSt);
        Enemy guard = new Enemy(52, "Dragon Guard", 175, 33, 33, ult);
        // initializes bosses and attacks
        Attack viSl = new Attack(" does a vicious slash ", 10, "Warlord");
        Boss warlord = new Boss(25, "Warlord", 110, 10, 9, viSl);
        Attack suMi = new Attack(" summons a swarm of minions ", 15, "Monster King");
        Boss monsKing = new Boss(40, "Monster King", 220, 24, 21, suMi);
        Attack imm = new Attack(" immolates the hero ", 27, "Dragon");
        Boss dragon = new Boss(65, "Dragon", 500, 55, 55, imm);
        // initializes pool of enemies
        Enemy[] init = {thief, thief, thief, thief, thief, merc, merc, merc, chief, chief};
        Enemy[] midla = {gob, gob, gob, gob, gob, gob, orc, orc, troll, troll};
        Enemy[] lair = {liz, liz, liz, hat, hat, hat, ghast, ghast, ghast, liz, liz, liz, hat, hat, guard};
        Boss[] arr = {warlord, monsKing, dragon};
        // initializes 2d arrays
        Weapon[][] sho = {shop1, shop2, shop3};
        Enemy [][] rand = {init, midla, lair};
        // starts the adventure
        System.out.println("What is the hero's name? ");
        String name = sc.nextLine();
        // initializes player object
        Player user = new Player(10, 1, name, 0, 1, 1, poss);
        Enemy cur = null;
        Armor addA = null;
        Weapon addW = null;
        Weapon pur = null;
        int gp = 0;
        System.out.println("This is the quest of " + name + ".");
        System.out.println(name + " is currently living in Initium, a peaceful town.");
        System.out.println("One day, an evil dragon comes to their town and destroys it.");
        System.out.println("Guide " + name + " on their quest to avenge their town!");
        System.out.println(name + " must get some better equipment before leaving.");
        System.out.println(name + " decides to fight a tree to practice.");
        System.out.println("The battle is starting!");
        cur = tree;
        int z = battle(user, cur);
        if(z == 1)
        {
            gp += 50;
            addA = cur.dropArmor();
            invA.put(newKeyA, addA);
            newKeyA++;
            user.addExp(cur.giveExp());
        }
        else if(z == -1)
        {
            gp -= 25;
            if(gp < 0)
            {
                gp = 0;
            }
        }
        else
        {
            System.out.println("You couldn't even win the first fight without spamming. Good job idiot.");
            return;
        }
        System.out.println("Now " + name + " has some gold and can buy a new weapon.");
        pur = shop(gp, shop1);
        gp -= pur.getCost();
        invW.put(newKeyW, pur);
        newKeyW++;
        System.out.println("Now " + name + " must equip the new weapon.");
        addW = equipWeapon(invW, user);
        user.equip(addW);
        System.out.println("Equip the armor piece from the tree.");
        addA = equipArmor(invA, user);
        user.equip(addA);
        System.out.println("Now " + name + " is ready to fight the bandits.");
        System.out.println("Fight the bandits until you  are ready to take on the boss.");
        int tri = bulk(user, 0, newKeyA, newKeyW, gp, invA, invW, sho, rand, arr);
    }

    public static int battle(Player user, Enemy cur)
    {
        int usHp = user.getHp();
        int usPow = user.getPower();
        int usRes = user.getResist();
        int curHp = cur.getHp();
        int curPow = cur.getPower();
        int curRes = cur.getResist();
        int usDam = usPow - curRes;
        int curDam = curPow - usRes;
        int stam = user.getStamina();
        int mp = user.getMp();
        int turnNum = 1;
        System.out.println(user.getName() + " attacks a " + cur.getName());
        if(curDam <= 0)
        {
            curDam = 1;
        }
        if(usDam <= 0)
        {
            System.out.println("The battle is hopeless.");
            return -2;
        }
        int numPotions = 3;
        int x = 0;
        Scanner s = new Scanner(System.in);
        while(usHp > 0 && curHp > 0)
        {
            System.out.println("Your hp: " + usHp + ". Enemy's hp: " + curHp + ". Number of potions: " + numPotions);
            System.out.println("Your stamina: " + stam + ". Your magic points: " + mp);
            System.out.println("Press 1 to attack. \nPress 2 to try a strong attack \nPress 3 to use magic. \nPress 4 to heal if you have enough potions. ");
            x = s.nextInt();
            System.out.println("");
            if(x == 1 && stam > 0)
            {
                if(Randomizer.nextBoolean(.35))
                {
                    System.out.println(user.getName() + " got a critical hit!");
                    curHp -= usDam * 1.5;
                }
                else
                {
                    curHp -= usDam;
                }
                stam--;
            }
            else if(x == 1 && stam <= 0)
            {
                return -3;
            }
            else if(x == 2)
            {
                if(Randomizer.nextBoolean(.4))
                {
                    System.out.println("You  hit!");
                    curHp -= 2 * usDam;
                }
                else
                {
                    System.out.println("You missed!");
                }
                stam--;
            }
            else if(x == 4 && numPotions > 0)
            {
                System.out.println("Press 1 to heal. Press 2 to restore mp");
                int z = s.nextInt();
                if(z == 1) {
                    usHp += user.getHp() / 4;
                    if (usHp > user.getHp()) {
                        usHp = user.getHp();
                    }
                }
                else if(z == 2)
                {
                    mp += user.getMp() / 5;
                    if(mp > user.getMp())
                    {
                        mp = user.getMp();
                    }
                }
                numPotions--;

            }
            else if(x == 3 && mp > 0)
            {
                List<Magic> lis = user.getMagics();
                for(int i = 0; i < lis.size(); i++)
                {
                    System.out.println("Press " + i + " for: " + lis.get(i));
                }
                int y = s.nextInt();
                if(y < lis.size() && lis.get(y) != null && (mp - lis.get(y).getCost()) >= 0)
                {
                    System.out.println(user.getName() + " used " + lis.get(y).getName());
                    curHp -= lis.get(y).getDam();
                    mp -= lis.get(y).getCost();
                }
            }
            if(curHp  <= 0)
            {
                System.out.println("You won!");
                System.out.println("");
                return 1;
            }
            if(Randomizer.nextBoolean(.25))
            {
                System.out.println(cur.getName() + " got a critical hit!");
                usHp -= 2 * curDam;
            }
            else
            {
                usHp -= curDam;
            }
            System.out.println("");
            if(turnNum%3 == 0)
            {
                if(stam <= 0) {
                    stam += 2;
                }
                else
                {
                    stam ++;
                }
                if(stam > user.getStamina())
                {
                    stam = user.getStamina();
                }
            }
            turnNum++;
        }
        System.out.println("You lost.");
        return -1;
    }

    public static Weapon shop(int gp, Weapon[] shop)
    {
        System.out.println("You have " + gp + " gold.");
        Scanner sca = new Scanner(System.in);
        for(int i = 0; i <shop.length;i++)
        {
            System.out.println("Press " + i + " for " + shop[i].getName());
            System.out.println("Its power is " + shop[i].getPower() + " and it costs " + shop[i].getCost());
            System.out.println("");
        }
        System.out.println("Choose what weapon you want or type in 999 to exit ");
        int ch = sca.nextInt();
        if(ch == 999)
        {
            return null;
        }
        if(ch < shop.length && ch >= 0)
        {
            if(shop[ch].getCost() <= gp)
            {
                System.out.println("You bought a " + shop[ch].getName());
                return shop[ch];
            }
            else
            {
                System.out.println("You cannot afford this.");
                System.out.println("");
                return shop(gp, shop);
            }
        }
        else
        {
            System.out.println("This item does not exist.");
            System.out.println("");
            return shop(gp, shop);
        }
    }

    public static Weapon equipWeapon(HashMap<Integer, Weapon> map, Player user)
    {
        System.out.println("Input the corresponding number.");
        for(Integer i: map.keySet())
        {
            String str = (map.get(i)).getName();
            System.out.println(i + ": " + str);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose from inventory. ");
        int f = sc.nextInt();
        if(map.containsKey(f))
        {
            if(map.get(f).getReq() <= user.getLevel())
            {
                return map.get(f);
            }
            else{
                System.out.println("Level is too low");
                return equipWeapon(map, user);
            }

        }
        else
        {
            return equipWeapon(map, user);
        }
    }

    public static Armor equipArmor(HashMap<Integer, Armor> map, Player user)
    {
        System.out.println("Input the corresponding number.");
        for(Integer i: map.keySet())
        {
            String str = (map.get(i)).getName();
            System.out.println(i + ": " + str);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose from inventory. ");
        int f = sc.nextInt();
        if(map.containsKey(f))
        {
            if(map.get(f).getReq() <= user.getLevel())
            {
                return map.get(f);
            }
            else{
                System.out.println("Level is too low");
                return equipArmor(map, user);
            }
        }
        else
        {
            return equipArmor(map, user);
        }
    }

    public static boolean bossBattle(Boss cur, Player user)
    {
        int usHp = user.getHp();
        int usPow = user.getPower();
        int usRes = user.getResist();
        int curHp = cur.getHp();
        int curPow = cur.getPower();
        int curRes = cur.getResist();
        int usDam = usPow - curRes;
        int curDam = curPow - usRes;
        int stam = user.getStamina();
        int mp = user.getMp();
        int turnNum = 1;
        System.out.println(user.getName() + " challenges " + cur.getName() + "!");
        if(curDam <= 0)
        {
            curDam = 1;
        }
        if(usDam <= 0)
        {
            System.out.println("The battle is hopeless.");
            return false;
        }
        int numPotions = 2;
        int x = 0;
        Scanner s = new Scanner(System.in);
        while(usHp > 0 && curHp > 0)
        {
            System.out.println("Your hp: " + usHp + ". Enemy's hp: " + curHp + ". Number of potions: " + numPotions);
            System.out.println("Your stamina: " + stam + ". Your magic points: " + mp);
            System.out.println("Press 1 to attack. \nPress 2 to try a strong attack \nPress 3 to use magic. \nPress 4 to heal if you have enough potions. ");
            x = s.nextInt();
            System.out.println("");
            if(x == 1 && stam > 0)
            {
                if(Randomizer.nextBoolean(.25))
                {
                    System.out.println(user.getName() + " got a critical hit!");
                    curHp -= usDam * 1.5;
                }
                else
                {
                    curHp -= usDam;
                }
                stam--;
            }
            else if(x == 2)
            {
                if(Randomizer.nextBoolean(.4))
                {
                    System.out.println("You hit!");
                    curHp -= 2 * usDam;
                }
                else
                {
                    System.out.println("You missed!");
                }
            }
            else if(x == 4 && numPotions > 0)
            {
                System.out.println("Press 1 to heal. Press 2 to restore mp");
                int z = s.nextInt();
                if(z == 1) {
                    usHp += user.getHp() / 4;
                    if (usHp > user.getHp()) {
                        usHp = user.getHp();
                    }
                }
                else if(z == 2)
                {
                    mp += user.getMp() / 5;
                    if(mp > user.getMp())
                    {
                        mp = user.getMp();
                    }
                }
                numPotions--;
            }
            else if(x == 3 && mp > 0)
            {
                List<Magic> lis = user.getMagics();
                for(int i = 0; i < lis.size(); i++)
                {
                    System.out.println("Press " + i + " for: " + lis.get(i));
                }
                int y = s.nextInt();
                if(y < lis.size() && lis.get(y) != null && (mp - lis.get(y).getCost()) >= 0)
                {
                    System.out.println(user.getName() + " used " + lis.get(y).getName());
                    curHp -= lis.get(y).getDam();
                    mp -= lis.get(y).getCost();
                }
            }
            if(curHp  <= 0)
            {
                System.out.println("You won!");
                System.out.println("");
                return true;
            }
            if(Randomizer.nextBoolean(.25))
            {
                System.out.println(cur.getName() + " got a critical hit!");
                usHp -= 2 * curDam;
            }
            else if(Randomizer.nextBoolean(.25))
            {
                System.out.println(cur.getSpec());
                usHp -= cur.getSpec().getDam();
            }
            else if(Randomizer.nextBoolean(.15))
            {
                System.out.println(cur.getName() + " healed itself!");
                curHp += usDam * 2;
                if(curHp > cur.getHp())
                {
                    curHp = cur.getHp();
                }
            }
            else
            {
                usHp -= curDam;
            }
            System.out.println("");
        }
        System.out.println("You lost.");
        return false;
    }

    public static int bulk(Player user, int ind, int newKeyA, int newKeyW, int gp, HashMap<Integer, Armor> invA, HashMap<Integer, Weapon> invW, Weapon[][] sho, Enemy[][] rand, Boss[] bo)
    {
        Enemy cur = null;
        Armor addA = null;
        Weapon addW = null;
        Weapon pur = null;
        String name = user.getName();
        Enemy[] init = rand[ind];
        Weapon[] shop1 = sho[ind];
        while(true)
        {
            System.out.println("");
            System.out.println("Press 1 to battle and level up. \nPress 2 to shop for weapons \nPress 3 to change equipment \nPress 4 to see stats \nPress 5 to advance to the boss ");
            Scanner car = new Scanner(System.in);
            int y = car.nextInt();
            if(y == 1)
            {
                cur  = init[Randomizer.nextInt(0, init.length-1)];
                int z = battle(user, cur);
                if(z == 1)
                {
                    gp += 35;
                    addA = cur.dropArmor();
                    if(!invA.containsValue(addA)) {
                        System.out.println(user.getName() + " got a " + addA.getName());
                        invA.put(newKeyA, addA);
                        newKeyA++;
                    }
                    user.addExp(cur.giveExp());
                }
                else if(z == -1)
                {
                    if(user.getPower() - cur.getResist() > 0) {
                        gp -= 25;
                        if (gp < 0) {
                            gp = 0;
                        }
                    }
                    else
                    {
                        gp -= 5;
                        if (gp < 0) {
                            gp = 0;
                        }
                    }
                }
                else if(z == -2)
                {
                    if (gp < 0) {
                        gp = 0;
                    }
                }
                else
                {
                    System.out.println("You died from exhaustion.");
                    return -619;
                }
            }
            else if(y == 2)
            {
                pur = shop(gp, shop1);
                if(pur != null)
                {
                    gp -= pur.getCost();
                    if(!invW.containsValue(pur)) {
                        invW.put(newKeyW, pur);
                        newKeyW++;
                    }
                }
            }
            else if(y == 3)
            {
                Scanner g = new Scanner(System.in);
                System.out.println("Press 1 to equip an armor piece");
                System.out.println("Press 2 to equip a weapon");
                int cha = g.nextInt();
                if(cha == 1)
                {
                    addA = equipArmor(invA, user);
                    user.equip(addA);
                }
                else if(cha == 2)
                {
                    addW = equipWeapon(invW, user);
                    user.equip(addW);
                }
            }
            else if(y == 5)
            {
                break;
            }
            else if(y == 4)
            {
                System.out.println(user);
                System.out.println("Gp: " + gp);
            }
            else if(y == 47074)
            {
                gp *= 10;
                user.addExp(700);
            }
        }
        System.out.println(name + " has decided to challenge the fearsome warlord that leads the bandits.");
        if(bossBattle(bo[ind], user))
        {
             if(ind == 0) {
                 System.out.println(name + " has succeeded in defeating the bandits!");
                 System.out.println(name + " will now go on towards the dragon's lair.");
                 System.out.println(name + " travels to Midla, a town overrun by monsters.");
                 return bulk(user, ind+1, newKeyA, newKeyW, gp, invA, invW, sho, rand, bo);
             }
             else if(ind == 1)
             {
                 System.out.println(name + " has succeeded in defeating the monsters!");
                 System.out.println(name + " has reached the dragon's lair.");
                 System.out.println("Many terrors await " + name + " as they fight towards the dragon.");
                 return bulk(user, ind+1, newKeyA, newKeyW, gp, invA, invW, sho, rand, bo);
             }
             else if(ind == 2)
             {
                 System.out.println(name + " has killed the dragon!");
                 System.out.println(name + " returns to rebuild their village.");
                 System.out.println(name + " lives happily in peace for the rest of their life.");
                 return -7;
             }
        }
        else
        {
            System.out.println(name + " was killed by the " + bo[ind].getName() + ".");
            System.out.println("Try again!");
            return 7;
        }
        return bulk(user, ind+1, newKeyA, newKeyW, gp, invA, invW, sho, rand, bo);
    }
}