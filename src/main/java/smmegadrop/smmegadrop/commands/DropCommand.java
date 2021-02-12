package smmegadrop.smmegadrop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import smmegadrop.smmegadrop.utils.GuiUtil;

public class DropCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
        Player p = (Player)sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Blad: §cNie mozesz wykonac tego z consoli!");
            return true;
        } else {
            GuiUtil.menudropu(p);
            return false;
        }
    }
}
