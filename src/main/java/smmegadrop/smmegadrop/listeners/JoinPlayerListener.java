package smmegadrop.smmegadrop.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import smmegadrop.smmegadrop.objects.User;

public class JoinPlayerListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        User u = User.get(p.getName());
        if (u == null) {
            new User(p.getPlayer().getName(), true, true, true, true, true, true, true, true, true, true, true, true, true);
        }

    }
}
