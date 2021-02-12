package smmegadrop.smmegadrop.objects;

import smmegadrop.smmegadrop.SMMegaDrop;

import java.util.Iterator;

public class Drop {
    private String name;
    private int time;

    public Drop(String name, int time) {
        this.name = name;
        this.time = time;
        SMMegaDrop.getInst().tb.add(this);
    }

    public String getName() {
        return this.name;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void delete() {
        this.name = null;
        this.time = 0;
        SMMegaDrop.getInst().tb.remove(this);
    }

    public static Drop get(String user) {
        Iterator var2 = SMMegaDrop.getInst().tb.iterator();

        while(var2.hasNext()) {
            Drop u = (Drop)var2.next();
            if (u.getName().equalsIgnoreCase(user)) {
                return u;
            }
        }

        return null;
    }
}
