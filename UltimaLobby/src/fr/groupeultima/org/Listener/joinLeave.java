package fr.groupeultima.org.Listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.groupeultima.org.UltimaLobby;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class joinLeave implements Listener {
	
	UltimaLobby UltimaLobby;
	
	public joinLeave(UltimaLobby instance)
	{
		UltimaLobby = instance;
	}
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent e) {
		World newWorld = e.getPlayer().getWorld();
		if(newWorld == Bukkit.getServer().getWorld("hub")) {
			e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§b§lUtilisez la boussole pour acceder au menu principal!"));
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().setGameMode(GameMode.SURVIVAL);
		// heal n feed
		e.getPlayer().setHealth(20);
		e.getPlayer().setFoodLevel(20);
		// ding sound
		e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 1);
		// title
		e.getPlayer().sendTitle(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Ultima", ChatColor.BLUE + "Bon retour parmis nous, " + e.getPlayer().getName());
		// public join message
		e.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "+" + ChatColor.DARK_GRAY + "] " + ChatColor.BLUE + "" + ChatColor.BOLD + e.getPlayer().getName() + ChatColor.RESET + "" + ChatColor.GRAY + " s'est connecté.");
		// tp to hub
		Location hub = new Location(Bukkit.getServer().getWorld("hub"), 0.500, 30, 0.500);
		e.getPlayer().teleport(hub);
		// welcome message to player
		e.getPlayer().sendMessage(" ");
		e.getPlayer().sendMessage(ChatColor.DARK_GRAY + "\\_____________________/" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Ultima" + ChatColor.RESET + "" + ChatColor.DARK_GRAY + "\\_____________________/");
		e.getPlayer().sendMessage(" ");
		e.getPlayer().sendMessage(" ");
		e.getPlayer().sendMessage("                                " + ChatColor.GOLD + "◆ " + ChatColor.DARK_AQUA + "" + ChatColor.UNDERLINE + "" + ChatColor.BOLD + "Ultima" + ChatColor.RESET + ChatColor.GOLD + " ◆                                ");
		e.getPlayer().sendMessage("                        Bon retour parmis nous!                        ");
		e.getPlayer().sendMessage(" ");
		e.getPlayer().sendMessage(" ");
		TextComponent msg = new TextComponent(ChatColor.BLUE + "Si vous ne l'avez pas encore fait, lisez les règles (/regles)");
		msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/regles"));
		msg.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( ChatColor.GOLD + "Cliquez ici pour lire les règles !" ).create() ) );
		e.getPlayer().spigot().sendMessage(msg);
		e.getPlayer().sendMessage(ChatColor.DARK_GRAY + "\\_________________________________________________/");
		e.getPlayer().sendMessage(" ");
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "-" + ChatColor.DARK_GRAY + "] " + ChatColor.BLUE + "" + ChatColor.BOLD + e.getPlayer().getName() + ChatColor.RESET + "" + ChatColor.GRAY + " s'est déconnecté.");
	}
	
	@EventHandler
	public void onChatMessage(AsyncPlayerChatEvent e) {
		if(e.getPlayer().isOp() == true) {
			if(e.getPlayer().getUniqueId().toString().equals("d330ff2b-149d-47fc-9188-2c9ccf3e6e5c") || e.getPlayer().getUniqueId().toString().equals("6d588f8a-ce08-4797-9ddf-88d911702d34")) {
				e.setFormat(ChatColor.DARK_RED + "[Fondateur] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
			}
		}
		else if(e.getPlayer().hasPermission("rank.fondateur")) {
			e.setFormat(ChatColor.DARK_RED + "[Fondateur] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else if(e.getPlayer().hasPermission("rank.administrateur")) {
			e.setFormat(ChatColor.RED + "[Administrateur] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else if(e.getPlayer().hasPermission("rank.builder")) {
			e.setFormat(ChatColor.GREEN + "[Builder] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else if(e.getPlayer().hasPermission("rank.moderateur")) {
			e.setFormat(ChatColor.GOLD + "[Modérateur] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else if(e.getPlayer().hasPermission("rank.helper")) {
			e.setFormat(ChatColor.DARK_PURPLE + "[Helper] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else if(e.getPlayer().hasPermission("rank.ami")) {
			e.setFormat(ChatColor.AQUA + "[Ami] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else if(e.getPlayer().hasPermission("rank.youtubeur")) {
			e.setFormat(ChatColor.GOLD + "[Youtubeur] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else if(e.getPlayer().hasPermission("rank.megavip")) {
			e.setFormat(ChatColor.LIGHT_PURPLE + "[MégaVIP] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else if(e.getPlayer().hasPermission("rank.supervip")) {
			e.setFormat(ChatColor.DARK_PURPLE + "[SuperVIP] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else if(e.getPlayer().hasPermission("rank.vip")) {
			e.setFormat(ChatColor.YELLOW + "[VIP] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else if(e.getPlayer().hasPermission("rank.minivip")) {
			e.setFormat(ChatColor.BLUE + "[MiniVIP] " + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
		else {
			e.setFormat(ChatColor.GRAY + "" + e.getPlayer().getDisplayName() + " » " + e.getMessage());
		}
	}
}
