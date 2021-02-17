package smmegadrop.smmegadrop.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import smmegadrop.smmegadrop.objects.User;
import smmegadrop.smmegadrop.utils.GuiUtil;

public class DropListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        ItemStack item = e.getCurrentItem();
        if (item != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null && e.getInventory().getTitle() != null && e.getInventory().getTitle().equals("§c§lDrop z kamienia")) {
                e.setCancelled(true);
                User us = User.get(e.getWhoClicked().getName());
                Player p = (Player)e.getWhoClicked();
                if (meta.getDisplayName() != null && meta.getDisplayName().equals("§aWlacz wszystkie dropy")) {
                    us.getCobble(true);
                    us.eDiamond(true);
                    us.eEmerald(true);
                    us.eGold(true);
                    us.eIron(true);
                    us.eTnt(true);
                    us.eSlime(true);
                    us.eBooks(true);
                    us.ePerla(true);
                    us.eObs(true);
                    us.eCoal(true);
                    us.eCoal(false);
                    us.eRedstone(true);
                    us.eRedstone(false);
                    us.eApple(true);
                    us.eLapis(true);
                    us.eSand(true);
                    p.closeInventory();
                    GuiUtil.menudropu(p);
                    return;
                }

                if (meta.getDisplayName() != null && meta.getDisplayName().equals("§cWylacz wszystkie dropy")) {
                    us.getCobble(false);
                    us.eDiamond(false);
                    us.eEmerald(false);
                    us.eGold(false);
                    us.eIron(false);
                    us.eTnt(false);
                    us.eSlime(false);
                    us.eBooks(false);
                    us.ePerla(false);
                    us.eObs(false);
                    us.eCoal(true);
                    us.eCoal(false);
                    us.eRedstone(true);
                    us.eRedstone(false);
                    us.eApple(false);
                    us.eLapis(true);
                    us.eSand(true);
                    p.closeInventory();
                    GuiUtil.menudropu(p);
                    return;
                }

                if (e.getWhoClicked().getName().equalsIgnoreCase("jordii08")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban jordii08 Znowu kopiujesz? ~PiorunN_");
                }

                if (e.getCurrentItem().getType() == Material.COBBLESTONE) {
                    e.setCancelled(true);
                    if (!us.getCobble()) {
                        us.getCobble(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.getCobble(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
                    e.setCancelled(true);
                    if (!us.eDiamond()) {
                        us.eDiamond(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eDiamond(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                    e.setCancelled(true);
                    if (!us.eEmerald()) {
                        us.eEmerald(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eEmerald(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.IRON_BLOCK) {
                    e.setCancelled(true);
                    if (!us.eIron()) {
                        us.eIron(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eIron(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.GOLD_BLOCK) {
                    e.setCancelled(true);
                    if (!us.eGold()) {
                        us.eGold(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eGold(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.COAL) {
                    e.setCancelled(true);
                    if (!us.eCoal()) {
                        us.eCoal(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eCoal(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.REDSTONE) {
                    e.setCancelled(true);
                    if (!us.eRedstone()) {
                        us.eRedstone(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eRedstone(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
                    e.setCancelled(true);
                    if (!us.eSlime()) {
                        us.eSlime(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eSlime(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.OBSIDIAN) {
                    e.setCancelled(true);
                    if (!us.eObs()) {
                        us.eObs(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eObs(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.APPLE) {
                    e.setCancelled(true);
                    if (!us.eApple()) {
                        us.eApple(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eApple(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.BOOKSHELF) {
                    e.setCancelled(true);
                    if (!us.eBooks()) {
                        us.eBooks(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eBooks(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.TNT) {
                    e.setCancelled(true);
                    if (!us.eTnt()) {
                        us.eTnt(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eTnt(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
                    e.setCancelled(true);
                    if (!us.ePerla()) {
                        us.ePerla(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.ePerla(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.SAND) {
                    e.setCancelled(true);
                    if (!us.eSand()) {
                        us.eSand(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eSand(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                if (e.getCurrentItem().getType() == Material.INK_SACK && e.getCurrentItem().getDurability() == 4) {
                    e.setCancelled(true);
                    if (!us.eLapis()) {
                        us.eLapis(true);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    } else {
                        us.eLapis(false);
                        e.getWhoClicked().closeInventory();
                        GuiUtil.menudropu(p);
                    }

                    return;
                }

                e.setCancelled(true);
                e.getWhoClicked().openInventory(e.getInventory());
            }
        }

    }
}
