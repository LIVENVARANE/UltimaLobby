package fr.groupeultima.org.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.groupeultima.org.UltimaLobby;
import net.md_5.bungee.api.ChatColor;

public class lobbyProtection implements Listener {
	
	UltimaLobby UltimaLobby;
	
	public lobbyProtection(UltimaLobby instance)
	{
		UltimaLobby = instance;
	}
	
	@EventHandler
	public void voidTP(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(p.getWorld() == Bukkit.getServer().getWorld("hub")) {
			if(p.getLocation().getY() < 0) {
				p.chat("/hub");
			}
		}
		else { return; }
	}
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent e) {
		e.getPlayer().getInventory().clear();
		e.getPlayer().setHealth(20);
		e.getPlayer().setFoodLevel(20);
	}
	
	@EventHandler
	public void onBlockDestroy(BlockBreakEvent e) {
		if(e.getBlock().getWorld() == Bukkit.getServer().getWorld("hub")) {
			if(e.getPlayer().isOp() == false) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(e.getBlock().getWorld() == Bukkit.getServer().getWorld("hub")) {
			if(e.getPlayer().isOp() == false) {
				e.setCancelled(true);
			}
			else {
				ItemStack friendsHead = new ItemStack(Material.PLAYER_HEAD);
				final Player player = Bukkit.getServer().getPlayer(e.getPlayer().getName());
				SkullMeta fHim = (SkullMeta) friendsHead.getItemMeta();
				fHim.setOwningPlayer(player);
				fHim.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mon compte");
				friendsHead.setItemMeta(fHim);
				if(e.getItemInHand().equals(friendsHead)) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onBlockBurn(BlockBurnEvent e) {
		if(e.getBlock().getWorld() == Bukkit.getServer().getWorld("hub")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onItemDropOnGround(PlayerDropItemEvent e) {
		if(e.getItemDrop().getWorld() == Bukkit.getServer().getWorld("hub")) {
			if(e.getPlayer().isOp() == false) {
				e.setCancelled(true);
			}
			else {
				if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Menu") || e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Boutique") || e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mon compte")) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(e.getCurrentItem() != null) {
			if(e.getWhoClicked().getWorld() == Bukkit.getServer().getWorld("hub") && e.getWhoClicked().isOp() == false) {
				e.setCancelled(true);
			}
			ItemStack menuCompass = new ItemStack(Material.COMPASS);
			ItemMeta mCim = menuCompass.getItemMeta();
			mCim.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Menu");
			menuCompass.setItemMeta(mCim);
			
			ItemStack shopEmerald = new ItemStack(Material.EMERALD);
			ItemMeta sEim = menuCompass.getItemMeta();
			sEim.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boutique");
			shopEmerald.setItemMeta(sEim);
			
			ItemStack friendsHead = new ItemStack(Material.PLAYER_HEAD);
			final Player player = Bukkit.getServer().getPlayer(e.getWhoClicked().getName());
			SkullMeta fHim = (SkullMeta) friendsHead.getItemMeta();
			fHim.setOwningPlayer(player);
			fHim.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mon compte");
			friendsHead.setItemMeta(fHim);
			if(e.getCurrentItem().equals(menuCompass) || e.getCurrentItem().equals(shopEmerald) || e.getCurrentItem().equals(friendsHead)) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
		public void onBoatOrMinecartPlace(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getItem() != null) {
				if (e.getItem().getType() == Material.OAK_BOAT) {
					if(e.getPlayer().isOp() == false) {
						e.setCancelled(true);
					}
				}
				if (e.getItem().getType() == Material.SPRUCE_BOAT) {
					if(e.getPlayer().isOp() == false) {
						e.setCancelled(true);
					}
				}
				if (e.getItem().getType() == Material.BIRCH_BOAT) {
					if(e.getPlayer().isOp() == false) {
						e.setCancelled(true);
					}
				}
				if (e.getItem().getType() == Material.ACACIA_BOAT) {
					if(e.getPlayer().isOp() == false) {
						e.setCancelled(true);
					}
				}
				if (e.getItem().getType() == Material.DARK_OAK_BOAT) {
					if(e.getPlayer().isOp() == false) {
						e.setCancelled(true);
					}
				}
				if (e.getItem().getType() == Material.JUNGLE_BOAT) {
					if(e.getPlayer().isOp() == false) {
						e.setCancelled(true);
					}
				}
				if (e.getItem().getType() == Material.MINECART) {
					if(e.getPlayer().isOp() == false) {
						e.setCancelled(true);
					}
				}
			}
			else { return; }
		}
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		if(e.getEntity().getWorld() == Bukkit.getServer().getWorld("hub")) {
			e.getDrops().clear();
		}
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		if(e.getEntity().getWorld() == Bukkit.getServer().getWorld("hub")) {
			e.setDeathMessage(null);
		}
	}
	
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(e.getEntity().getWorld() == Bukkit.getServer().getWorld("hub")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onItemDamage(PlayerItemDamageEvent e) {
		if(e.getPlayer().getWorld() == Bukkit.getServer().getWorld("hub")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent e) {
		if(e.getEntity().getWorld() == Bukkit.getServer().getWorld("hub")) {
			e.setFoodLevel(20);
		}
	}
	
	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent e) {
		if(e.getEntity().getWorld() == Bukkit.getServer().getWorld("hub")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onExplosion(ExplosionPrimeEvent e) {
		if(e.getEntity().getWorld() == Bukkit.getServer().getWorld("hub")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onItemPickup(EntityPickupItemEvent e) {
		if(e.getEntity().getWorld() == Bukkit.getServer().getWorld("hub")) {
			if(e.getEntity().isOp() == false) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		if(e.getWorld() == Bukkit.getServer().getWorld("hub")) {
			e.setCancelled(true);
		}
	}
}
