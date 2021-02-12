package smmegadrop.smmegadrop.data;

import org.bukkit.configuration.file.FileConfiguration;
import smmegadrop.smmegadrop.SMMegaDrop;

import java.io.File;

public class Config {
    private static Config inst;
    private FileConfiguration cfg = SMMegaDrop.getInst().getConfig();
    private static File mainDir = SMMegaDrop.getInst().getDataFolder();
    private static File cfgFile;
    private static File users;
    public double dropDiamond;
    public double dropEmerald;
    public double dropIron;
    public double dropCoal;
    public double dropGold;
    public double dropRedstone;
    public double dropPearl;
    public double dropObs;
    public double dropSlimeBall;
    public double dropBooks;
    public double dropApple;
    public double dropTnT;
    public int fortuneDrop1;
    public int fortuneDrop2;
    public int fortuneDrop3;
    public String linkTurboBuy;
    public double smAddToDrop;
    public double EventaddToDrop;
    public int dropEXP;
    public int dropOEXP;

    static {
        cfgFile = new File(mainDir, "config.yml");
        users = new File(mainDir, "users");
    }

    private Config() {
        inst = this;
    }

    public void load() {
        this.dropDiamond = this.cfg.getDouble("config.drop.diamond");
        this.dropEmerald = this.cfg.getDouble("config.drop.emerald");
        this.dropIron = this.cfg.getDouble("config.drop.iron");
        this.dropCoal = this.cfg.getDouble("config.drop.coal");
        this.dropRedstone = this.cfg.getDouble("config.drop.redstone");
        this.dropGold = this.cfg.getDouble("config.drop.gold");
        this.dropPearl = this.cfg.getDouble("config.drop.pearl");
        this.dropObs = this.cfg.getDouble("config.drop.obs");
        this.dropSlimeBall = this.cfg.getDouble("config.drop.slime");
        this.dropBooks = this.cfg.getDouble("config.drop.books");
        this.dropApple = this.cfg.getDouble("config.drop.apple");
        this.dropTnT = this.cfg.getDouble("config.drop.tnt");
        this.dropEXP = this.cfg.getInt("config.drop.exp");
        this.dropOEXP = this.cfg.getInt("config.drop.oexp");
        this.fortuneDrop1 = this.cfg.getInt("config.drop.addToDrop1");
        this.fortuneDrop2 = this.cfg.getInt("config.drop.addToDrop2");
        this.fortuneDrop3 = this.cfg.getInt("config.drop.addToDrop3");
        this.linkTurboBuy = this.cfg.getString("config.drop.linkbuy");
        this.smAddToDrop = (double)this.cfg.getInt("config.drop.turboaddToDrop");
    }

    public static Config getInst() {
        return inst == null ? new Config() : inst;
    }

    public static void check() {
        if (!mainDir.exists()) {
            mainDir.mkdir();
        }

        if (!users.exists()) {
            users.mkdir();
        }

        if (!cfgFile.exists()) {
            SMMegaDrop.getInst().saveDefaultConfig();
        }

    }

    public static File getUsersFolder() {
        return users;
    }
}