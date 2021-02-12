package smmegadrop.smmegadrop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import smmegadrop.smmegadrop.SMMegaDrop;
import smmegadrop.smmegadrop.data.Config;
import smmegadrop.smmegadrop.utils.SMDropUtil;

public class SMDropCommand implements CommandExecutor {
    private static int i;
    private static int taskID;

    public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
        if (cmd.getName().equalsIgnoreCase("turbodrop")) {
            if (!(sender instanceof Player)) {
                return false;
            }

            Player p = (Player)sender;
            if (p.hasPermission("turbodrop.admin")) {
                if (args.length == 0) {
                    p.sendMessage("§8» §7Poprawne uzycie /§d§lTurbo§b§lDrop§7 Give <nick/all> <czas>");
                    return false;
                }

                if (args[0].equalsIgnoreCase("give")) {
                    if (args.length <= 1) {
                        p.sendMessage("§4Blad: §cPodaj nick gracza, ktoremu chcesz dac turbodrop");
                        return false;
                    }

                    if (args.length <= 2) {
                        p.sendMessage("§4Blad: §cPodaj czas, na ktory chcesz dac turbodrop (w sekundach)");
                        return false;
                    }

                    if (!args[2].matches("[0-9]+")) {
                        p.sendMessage("§4Blad: §cCzas na ktory chcesz dac turbodrop, musi sie skladac tylko z cyfr.");
                        return false;
                    }

                    if (args[1].equalsIgnoreCase("all")) {
                        if (!SMMegaDrop.getInst().isTurbodropAll) {
                            final Config cfg = Config.getInst();
                            SMMegaDrop.getInst().isTurbodropAll = true;
                            cfg.dropCoal += cfg.smAddToDrop;
                            cfg.dropDiamond += cfg.smAddToDrop;
                            cfg.dropEmerald += cfg.smAddToDrop;
                            cfg.dropIron += cfg.smAddToDrop;
                            cfg.dropRedstone += cfg.smAddToDrop;
                            cfg.dropPearl += cfg.smAddToDrop;
                            cfg.dropObs += cfg.smAddToDrop;
                            cfg.dropTnT += cfg.smAddToDrop;
                            cfg.dropApple += cfg.smAddToDrop;
                            cfg.dropSlimeBall += cfg.smAddToDrop;
                            cfg.dropBooks += cfg.smAddToDrop;
                            Bukkit.broadcastMessage("§8» §d§lTurbo§b§lDrop§7 dla wszstkich graczy zostal Wlaczony.");
                            i = Integer.valueOf(args[2]);
                            taskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(SMMegaDrop.getInst(), new Runnable() {
                                public void run() {
                                    if (SMDropCommand.i > -1) {
                                        if (SMDropCommand.i == 0) {
                                            cfg.load();
                                            Bukkit.broadcastMessage("§8» §d§lTurbo§b§lDrop§7 dla wszystkich graczy sie Zakonczyl!");
                                            SMMegaDrop.getInst().isTurbodropAll = false;
                                            Bukkit.getScheduler().cancelTask(SMDropCommand.taskID);
                                        } else {
                                            SMDropCommand.i = SMDropCommand.i - 1;
                                        }
                                    }

                                }
                            }, 0L, 20L);
                            return false;
                        }

                        p.sendMessage("§4Blad: §cTurbodrop dla wszytskich graczy jest aktualnie wlaczony!");
                        return false;
                    }

                    if (Bukkit.getServer().getPlayerExact(args[1].toString()) == null) {
                        p.sendMessage("§4Blad: §cPodany gracz jest offline");
                        return false;
                    }

                    SMDropUtil.createTurboDrop(Bukkit.getServer().getPlayer(args[1].toString()), Integer.valueOf(args[2]), p);
                    return false;
                }

                p.sendMessage("§4Blad: §cNieznany argument.");
                return false;
            }

            p.sendMessage("Brak uprawnien");
        }

        return false;
    }
}
