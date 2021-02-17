package smmegadrop.smmegadrop;

import jdk.incubator.jpackage.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import smmegadrop.smmegadrop.commands.DropCommand;
import smmegadrop.smmegadrop.commands.SMDropCommand;
import smmegadrop.smmegadrop.data.Config;
import smmegadrop.smmegadrop.data.DataLoader;
import smmegadrop.smmegadrop.listeners.DropListener;
import smmegadrop.smmegadrop.listeners.JoinPlayerListener;
import smmegadrop.smmegadrop.listeners.onBreakListener;
import smmegadrop.smmegadrop.objects.Drop;
import smmegadrop.smmegadrop.objects.User;

import java.util.ArrayList;
import java.util.List;

public class SMMegaDrop extends JavaPlugin {
    public List<User> users = new ArrayList();
    private static SMMegaDrop inst;
    public List<Drop> tb = new ArrayList();
    public boolean isTurbodropAll = false;
    public boolean isEventAll = false;
    public static boolean isOn;
    public static int taskID;

    public SMMegaDrop() {
        inst = this;
    }

    public static SMMegaDrop getInst() {
        return inst == null ? new SMMegaDrop() : inst;
    }

    public void onEnable() {


        Bukkit.getServer().getPluginManager().registerEvents(new DropListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinPlayerListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new onBreakListener(), this);
        this.getCommand("drop").setExecutor(new DropCommand());
        this.getCommand("turbodrop").setExecutor(new SMDropCommand());
        Config.check();
        Config.getInst().load();



        List<Player> arrayOfPlayer = (List<Player>) Bukkit.getOnlinePlayers();
        int j = arrayOfPlayer.size();

        for(int i = 0; i < j; ++i) {
            Player p = arrayOfPlayer.get(i);
            User u = User.get(p.getName());
            if (u == null) {
                new User(p.getPlayer().getName(), true, true, true, true, true, true, true, true, true, true, true, true, true,true,true);
            }
        }

        System.out.println("ParDragonDropPL >> Plugin zostal wlaczony: Poprawnie!");
    }

    public void onDisable() {
        DataLoader.saveUsers();
        System.out.println("ParDragonDropPL >> Wylaczono plugin.");
    }

    public static void setEnable(boolean enable) {
        if (enable) {
            isOn = enable;
        }

    }
}
