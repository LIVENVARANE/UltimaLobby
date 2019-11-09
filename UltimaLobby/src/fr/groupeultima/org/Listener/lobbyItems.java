package fr.groupeultima.org.Listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.groupeultima.org.UltimaLobby;
import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("deprecation")
public class lobbyItems implements Listener {

	UltimaLobby UltimaLobby;
	
	public lobbyItems(UltimaLobby instance)
	{
		UltimaLobby = instance;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().getInventory().clear();
		// giving menu compass
		ItemStack menuCompass = new ItemStack(Material.COMPASS);
		ItemMeta mCim = menuCompass.getItemMeta();
		mCim.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Menu");
		menuCompass.setItemMeta(mCim);
		e.getPlayer().getInventory().setItem(4, menuCompass);
		
		// giving shop emerald
		ItemStack shopEmerald = new ItemStack(Material.EMERALD);
		ItemMeta sEim = menuCompass.getItemMeta();
		sEim.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boutique");
		shopEmerald.setItemMeta(sEim);
		e.getPlayer().getInventory().setItem(7, shopEmerald);
		
		// giving friends head
		ItemStack friendsHead = new ItemStack(Material.PLAYER_HEAD);
		final Player player = Bukkit.getServer().getPlayer(e.getPlayer().getName());
		SkullMeta fHim = (SkullMeta) friendsHead.getItemMeta();
		fHim.setOwningPlayer(player);
		fHim.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mon compte");
		friendsHead.setItemMeta(fHim);
		e.getPlayer().getInventory().setItem(1, friendsHead);
		
		// set hand slot to menuCompass
		e.getPlayer().getInventory().setHeldItemSlot(4);
	}
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent e) {
		if(e.getPlayer().getWorld() == Bukkit.getServer().getWorld("hub")) {
			// giving menu compass
			ItemStack menuCompass = new ItemStack(Material.COMPASS);
			ItemMeta mCim = menuCompass.getItemMeta();
			mCim.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Menu");
			menuCompass.setItemMeta(mCim);
			e.getPlayer().getInventory().setItem(4, menuCompass);
			
			// giving shop emerald
			ItemStack shopEmerald = new ItemStack(Material.EMERALD);
			ItemMeta sEim = menuCompass.getItemMeta();
			sEim.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boutique");
			shopEmerald.setItemMeta(sEim);
			e.getPlayer().getInventory().setItem(7, shopEmerald);
			
			// giving friends head
			ItemStack friendsHead = new ItemStack(Material.PLAYER_HEAD);
			final Player player = Bukkit.getServer().getPlayer(e.getPlayer().getName());
			SkullMeta fHim = (SkullMeta) friendsHead.getItemMeta();
			fHim.setOwningPlayer(player);
			fHim.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mon compte");
			friendsHead.setItemMeta(fHim);
			e.getPlayer().getInventory().setItem(1, friendsHead);
			
			// set hand slot to menuCompass
			e.getPlayer().getInventory().setHeldItemSlot(4);
		}
	}
	
	// MENU INV
	public static Inventory menuInv = Bukkit.createInventory(null, 9 * 5, ChatColor.BLUE + "Ultima " + ChatColor.GRAY + "→ " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Menu");
	static {
		// creating apple item
		ItemStack menuInvGapple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
		ItemMeta menuInvGames = menuInvGapple.getItemMeta();
		menuInvGames.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Jeux");
		List<String> gapLore = new ArrayList<String>();
		gapLore.add(ChatColor.BLUE + "Ouvrir le menu des jeux.");
		gapLore.add(" ");
		// getting players not in hub
		int playersNotInGame = Bukkit.getServer().getWorld("hub").getPlayers().size();
		int totalPlayers = Bukkit.getOnlinePlayers().size();
		int playersInGame = totalPlayers - playersNotInGame;
		if(playersInGame == 1) {
			gapLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInGame + " joueur");
		}
		else {
			gapLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInGame + " joueurs");
		}
		menuInvGames.setLore(gapLore);
		menuInvGapple.setItemMeta(menuInvGames);
		
		// creating comparator item
		ItemStack menuInvComp = new ItemStack(Material.COMPARATOR);
		ItemMeta menuInvSettings = menuInvComp.getItemMeta();
		menuInvSettings.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Paramètres");
		List<String> compLore = new ArrayList<String>();
		compLore.add(ChatColor.BLUE + "Ouvrir les paramètres.");
		menuInvSettings.setLore(compLore);
		menuInvComp.setItemMeta(menuInvSettings);
		
		// creating door item
		ItemStack menuInvDoor = new ItemStack(Material.SPRUCE_DOOR);
		ItemMeta menuInvLeave = menuInvDoor.getItemMeta();
		menuInvLeave.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Quitter le menu");
		menuInvDoor.setItemMeta(menuInvLeave);
		
		// creating glass item
		ItemStack menuInvGlass = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
		ItemMeta menuInvDeco = menuInvGlass.getItemMeta();
		menuInvDeco.setDisplayName(ChatColor.DARK_AQUA + "*");
		menuInvGlass.setItemMeta(menuInvDeco);
		
		// adding items
		menuInv.setItem(22, menuInvGapple);
		menuInv.setItem(28, menuInvComp);
		menuInv.setItem(34, menuInvDoor);
		
		menuInv.setItem(44, menuInvGlass);
		menuInv.setItem(43, menuInvGlass);
		menuInv.setItem(42, menuInvGlass);
		menuInv.setItem(41, menuInvGlass);
		menuInv.setItem(40, menuInvGlass);
		menuInv.setItem(39, menuInvGlass);
		menuInv.setItem(38, menuInvGlass);
		menuInv.setItem(37, menuInvGlass);
		menuInv.setItem(36, menuInvGlass);
		menuInv.setItem(35, menuInvGlass);
		menuInv.setItem(27, menuInvGlass);
		menuInv.setItem(26, menuInvGlass);
		menuInv.setItem(18, menuInvGlass);
		menuInv.setItem(17, menuInvGlass);
		menuInv.setItem(9, menuInvGlass);
		menuInv.setItem(8, menuInvGlass);
		menuInv.setItem(7, menuInvGlass);
		menuInv.setItem(6, menuInvGlass);
		menuInv.setItem(5, menuInvGlass);
		menuInv.setItem(4, menuInvGlass);
		menuInv.setItem(3, menuInvGlass);
		menuInv.setItem(2, menuInvGlass);
		menuInv.setItem(1, menuInvGlass);
		menuInv.setItem(0, menuInvGlass);
	}
	
	// SHOP INV
	public static Inventory shopInv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Ultima " + ChatColor.GRAY + "→ " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Boutique");
	static {
		// creating comparator item
		ItemStack shopInvChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta shopInvRanks = shopInvChestplate.getItemMeta();
		shopInvRanks.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Grades " + ChatColor.MAGIC + "aa" + ChatColor.RESET + "" + ChatColor.GOLD + " (-50%)");
		List<String> ranksLore = new ArrayList<String>();
		ranksLore.add(ChatColor.BLUE + "Ouvrir la catégorie des grades");
		shopInvRanks.setLore(ranksLore);
		shopInvChestplate.setItemMeta(shopInvRanks);
		
		// creating door item
		ItemStack menuInvDoor = new ItemStack(Material.SPRUCE_DOOR);
		ItemMeta menuInvLeave = menuInvDoor.getItemMeta();
		menuInvLeave.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Quitter le menu");
		menuInvDoor.setItemMeta(menuInvLeave);
		
		// adding items
		shopInv.setItem(4, shopInvChestplate);
		shopInv.setItem(8, menuInvDoor);
	}
	
	// SETTINGS INV
	public static Inventory settingsInv = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Ultima " + ChatColor.GRAY + "→ " + ChatColor.BLUE + "Menu " + ChatColor.GRAY + "→ " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Paramètres");
	static {
		// creating door item
		ItemStack menuInvDoor = new ItemStack(Material.SPRUCE_DOOR);
		ItemMeta menuInvLeave = menuInvDoor.getItemMeta();
		menuInvLeave.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Quitter le menu");
		menuInvDoor.setItemMeta(menuInvLeave);
		
		// adding items
		settingsInv.setItem(26, menuInvDoor);
	}
	
	// GAMES INV
		public static Inventory gamesInv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Ultima " + ChatColor.GRAY + "→ " + ChatColor.BLUE + "Menu " + ChatColor.GRAY + "→ " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Jeux");
		static {
			// creating door item
			ItemStack menuInvDoor = new ItemStack(Material.SPRUCE_DOOR);
			ItemMeta menuInvLeave = menuInvDoor.getItemMeta();
			menuInvLeave.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Quitter le menu");
			menuInvDoor.setItemMeta(menuInvLeave);
			
			// creating sandstone item
			ItemStack gamesInvSandstone = new ItemStack(Material.CUT_SANDSTONE);
			ItemMeta gamesInvRushFFA = gamesInvSandstone.getItemMeta();
			gamesInvRushFFA.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "RushFFA");
			List<String> rushffaLore = new ArrayList<String>();
			rushffaLore.add(" ");
			rushffaLore.add(ChatColor.GOLD + "Avec les caractéristiques du " + ChatColor.UNDERLINE + "RUSH" + ChatColor.RESET + "" + ChatColor.GOLD + " et du " + ChatColor.UNDERLINE + "FFA" + ChatColor.RESET + "" + ChatColor.GOLD + ", le " + ChatColor.UNDERLINE + "RUSHFFA" + ChatColor.RESET + "" + ChatColor.GOLD + " est");
			rushffaLore.add(ChatColor.GOLD + "un mode de jeu excellent pour s'entrainer dynamiquement au rush.");
			rushffaLore.add("  ");
			rushffaLore.add(ChatColor.YELLOW + "Il combine deux versions:");
			rushffaLore.add(ChatColor.YELLOW + "  - Le " + ChatColor.GOLD + "RushFFA " + ChatColor.ITALIC + "Original " + ChatColor.RESET + "" + ChatColor.GRAY + "(sans ponts)" + ChatColor.YELLOW + ".");
			rushffaLore.add(ChatColor.YELLOW + "  - Le " + ChatColor.GOLD + "RushFFA " + ChatColor.ITALIC + "Deluxe " + ChatColor.RESET + "" + ChatColor.GRAY + "(avec ponts)" + ChatColor.YELLOW + ".");
			rushffaLore.add("   ");
			int playersInOriginal = Bukkit.getServer().getWorld("rushffaOriginal").getPlayers().size();
			int playersInDeluxe = Bukkit.getServer().getWorld("rushffaDeluxe").getPlayers().size();
			int playersInRushFFA = playersInOriginal + playersInDeluxe;
			if(playersInRushFFA == 1) {
				rushffaLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: 1 joueur");
			}
			else {
				rushffaLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInRushFFA + " joueurs");
			}
			gamesInvRushFFA.setLore(rushffaLore);
			gamesInvSandstone.setItemMeta(gamesInvRushFFA);
			
			// creating gchest item
			ItemStack gamesInvGChest = new ItemStack(Material.GOLDEN_CHESTPLATE);
			ItemMeta gamesInvFFA = gamesInvGChest.getItemMeta();
			gamesInvFFA.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "FFA");
			List<String> ffaLore = new ArrayList<String>();
			ffaLore.add(" ");
			ffaLore.add(ChatColor.DARK_GREEN + "Le " + ChatColor.UNDERLINE + "FFA" + ChatColor.RESET + "" + ChatColor.DARK_GREEN + " est un mode de jeu stratégique avec une multitude de " + ChatColor.UNDERLINE + "KITS");
			ffaLore.add(ChatColor.DARK_GREEN + "achetables ou débloquables. Vous pouvez former une alliance avec " + ChatColor.UNDERLINE + "UN" + ChatColor.RESET + "" + ChatColor.DARK_GREEN + " autre joueur.");
			ffaLore.add("  ");
			int playersInFFA = Bukkit.getServer().getWorld("ffa").getPlayers().size();
			if(playersInFFA == 1) {
				ffaLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: 1 joueur");
			}
			else {
				ffaLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInFFA + " joueurs");
			}
			gamesInvFFA.setLore(ffaLore);
			gamesInvGChest.setItemMeta(gamesInvFFA);
			
			// creating head item
			ItemStack gamesInvHead = new ItemStack(Material.PLAYER_HEAD);
			SkullMeta gamesInvSumo = (SkullMeta) gamesInvHead.getItemMeta();
			gamesInvSumo.setOwningPlayer(Bukkit.getServer().getOfflinePlayer("CocaCola1"));
			gamesInvSumo.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Sumo");
			List<String> sumoLore = new ArrayList<String>();
			sumoLore.add(" ");
			sumoLore.add(ChatColor.DARK_PURPLE + "Dans le " + ChatColor.UNDERLINE + "SUMO" + ChatColor.RESET + "" + ChatColor.DARK_PURPLE + ", c'est le plus " + ChatColor.UNDERLINE + "LOURD" + ChatColor.RESET + "" + ChatColor.DARK_PURPLE +  " qui gagne.");
			sumoLore.add(ChatColor.DARK_PURPLE + "Ce jeu est \"" + ChatColor.UNDERLINE + "AIMBOOSTER" + ChatColor.RESET + "" + ChatColor.DARK_PURPLE + "\", il est très bon pour entrainer");
			sumoLore.add(ChatColor.DARK_PURPLE + "votre aim avant de partir sur des modes plus complexes.");
			sumoLore.add("  ");
			int playersInSumo = Bukkit.getServer().getWorld("sumo").getPlayers().size();
			if(playersInSumo == 1) {
				sumoLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: 1 joueur");
			}
			else {
				sumoLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInSumo + " joueurs");
			}
			gamesInvSumo.setLore(sumoLore);
			gamesInvHead.setItemMeta(gamesInvSumo);
			
			// adding items
			gamesInv.setItem(8, menuInvDoor);
			gamesInv.setItem(4, gamesInvSandstone);
			gamesInv.setItem(3, gamesInvGChest);
			gamesInv.setItem(5, gamesInvHead);
		}
	
	// RUSHFFA INV
		public static Inventory rushffaInv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Ultima " + ChatColor.GRAY + "→ " + ChatColor.BLUE + "Menu " + ChatColor.GRAY + "→ " + ChatColor.BLUE + "Jeux" + ChatColor.GRAY + "→ " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RushFFA");
		static {
			
			// creating door item
			ItemStack menuInvDoor = new ItemStack(Material.SPRUCE_DOOR);
			ItemMeta menuInvLeave = menuInvDoor.getItemMeta();
			menuInvLeave.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Quitter le menu");
			menuInvDoor.setItemMeta(menuInvLeave);
			
			// creating gingot item
			ItemStack rushffaInvGIngot = new ItemStack(Material.GOLD_BLOCK);
			ItemMeta rushffaInvDeluxe = rushffaInvGIngot.getItemMeta();
			rushffaInvDeluxe.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "RushFFA " + ChatColor.RESET + "" + ChatColor.GOLD + "" + ChatColor.ITALIC + "Deluxe");
			List<String> deluxeLore = new ArrayList<String>();
			deluxeLore.add(ChatColor.YELLOW + "Le " + ChatColor.BOLD + "RushFFA " + ChatColor.RESET + "" + ChatColor.GOLD + "" + ChatColor.ITALIC + "Deluxe" + ChatColor.RESET + "" + ChatColor.YELLOW + " est une version");
			deluxeLore.add(ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "avec ponts" + ChatColor.RESET + "" + ChatColor.YELLOW + " du RushFFA Original. Dans ce mode de jeu,");
			deluxeLore.add(ChatColor.YELLOW + "un power-up qui apparaît toutes les " + ChatColor.UNDERLINE + "deux minutes" + ChatColor.RESET + "" + ChatColor.YELLOW + ": " + ChatColor.YELLOW + "l'" +  ChatColor.GOLD + "" + ChatColor.BOLD + "Élytra" + ChatColor.RESET + "" + ChatColor.YELLOW + ",");
			deluxeLore.add(ChatColor.YELLOW + "il a une faible durabilité mais avantage beaucoup celui qui l'obtient");
			deluxeLore.add(" ");
			int playersInDeluxe = Bukkit.getServer().getWorld("rushffaDeluxe").getPlayers().size();
			if(playersInDeluxe == 1) {
				deluxeLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: 1 joueur");
			}
			else {
				deluxeLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInDeluxe + " joueurs");
			}
			rushffaInvDeluxe.setLore(deluxeLore);
			rushffaInvGIngot.setItemMeta(rushffaInvDeluxe);
			
			// creating dingot item
			ItemStack rushffaInvDIngot = new ItemStack(Material.DIAMOND_BLOCK);
			ItemMeta rushffaInvOriginal = rushffaInvDIngot.getItemMeta();
			rushffaInvOriginal.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "RushFFA " + ChatColor.RESET + "" + ChatColor.ITALIC + "Original");
			List<String> originalLore = new ArrayList<String>();
			originalLore.add(ChatColor.AQUA + "Le " + ChatColor.BOLD + "RushFFA " + ChatColor.RESET + "" + ChatColor.ITALIC + "Original" + ChatColor.RESET + "" + ChatColor.AQUA + " est la version");
			originalLore.add(ChatColor.AQUA + "" + ChatColor.UNDERLINE + "basique" + ChatColor.RESET + "" + ChatColor.AQUA + " du RushFFA. Dans ce mode de jeu,");
			originalLore.add(ChatColor.AQUA + "il n'y a pas de " + ChatColor.UNDERLINE + "ponts" + ChatColor.RESET + "" + ChatColor.AQUA + " mais des " +  ChatColor.BLUE + "" + ChatColor.BOLD + "plaques de pressions en or " + ChatColor.RESET + "" + ChatColor.AQUA + "qui");
			originalLore.add(ChatColor.AQUA + "font apparaitre un pont quand on marche dessus!");
			originalLore.add(" ");
			int playersInOriginal = Bukkit.getServer().getWorld("rushffaOriginal").getPlayers().size();
			if(playersInOriginal == 1) {
				originalLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: 1 joueur");
			}
			else {
				originalLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInOriginal + " joueurs");
			}
			rushffaInvOriginal.setLore(originalLore);
			rushffaInvDIngot.setItemMeta(rushffaInvOriginal);
			
			// adding items
			rushffaInv.setItem(3, rushffaInvDIngot);
			rushffaInv.setItem(5, rushffaInvGIngot);
			rushffaInv.setItem(8, menuInvDoor);
		}
		
	// ACCOUNT INV
			public static Inventory accountInv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Ultima " + ChatColor.GRAY + "→ " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Mon compte");
			static {
				
				// creating door item
				ItemStack menuInvDoor = new ItemStack(Material.SPRUCE_DOOR);
				ItemMeta menuInvLeave = menuInvDoor.getItemMeta();
				menuInvLeave.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Quitter le menu");
				menuInvDoor.setItemMeta(menuInvLeave);
					
				// adding items
				accountInv.setItem(8, menuInvDoor);
				}
	
	@EventHandler
	public void onItemClick(InventoryClickEvent e) {
		if(e.getCurrentItem() != null) {
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
			
			ItemStack menuInvDoor = new ItemStack(Material.SPRUCE_DOOR);
			ItemMeta menuInvLeave = menuInvDoor.getItemMeta();
			menuInvLeave.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Quitter le menu");
			menuInvDoor.setItemMeta(menuInvLeave);
			
			ItemStack menuInvComp = new ItemStack(Material.COMPARATOR);
			ItemMeta menuInvSettings = menuInvComp.getItemMeta();
			menuInvSettings.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Paramètres");
			List<String> compLore = new ArrayList<String>();
			compLore.add(ChatColor.BLUE + "Ouvrir les paramètres.");
			menuInvSettings.setLore(compLore);
			menuInvComp.setItemMeta(menuInvSettings);
			
			ItemStack menuInvGapple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
			ItemMeta menuInvGames = menuInvGapple.getItemMeta();
			menuInvGames.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Jeux");
			List<String> gapLore = new ArrayList<String>();
			gapLore.add(ChatColor.BLUE + "Ouvrir le menu des jeux.");
			gapLore.add(" ");
			// getting players not in hub
			int playersNotInGame = Bukkit.getServer().getWorld("hub").getPlayers().size();
			int totalPlayers = Bukkit.getOnlinePlayers().size();
			int playersInGame = totalPlayers - playersNotInGame;
			if(playersInGame == 1) {
				gapLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInGame + " joueur");
			}
			else {
				gapLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInGame + " joueurs");
			}
			menuInvGames.setLore(gapLore);
			menuInvGapple.setItemMeta(menuInvGames);
			
			ItemStack gamesInvSandstone = new ItemStack(Material.CUT_SANDSTONE);
			ItemMeta gamesInvRushFFA = gamesInvSandstone.getItemMeta();
			gamesInvRushFFA.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "RushFFA");
			List<String> rushffaLore = new ArrayList<String>();
			rushffaLore.add(" ");
			rushffaLore.add(ChatColor.GOLD + "Avec les caractéristiques du " + ChatColor.UNDERLINE + "RUSH" + ChatColor.RESET + "" + ChatColor.GOLD + " et du " + ChatColor.UNDERLINE + "FFA" + ChatColor.RESET + "" + ChatColor.GOLD + ", le " + ChatColor.UNDERLINE + "RUSHFFA" + ChatColor.RESET + "" + ChatColor.GOLD + " est");
			rushffaLore.add(ChatColor.GOLD + "un mode de jeu excellent pour s'entrainer dynamiquement au rush.");
			rushffaLore.add("  ");
			rushffaLore.add(ChatColor.YELLOW + "Il combine deux versions:");
			rushffaLore.add(ChatColor.YELLOW + "  - Le " + ChatColor.GOLD + "RushFFA " + ChatColor.ITALIC + "Original " + ChatColor.RESET + "" + ChatColor.GRAY + "(sans ponts)" + ChatColor.YELLOW + ".");
			rushffaLore.add(ChatColor.YELLOW + "  - Le " + ChatColor.GOLD + "RushFFA " + ChatColor.ITALIC + "Deluxe " + ChatColor.RESET + "" + ChatColor.GRAY + "(avec ponts)" + ChatColor.YELLOW + ".");
			rushffaLore.add("   ");
			int playersInOriginal = Bukkit.getServer().getWorld("rushffaOriginal").getPlayers().size();
			int playersInDeluxe = Bukkit.getServer().getWorld("rushffaDeluxe").getPlayers().size();
			int playersInRushFFA = playersInOriginal + playersInDeluxe;
			if(playersInRushFFA == 1) {
				rushffaLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: 1 joueur");
			}
			else {
				rushffaLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInRushFFA + " joueurs");
			}
			gamesInvRushFFA.setLore(rushffaLore);
			gamesInvSandstone.setItemMeta(gamesInvRushFFA);
			
			ItemStack rushffaInvGIngot = new ItemStack(Material.GOLD_BLOCK);
			ItemMeta rushffaInvDeluxe = rushffaInvGIngot.getItemMeta();
			rushffaInvDeluxe.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "RushFFA " + ChatColor.RESET + "" + ChatColor.GOLD + "" + ChatColor.ITALIC + "Deluxe");
			List<String> deluxeLore = new ArrayList<String>();
			deluxeLore.add(ChatColor.YELLOW + "Le " + ChatColor.BOLD + "RushFFA " + ChatColor.RESET + "" + ChatColor.GOLD + "" + ChatColor.ITALIC + "Deluxe" + ChatColor.RESET + "" + ChatColor.YELLOW + " est une version");
			deluxeLore.add(ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "avec ponts" + ChatColor.RESET + "" + ChatColor.YELLOW + " du RushFFA Original. Dans ce mode de jeu,");
			deluxeLore.add(ChatColor.YELLOW + "un power-up qui apparaît toutes les " + ChatColor.UNDERLINE + "deux minutes" + ChatColor.RESET + "" + ChatColor.YELLOW + ": " + ChatColor.YELLOW + "l'" +  ChatColor.GOLD + "" + ChatColor.BOLD + "Élytra" + ChatColor.RESET + "" + ChatColor.YELLOW + ",");
			deluxeLore.add(ChatColor.YELLOW + "il a une faible durabilité mais avantage beaucoup celui qui l'obtient");
			deluxeLore.add(" ");
			int playersInDeluxex = Bukkit.getServer().getWorld("rushffaDeluxe").getPlayers().size();
			if(playersInDeluxex == 1) {
				deluxeLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: 1 joueur");
			}
			else {
				deluxeLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInDeluxex + " joueurs");
			}
			rushffaInvDeluxe.setLore(deluxeLore);
			rushffaInvGIngot.setItemMeta(rushffaInvDeluxe);
			
			ItemStack rushffaInvDIngot = new ItemStack(Material.DIAMOND_BLOCK);
			ItemMeta rushffaInvOriginal = rushffaInvDIngot.getItemMeta();
			rushffaInvOriginal.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "RushFFA " + ChatColor.RESET + "" + ChatColor.ITALIC + "Original");
			List<String> originalLore = new ArrayList<String>();
			originalLore.add(ChatColor.AQUA + "Le " + ChatColor.BOLD + "RushFFA " + ChatColor.RESET + "" + ChatColor.ITALIC + "Original" + ChatColor.RESET + "" + ChatColor.AQUA + " est la version");
			originalLore.add(ChatColor.AQUA + "" + ChatColor.UNDERLINE + "basique" + ChatColor.RESET + "" + ChatColor.AQUA + " du RushFFA. Dans ce mode de jeu,");
			originalLore.add(ChatColor.AQUA + "il n'y a pas de " + ChatColor.UNDERLINE + "ponts" + ChatColor.RESET + "" + ChatColor.AQUA + " mais des " +  ChatColor.BLUE + "" + ChatColor.BOLD + "plaques de pressions en or " + ChatColor.RESET + "" + ChatColor.AQUA + "qui");
			originalLore.add(ChatColor.AQUA + "font apparaitre un pont quand on marche dessus!");
			originalLore.add(" ");
			int playersInOriginalx = Bukkit.getServer().getWorld("rushffaOriginal").getPlayers().size();
			if(playersInOriginalx == 1) {
				originalLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: 1 joueur");
			}
			else {
				originalLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "En jeu: " + playersInOriginalx + " joueurs");
			}
			rushffaInvOriginal.setLore(originalLore);
			rushffaInvDIngot.setItemMeta(rushffaInvOriginal);
			
			ItemStack menuInvGlass = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
			ItemMeta menuInvDeco = menuInvGlass.getItemMeta();
			menuInvDeco.setDisplayName(ChatColor.DARK_AQUA + "*");
			menuInvGlass.setItemMeta(menuInvDeco);
			
			if(e.getCurrentItem().equals(menuCompass)) {
				e.getWhoClicked().openInventory(menuInv);
			}
			else if(e.getCurrentItem().equals(shopEmerald)) {
				e.getWhoClicked().openInventory(shopInv);
			}
			else if(e.getCurrentItem().equals(menuInvDoor)) {
				e.getWhoClicked().closeInventory();
			}
			else if(e.getCurrentItem().equals(menuInvComp)) {
				e.getWhoClicked().openInventory(settingsInv);
			}
			else if(e.getCurrentItem().equals(menuInvGapple)) {
				e.getWhoClicked().openInventory(gamesInv);
			}
			else if(e.getCurrentItem().equals(gamesInvSandstone)) {
				e.getWhoClicked().openInventory(rushffaInv);
			}
			else if(e.getCurrentItem().equals(rushffaInvGIngot)) {
				Player pl = Bukkit.getPlayerExact(e.getWhoClicked().getName());
				e.getWhoClicked().closeInventory();
				pl.chat("/play rushffa deluxe");
			}
			else if(e.getCurrentItem().equals(rushffaInvDIngot)) {
				Player pl = Bukkit.getPlayerExact(e.getWhoClicked().getName());
				e.getWhoClicked().closeInventory();
				pl.chat("/play rushffa original");
			}
			else if(e.getCurrentItem().equals(friendsHead)) {
				e.getWhoClicked().openInventory(accountInv);
			}
			else if(e.getCurrentItem().equals(menuInvGlass)) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerUseItem(PlayerInteractEvent e) {
		ItemStack menuCompass = new ItemStack(Material.COMPASS);
		ItemMeta mCim = menuCompass.getItemMeta();
		mCim.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Menu");
		menuCompass.setItemMeta(mCim);
		
		ItemStack shopEmerald = new ItemStack(Material.EMERALD);
		ItemMeta sEim = menuCompass.getItemMeta();
		sEim.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boutique");
		shopEmerald.setItemMeta(sEim);
		
		ItemStack friendsHead = new ItemStack(Material.PLAYER_HEAD);
		final Player player = Bukkit.getServer().getPlayer(e.getPlayer().getName());
		SkullMeta fHim = (SkullMeta) friendsHead.getItemMeta();
		fHim.setOwningPlayer(player);
		fHim.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mon compte");
		friendsHead.setItemMeta(fHim);
		if(e.getItem() == null || e.getItem().getType() == Material.AIR) {
			return;
		}
		else {
			if(e.getItem().equals(menuCompass)) {
				e.getPlayer().openInventory(menuInv);
			}
			else if(e.getItem().equals(shopEmerald)) {
				e.getPlayer().openInventory(shopInv);
			}
			else if(e.getItem().equals(friendsHead)) {
				e.getPlayer().openInventory(accountInv);
			}
		}
	}
}
