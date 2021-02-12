package smmegadrop.smmegadrop.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import smmegadrop.smmegadrop.data.Config;
import smmegadrop.smmegadrop.objects.User;

import java.util.ArrayList;

public class GuiUtil {
    public static InventoryView menudropu(Player p) {
        Config cfg = Config.getInst();
        User u = User.get(p.getName());
        Inventory inv = Bukkit.createInventory((InventoryHolder)null, 36, "§c§lDrop z kamienia");
        ItemStack is3 = new ItemStack(Material.ACACIA_STAIRS);
        ItemStack is4 = new ItemStack(Material.PAPER);
        ItemMeta im4 = is4.getItemMeta();
        im4.setDisplayName("§6Informacja:");
        ArrayList<String> info = new ArrayList();
        info.add("§d§lTurbo§b§lDrop§7 mozna zakupic");
        info.add("§7W naszym sklepie na stronie serwera §c§l" + Config.getInst().linkTurboBuy);
        info.add("§d§lTurbo§b§lDrop§7 zwieksza szanse dropu o §3100%");
        im4.setLore(info);
        is4.setItemMeta(im4);
        inv.setItem(34, is4);
        ItemStack on = new ItemStack(Material.WOOL, 1, (short)13);
        ItemMeta onn = on.getItemMeta();
        onn.setDisplayName("§aWlacz wszystkie dropy");
        on.setItemMeta(onn);
        inv.setItem(27, on);
        ItemStack off = new ItemStack(Material.WOOL, 1, (short)14);
        ItemMeta offf = off.getItemMeta();
        offf.setDisplayName("§cWylacz wszystkie dropy");
        off.setItemMeta(offf);
        inv.setItem(28, off);
        ItemStack disableDiamond = new ItemStack(Material.DIAMOND);
        ItemMeta disablediamond = is3.getItemMeta();
        ArrayList<String> lore = new ArrayList();
        lore.add("§4Nacisnij aby przelaczyc drop!");
        lore.add("§7Procent§8: §c" + cfg.dropDiamond + "%");
        lore.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore.add("§7Drop§8:§c§l wylaczony");
        disablediamond.setLore(lore);
        disableDiamond.setItemMeta(disablediamond);
        ItemStack enableDiamond = new ItemStack(Material.DIAMOND);
        ItemMeta enablediamond = is3.getItemMeta();
        ArrayList<String> loree = new ArrayList();
        loree.add("§4Nacisnij aby przelaczyc drop!");
        loree.add("§7Procent§8: §c" + cfg.dropDiamond + "%");
        loree.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        loree.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        loree.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        loree.add("§7Drop§8:§a§l wlaczony");
        enablediamond.setLore(loree);
        enableDiamond.setItemMeta(enablediamond);
        if (u.eDiamond()) {
            inv.setItem(0, enableDiamond);
        } else {
            inv.setItem(0, disableDiamond);
        }

        ItemStack disableEmerald = new ItemStack(Material.EMERALD);
        ItemMeta disableemerald = is3.getItemMeta();
        ArrayList<String> lore1 = new ArrayList();
        lore1.add("§4Nacisnij aby przelaczyc drop!");
        lore1.add("§7Procent§8: §c" + cfg.dropEmerald + "%");
        lore1.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore1.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore1.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore1.add("§7Drop§8:§c§l wylaczony");
        disableemerald.setLore(lore1);
        disableEmerald.setItemMeta(disableemerald);
        ItemStack enableEmerald = new ItemStack(Material.EMERALD);
        ItemMeta enableemerald = is3.getItemMeta();
        ArrayList<String> loreee = new ArrayList();
        loreee.add("§4Nacisnij aby przelaczyc drop!");
        loreee.add("§7Procent§8: §c" + cfg.dropEmerald + "%");
        loreee.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        loreee.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        loreee.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        loreee.add("§7Drop§8:§a§l wlaczony");
        enableemerald.setLore(loreee);
        enableEmerald.setItemMeta(enableemerald);
        if (u.eEmerald()) {
            inv.setItem(1, enableEmerald);
        } else {
            inv.setItem(1, disableEmerald);
        }

        ItemStack disableIron = new ItemStack(Material.IRON_INGOT);
        ItemMeta disableiron = is3.getItemMeta();
        ArrayList<String> lore2 = new ArrayList();
        lore2.add("§4Nacisnij aby przelaczyc drop!");
        lore2.add("§7Procent§8: §c" + cfg.dropIron + "%");
        lore2.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore2.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore2.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore2.add("§7Drop§8:§c§l wylaczony");
        disableiron.setLore(lore2);
        disableIron.setItemMeta(disableiron);
        ItemStack enableIron = new ItemStack(Material.IRON_INGOT);
        ItemMeta enableiron = is3.getItemMeta();
        ArrayList<String> lore3 = new ArrayList();
        lore3.add("§4Nacisnij aby przelaczyc drop!");
        lore3.add("§7Procent§8: §c" + cfg.dropIron + "%");
        lore3.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore3.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore3.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore3.add("§7Drop§8:§a§l wlaczony");
        enableiron.setLore(lore3);
        enableIron.setItemMeta(enableiron);
        if (u.eIron()) {
            inv.setItem(3, enableIron);
        } else {
            inv.setItem(3, disableIron);
        }

        ItemStack disableGold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta disablegold = is3.getItemMeta();
        ArrayList<String> zloto = new ArrayList();
        zloto.add("§4Nacisnij aby przelaczyc drop!");
        zloto.add("§7Procent§8: §c" + cfg.dropGold + "%");
        zloto.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        zloto.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        zloto.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        zloto.add("§7Drop§8:§c§l wylaczony");
        disablegold.setLore(zloto);
        disableGold.setItemMeta(disablegold);
        ItemStack enableGold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta enablegold = is3.getItemMeta();
        ArrayList<String> zloto1 = new ArrayList();
        zloto1.add("§4Nacisnij aby przelaczyc drop!");
        zloto1.add("§7Procent§8: §c" + cfg.dropDiamond + "%");
        zloto1.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        zloto1.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        zloto1.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        zloto1.add("§7Drop§8:§a§l wlaczony");
        enablegold.setLore(zloto1);
        enableGold.setItemMeta(enablegold);
        if (u.eGold()) {
            inv.setItem(2, enableGold);
        } else {
            inv.setItem(2, disableGold);
        }

        ItemStack disableTNT = new ItemStack(Material.TNT);
        ItemMeta disabletnt = is3.getItemMeta();
        ArrayList<String> lore8 = new ArrayList();
        lore8.add("§4Nacisnij aby przelaczyc drop!");
        lore8.add("§7Procent§8: §c" + cfg.dropTnT + "%");
        lore8.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore8.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore8.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore8.add("§7Drop§8:§c§l wylaczony");
        disabletnt.setLore(lore8);
        disableTNT.setItemMeta(disabletnt);
        ItemStack enableGun = new ItemStack(Material.TNT);
        ItemMeta enablegun = is3.getItemMeta();
        ArrayList<String> lore9 = new ArrayList();
        lore9.add("§4Nacisnij aby przelaczyc drop!");
        lore9.add("§7Procent§8: §c" + cfg.dropTnT + "%");
        lore9.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore9.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore9.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore9.add("§7Drop§8:§a§l wlaczony");
        enablegun.setLore(lore9);
        enableGun.setItemMeta(enablegun);
        if (u.eTnt()) {
            inv.setItem(4, enableGun);
        } else {
            inv.setItem(4, disableTNT);
        }

        ItemStack disableKwa = new ItemStack(Material.ENDER_PEARL);
        ItemMeta disablekwa = is3.getItemMeta();
        ArrayList<String> lore14 = new ArrayList();
        lore14.add("§4Nacisnij aby przelaczyc drop!");
        lore14.add("§7Procent§8: §c" + cfg.dropPearl + "%");
        lore14.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore14.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore14.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore14.add("§7Drop§8:§c§l wylaczony");
        disablekwa.setLore(lore14);
        disableKwa.setItemMeta(disablekwa);
        ItemStack enableKwa = new ItemStack(Material.ENDER_PEARL);
        ItemMeta enablekwa = is3.getItemMeta();
        ArrayList<String> lore15 = new ArrayList();
        lore15.add("§4Nacisnij aby przelaczyc drop!");
        lore15.add("§7Procent§8: §c" + cfg.dropPearl + "%");
        lore15.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore15.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore15.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore15.add("§7Drop§8:§a§l wlaczony");
        enablekwa.setLore(lore15);
        enableKwa.setItemMeta(enablekwa);
        if (u.ePerla()) {
            inv.setItem(5, enableKwa);
        } else {
            inv.setItem(5, disableKwa);
        }

        ItemStack disableCoal = new ItemStack(Material.COAL);
        ItemMeta disablecoal = is3.getItemMeta();
        ArrayList<String> lore4 = new ArrayList();
        lore4.add("§4Nacisnij aby przelaczyc drop!");
        lore4.add("§7Procent§8: §c" + cfg.dropCoal + "%");
        lore4.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore4.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore4.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore4.add("§7Drop§8:§a§l wlaczony");
        disablecoal.setLore(lore4);
        disableCoal.setItemMeta(disablecoal);
        ItemStack enableCoal = new ItemStack(Material.COAL);
        ItemMeta enablecoal = is3.getItemMeta();
        ArrayList<String> lore5 = new ArrayList();
        lore5.add("§4Nacisnij aby przelaczyc drop!");
        lore5.add("§7Procent§8: §c" + cfg.dropCoal + "%");
        lore5.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore5.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore5.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore5.add("§7Drop§8:§c§l wylaczony");
        enablecoal.setLore(lore5);
        enableCoal.setItemMeta(enablecoal);
        if (u.eCoal()) {
            inv.setItem(8, enableCoal);
        } else {
            inv.setItem(8, disableCoal);
        }

        ItemStack disableRedStone = new ItemStack(Material.REDSTONE);
        ItemMeta disableredstone = is3.getItemMeta();
        ArrayList<String> lore6 = new ArrayList();
        lore6.add("§4Nacisnij aby przelaczyc drop!");
        lore6.add("§7Procent§8: §c" + cfg.dropRedstone + "%");
        lore6.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore6.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore6.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore6.add("§7Drop§8:§a§l wlaczony");
        disableredstone.setLore(lore6);
        disableRedStone.setItemMeta(disableredstone);
        ItemStack enableRedStone = new ItemStack(Material.REDSTONE);
        ItemMeta enableredstone = is3.getItemMeta();
        ArrayList<String> lore7 = new ArrayList();
        lore7.add("§4Nacisnij aby przelaczyc drop!");
        lore7.add("§7Procent§8: §c" + cfg.dropRedstone + "%");
        lore7.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore7.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore7.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore7.add("§7Drop§8:§c§l wylaczony");
        enableredstone.setLore(lore7);
        enableRedStone.setItemMeta(enableredstone);
        if (u.eRedstone()) {
            inv.setItem(7, enableRedStone);
        } else {
            inv.setItem(7, disableRedStone);
        }

        ItemStack disablePer = new ItemStack(Material.OBSIDIAN);
        ItemMeta disableper = is3.getItemMeta();
        ArrayList<String> lore12 = new ArrayList();
        lore12.add("§4Nacisnij aby przelaczyc drop!");
        lore12.add("§7Procent§8: §c" + cfg.dropObs + "%");
        lore12.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore12.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore12.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore12.add("§7Drop§8:§c§l wylaczony");
        disableper.setLore(lore12);
        disablePer.setItemMeta(disableper);
        ItemStack enablePer = new ItemStack(Material.OBSIDIAN);
        ItemMeta enableper = is3.getItemMeta();
        ArrayList<String> lore13 = new ArrayList();
        lore13.add("§4Nacisnij aby przelaczyc drop!");
        lore13.add("§7Procent§8: §c" + cfg.dropRedstone + "%");
        lore13.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore13.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore13.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore13.add("§7Drop§8:§a§l wlaczony");
        enableper.setLore(lore13);
        enablePer.setItemMeta(enableper);
        if (u.eObs()) {
            inv.setItem(11, enablePer);
        } else {
            inv.setItem(11, disablePer);
        }

        ItemStack disableBook = new ItemStack(Material.BOOKSHELF);
        ItemMeta disablebook = is3.getItemMeta();
        ArrayList<String> lore16 = new ArrayList();
        lore16.add("§4Nacisnij aby przelaczyc drop!");
        lore16.add("§7Procent§8: §c" + cfg.dropBooks + "%");
        lore16.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore16.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore16.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore16.add("§7Drop§8:§c§l wylaczony");
        disablebook.setLore(lore16);
        disableBook.setItemMeta(disablebook);
        ItemStack enableBook = new ItemStack(Material.BOOKSHELF);
        ItemMeta enablebook = is3.getItemMeta();
        ArrayList<String> lore17 = new ArrayList();
        lore17.add("§4Nacisnij aby przelaczyc drop!");
        lore17.add("§7Procent§8: §c" + cfg.dropBooks + "%");
        lore17.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore17.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore17.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore17.add("§7Drop§8:§a§l wlaczony");
        enablebook.setLore(lore17);
        enableBook.setItemMeta(enablebook);
        if (u.eBooks()) {
            inv.setItem(9, enableBook);
        } else {
            inv.setItem(9, disableBook);
        }

        ItemStack disableApple = new ItemStack(Material.APPLE);
        ItemMeta disableapple = is3.getItemMeta();
        ArrayList<String> lore18 = new ArrayList();
        lore18.add("§4Nacisnij aby przelaczyc drop!");
        lore18.add("§7Procent§8: §c" + cfg.dropApple + "%");
        lore18.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore18.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore18.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore18.add("§7Drop§8:§c§l wylaczony");
        disableapple.setLore(lore18);
        disableApple.setItemMeta(disableapple);
        ItemStack enableApple = new ItemStack(Material.APPLE);
        ItemMeta enableapple = is3.getItemMeta();
        ArrayList<String> lore19 = new ArrayList();
        lore19.add("§4Nacisnij aby przelaczyc drop!");
        lore19.add("§7Procent§8: §c" + cfg.dropApple + "%");
        lore19.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore19.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore19.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore19.add("§7Drop§8:§a§l wlaczony");
        enableapple.setLore(lore19);
        enableApple.setItemMeta(enableapple);
        if (u.eApple()) {
            inv.setItem(10, enableApple);
        } else {
            inv.setItem(10, disableApple);
        }

        ItemStack disableSand = new ItemStack(Material.SLIME_BALL);
        ItemMeta disablesand = is3.getItemMeta();
        ArrayList<String> lore20 = new ArrayList();
        lore20.add("§4Nacisnij aby przelaczyc drop!");
        lore20.add("§7Procent§8: §c" + cfg.dropSlimeBall + "%");
        lore20.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore20.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore20.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore20.add("§7Drop§8:§c§l wylaczony");
        disablesand.setLore(lore20);
        disableSand.setItemMeta(disablesand);
        ItemStack enableSand = new ItemStack(Material.SLIME_BALL);
        ItemMeta enablesand = is3.getItemMeta();
        ArrayList<String> lore21 = new ArrayList();
        lore21.add("§4Nacisnij aby przelaczyc drop!");
        lore21.add("§7Procent§8: §c" + cfg.dropSlimeBall + "%");
        lore21.add("§7Fortuna I: §a+§7" + cfg.fortuneDrop1);
        lore21.add("§7Fortuna II: §a+§7" + cfg.fortuneDrop2);
        lore21.add("§7Fortuna III: §a+§7" + cfg.fortuneDrop3);
        lore21.add("§7Drop§8:§a§l wlaczony");
        enablesand.setLore(lore21);
        enableSand.setItemMeta(enablesand);
        if (u.eSlime()) {
            inv.setItem(6, enableSand);
        } else {
            inv.setItem(6, disableSand);
        }

        ItemStack disableCobble = new ItemStack(Material.COBBLESTONE);
        ItemMeta dc = disableCobble.getItemMeta();
        dc.setDisplayName("§7Bruk");
        ArrayList<String> dcc = new ArrayList();
        dcc.add("§7Status: §aWlaczony");
        dcc.add("§2Nacisnij aby przelaczyc!");
        dc.setLore(dcc);
        disableCobble.setItemMeta(dc);
        ItemStack enableCobble = new ItemStack(Material.COBBLESTONE);
        ItemMeta dccc = enableCobble.getItemMeta();
        dccc.setDisplayName("§7Bruk");
        ArrayList<String> dcccc = new ArrayList();
        dcccc.add("§7Status: §cWylaczony");
        dcccc.add("§2Nacisnij aby przelaczyc!");
        dccc.setLore(dcccc);
        enableCobble.setItemMeta(dccc);
        if (u.getCobble()) {
            inv.setItem(35, disableCobble);
        } else {
            inv.setItem(35, enableCobble);
        }

        return p.openInventory(inv);
    }
}
