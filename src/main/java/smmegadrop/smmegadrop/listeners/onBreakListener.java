package smmegadrop.smmegadrop.listeners;


import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import smmegadrop.smmegadrop.data.Config;
import smmegadrop.smmegadrop.objects.User;
import smmegadrop.smmegadrop.utils.getChance;
import smmegadrop.smmegadrop.utils.randomizeAmount;
import smmegadrop.smmegadrop.utils.recalculatePickaxe;

import java.util.HashMap;
import java.util.Map;

public class onBreakListener implements Listener {
    private int amount = 1;

    @EventHandler(
            priority = EventPriority.MONITOR
    )
    public void onBreak(BlockBreakEvent e) {
        User u = User.get(e.getPlayer().getName());
        Player p = e.getPlayer();
        if (p instanceof Player) {
            if (e.getBlock().getType() == Material.STONE) {
                if (e.isCancelled()) {
                    e.setCancelled(true);
                    return;
                }

                if (p.getGameMode() == GameMode.SURVIVAL) {
                    e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                    recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                    e.getBlock().setType(Material.AIR);
                    if (u.getCobble()) {
                        ItemStack is = new ItemStack(Material.COBBLESTONE);
                        HashMap<Integer, ItemStack> not = p.getInventory().addItem(new ItemStack[]{is});
                        if (!not.isEmpty()) {
                            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                        }
                    }

                    if (p.getItemInHand().getType() == Material.DIAMOND_PICKAXE || p.getItemInHand().getType() == Material.GOLD_PICKAXE || p.getItemInHand().getType() == Material.IRON_PICKAXE || p.getItemInHand().getType() == Material.STONE_PICKAXE || p.getItemInHand().getType() == Material.WOOD_PICKAXE) {
                        Config cfg = Config.getInst();
                        Map<Enchantment, Integer> enchant = p.getItemInHand().getEnchantments();
                        ItemStack is;
                        HashMap not;
                        if (enchant.containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
                            if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
                                this.amount = randomizeAmount.randomAmount(Config.getInst().fortuneDrop1);
                                e.getPlayer().giveExp(Config.getInst().dropEXP);
                            }

                            if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
                                this.amount = randomizeAmount.randomAmount(Config.getInst().fortuneDrop2);
                                e.getPlayer().giveExp(Config.getInst().dropEXP);
                            }

                            if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
                                this.amount = randomizeAmount.randomAmount(Config.getInst().fortuneDrop3);
                                e.getPlayer().giveExp(Config.getInst().dropEXP);
                            }

                            e.getPlayer().giveExp(Config.getInst().dropEXP);
                            if (getChance.getChance(cfg.dropRedstone + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eRedstone()) {
                                    is = new ItemStack(Material.REDSTONE);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropCoal + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eCoal()) {
                                    is = new ItemStack(Material.COAL);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropGold + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eGold()) {
                                    is = new ItemStack(Material.GOLD_BLOCK);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropSlimeBall + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eSlime()) {
                                    is = new ItemStack(Material.SLIME_BALL);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropIron + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eIron()) {
                                    is = new ItemStack(Material.IRON_BLOCK);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropEmerald + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eEmerald()) {
                                    is = new ItemStack(Material.EMERALD_BLOCK);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropDiamond + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eDiamond()) {
                                    is = new ItemStack(Material.DIAMOND_BLOCK);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropObs + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eObs()) {
                                    is = new ItemStack(Material.OBSIDIAN);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropApple + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eApple()) {
                                    is = new ItemStack(Material.APPLE);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropPearl + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.ePerla()) {
                                    is = new ItemStack(Material.ENDER_PEARL);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropBooks + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eBooks()) {
                                    is = new ItemStack(Material.BOOK);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropTnT + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eTnt()) {
                                    is = new ItemStack(Material.TNT);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }
                            if (getChance.getChance(cfg.dropSand + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eTnt()) {
                                    is = new ItemStack(Material.SAND);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }
                            if (getChance.getChance(cfg.dropSand + cfg.smAddToDrop)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eTnt()) {
                                    is = new ItemStack(Material.INK_SACK, 1, (short) 4);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }
                        } else {
                            e.getPlayer().giveExp(Config.getInst().dropEXP);
                            if (getChance.getChance(cfg.dropRedstone)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eRedstone()) {
                                    is = new ItemStack(Material.REDSTONE);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropCoal)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eCoal()) {
                                    is = new ItemStack(Material.COAL);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropGold)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eGold()) {
                                    is = new ItemStack(Material.GOLD_BLOCK);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropSlimeBall)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eSlime()) {
                                    is = new ItemStack(Material.SLIME_BALL);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropIron)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eIron()) {
                                    is = new ItemStack(Material.IRON_BLOCK);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropEmerald)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eEmerald()) {
                                    is = new ItemStack(Material.EMERALD_BLOCK);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropDiamond)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eDiamond()) {
                                    is = new ItemStack(Material.DIAMOND_BLOCK);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropObs)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eObs()) {
                                    is = new ItemStack(Material.OBSIDIAN);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }



                            if (getChance.getChance(cfg.dropApple)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eApple()) {
                                    is = new ItemStack(Material.APPLE);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropPearl)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.ePerla()) {
                                    is = new ItemStack(Material.ENDER_PEARL);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropBooks)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eBooks()) {
                                    is = new ItemStack(Material.BOOK);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }

                            if (getChance.getChance(cfg.dropTnT)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eTnt()) {
                                    is = new ItemStack(Material.TNT);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }
                            if (getChance.getChance(cfg.dropSand)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eTnt()) {
                                    is = new ItemStack(Material.SAND);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }
                            if (getChance.getChance(cfg.dropLapis)) {
                                e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
                                recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
                                e.getBlock().setType(Material.AIR);
                                if (u.eTnt()) {
                                    is = new ItemStack(Material.INK_SACK, 1, (short) 4);
                                    is.setAmount(this.amount);
                                    not = p.getInventory().addItem(new ItemStack[]{is});
                                    if (!not.isEmpty()) {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), is);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (e.getBlock().getType() == Material.OBSIDIAN) {
                e.getPlayer().giveExp(Config.getInst().dropOEXP);
            }

            p.updateInventory();
        }
    }
}
