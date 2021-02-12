package smmegadrop.smmegadrop.data;

import org.bukkit.configuration.file.YamlConfiguration;
import smmegadrop.smmegadrop.SMMegaDrop;
import smmegadrop.smmegadrop.objects.User;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class DataLoader {
    public static void load() {
    }

    public static void save() {
    }

    public static void loadUsers() {
        File[] arrayOfFile;
        int j = (arrayOfFile = Config.getUsersFolder().listFiles()).length;

        for(int i = 0; i < j; ++i) {
            File f = arrayOfFile[i];
            YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
            String name = yml.getString("name");
            boolean cobble = yml.getBoolean("cobble");
            boolean ediamond = yml.getBoolean("ediamond");
            boolean eszmaragd = yml.getBoolean("eemerald");
            boolean eiron = yml.getBoolean("eiron");
            boolean ecoal = yml.getBoolean("ecoal");
            boolean egold = yml.getBoolean("egold");
            boolean epearl = yml.getBoolean("epearl");
            boolean eredstone = yml.getBoolean("eredstone");
            boolean eslime = yml.getBoolean("eslime");
            boolean ebooks = yml.getBoolean("ebooks");
            boolean eapple = yml.getBoolean("eapple");
            boolean eobs = yml.getBoolean("eobs");
            boolean etnt = yml.getBoolean("etnt");
            new User(name, cobble, ediamond, eszmaragd, eiron, ecoal, egold, epearl, eapple, eredstone, ebooks, eslime, eobs, etnt);
        }

    }

    public static void saveUsers() {
        Iterator var1 = SMMegaDrop.getInst().users.iterator();

        while(var1.hasNext()) {
            User u = (User)var1.next();
            File f = new File(Config.getUsersFolder(), u.getName() + ".yml");
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException var5) {
                    var5.printStackTrace();
                }
            }

            YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
            yml.set("name", u.getName());
            yml.set("cobble", u.getCobble());
            yml.set("ediamond", u.eDiamond());
            yml.set("eemerald", u.eEmerald());
            yml.set("eiron", u.eIron());
            yml.set("ecoal", u.eCoal());
            yml.set("egold", u.eGold());
            yml.set("epearl", u.ePerla());
            yml.set("eobs", u.eObs());
            yml.set("eredstone", u.eRedstone());
            yml.set("eslime", u.eSlime());
            yml.set("eapple", u.eApple());
            yml.set("ebooks", u.eBooks());
            yml.set("etnt", u.eTnt());

            try {
                yml.save(f);
            } catch (IOException var6) {
                var6.printStackTrace();
            }
        }

    }
}
