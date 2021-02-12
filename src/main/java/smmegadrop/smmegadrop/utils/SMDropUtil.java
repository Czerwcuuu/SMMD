package smmegadrop.smmegadrop.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import smmegadrop.smmegadrop.SMMegaDrop;
import smmegadrop.smmegadrop.data.Config;
import smmegadrop.smmegadrop.objects.Drop;

import java.util.Iterator;

public class SMDropUtil {
    private static int i;
    private static int taskID;

    public static void createTurboDrop(final Player p, int time, Player gived) {
        p.sendMessage("§aOtrzymales §8§l[§d§lTurbo§b§ldrop§8§l] §7na: §3" + time + "sec");
        new Drop(p.getName(), time);
        Bukkit.broadcastMessage("§8##############################");
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§a" + p.getName() + " §7zakupil§8§l: §5§lT§a§lU§d§lR§2§lB§5§lO§9§lD§1§lR§3§lO§b§lP§7!");
        Bukkit.broadcastMessage("§7Przez strone§8§l: §b§l" + Config.getInst().linkTurboBuy);
        Bukkit.broadcastMessage("§6Dziekujemy za wsparcie serwera!");
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§8##############################");
        i = time;
        taskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(SMMegaDrop.getInst(), new Runnable() {
            public void run() {
                Drop u = Drop.get(p.getName());
                if (SMDropUtil.i > -1) {
                    if (SMDropUtil.i == 0) {
                        p.sendMessage("§8» §d§lTurbo§b§ldrop§c§l sie Skonczyl!");
                        Iterator var3 = Bukkit.getWorlds().iterator();

                        while(var3.hasNext()) {
                            World w = (World)var3.next();
                            Location l = new Location(w, 0.0D, 70.0D, 0.0D);
                            w.playSound(l, Sound.ENTITY_BAT_DEATH, 10000.0F, 1.0F);
                        }

                        SMDropUtil.i = SMDropUtil.i - 1;
                        Bukkit.getScheduler().cancelTask(SMDropUtil.taskID);
                        u.delete();
                    } else {
                        SMDropUtil.i = SMDropUtil.i - 1;
                        u.setTime(u.getTime() - 1);
                    }
                }

            }
        }, 0L, 20L);
    }
}
