package smmegadrop.smmegadrop.objects;

import smmegadrop.smmegadrop.SMMegaDrop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {
    public static List<User> users = new ArrayList();
    private String name;
    private boolean enableCobble;
    private boolean enableDiamond;
    private boolean enableSzmaragd;
    private boolean enableGold;
    private boolean enableIron;
    private boolean enableTnT;
    private boolean enablePerla;
    private boolean enableSlime;
    private boolean enableRedStone;
    private boolean enableCoal;
    private boolean enableBookShelf;
    private boolean enableApple;
    private boolean enableObs;

    public User(String name, boolean cobble, boolean ediamond, boolean eszmaragd, boolean egold, boolean eiron, boolean etnt, boolean eslime, boolean eredstone, boolean ebooks, boolean eapple, boolean eobs, boolean ecoal, boolean eperla) {
        this.name = name;
        this.enableDiamond = ediamond;
        this.enableSzmaragd = eszmaragd;
        this.enableIron = eiron;
        this.enableCoal = ecoal;
        this.enableRedStone = eredstone;
        this.enableSlime = eslime;
        this.enablePerla = eperla;
        this.enableGold = egold;
        this.enableTnT = etnt;
        this.enableBookShelf = ebooks;
        this.enableObs = eobs;
        this.enableApple = eapple;
        this.enableCobble = cobble;
        users.add(this);
        SMMegaDrop.getInst().users.add(this);
    }

    public String getName() {
        return this.name;
    }

    public boolean getCobble() {
        return this.enableCobble;
    }

    public void getCobble(boolean cobble) {
        this.enableCobble = cobble;
    }

    public boolean eDiamond() {
        return this.enableDiamond;
    }

    public void eDiamond(boolean ediamond) {
        this.enableDiamond = ediamond;
    }

    public boolean eEmerald() {
        return this.enableSzmaragd;
    }

    public void eEmerald(boolean eszmaragd) {
        this.enableSzmaragd = eszmaragd;
    }

    public boolean eIron() {
        return this.enableIron;
    }

    public void eIron(boolean eiron) {
        this.enableIron = eiron;
    }

    public boolean eGold() {
        return this.enableGold;
    }

    public void eGold(boolean egold) {
        this.enableGold = egold;
    }

    public boolean eCoal() {
        return this.enableCoal;
    }

    public void eCoal(boolean ecoal) {
        this.enableCoal = ecoal;
    }

    public boolean eRedstone() {
        return this.enableRedStone;
    }

    public void eRedstone(boolean eredstone) {
        this.enableRedStone = eredstone;
    }

    public boolean eTnt() {
        return this.enableTnT;
    }

    public void eTnt(boolean etnt) {
        this.enableTnT = etnt;
    }

    public boolean eObs() {
        return this.enableObs;
    }

    public void eObs(boolean eobs) {
        this.enableObs = eobs;
    }

    public boolean ePerla() {
        return this.enablePerla;
    }

    public void ePerla(boolean eperla) {
        this.enablePerla = eperla;
    }

    public boolean eSlime() {
        return this.enableSlime;
    }

    public void eSlime(boolean esand) {
        this.enableSlime = esand;
    }

    public boolean eApple() {
        return this.enableApple;
    }

    public void eApple(boolean eapple) {
        this.enableApple = eapple;
    }

    public boolean eBooks() {
        return this.enableBookShelf;
    }

    public void eBooks(boolean ebooks) {
        this.enableBookShelf = ebooks;
    }

    public static User get(String user) {
        Iterator var2 = SMMegaDrop.getInst().users.iterator();

        while(var2.hasNext()) {
            User u = (User)var2.next();
            if (u.getName().equalsIgnoreCase(user)) {
                return u;
            }
        }

        return null;
    }
}
