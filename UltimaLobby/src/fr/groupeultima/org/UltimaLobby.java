package fr.groupeultima.org;
import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import fr.groupeultima.org.Commands.UltimaLobbyCommand;
import fr.groupeultima.org.Listener.ServerMOTD;
import fr.groupeultima.org.Listener.joinLeave;
import fr.groupeultima.org.Listener.lobbyItems;
import fr.groupeultima.org.Listener.lobbyProtection;
import fr.groupeultima.org.Tasks.UltimaActionbars;
import fr.groupeultima.org.Tasks.UltimaBossbars;
import fr.groupeultima.org.Tasks.UltimaChatMessages;
import fr.groupeultima.org.Tasks.UltimaScoreboards;

public class UltimaLobby extends JavaPlugin implements Listener {

	public static UltimaLobby plugin;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[UltimaLobby] " + ChatColor.YELLOW + "Loading advertissement messages...");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[UltimaLobby] " + ChatColor.YELLOW + "Loading [Bossbar:LobbyBossbar:text1=" + getConfig().getString("Bossbar.LobbyBossbar.text1") + ";color1=" + getConfig().getString("Bossbar.LobbyBossbar.color1") + ",text2=" + getConfig().getString("Bossbar.LobbyBossbar.text2") + ";color2=" + getConfig().getString("Bossbar.LobbyBossbar.color2") + ",text3=" + getConfig().getString("Bossbar.LobbyBossbar.text3") + ";color3=" + getConfig().getString("Bossbar.LobbyBossbar.color3") + ",text4=" + getConfig().getString("Bossbar.LobbyBossbar.text4") + ";color4=" + getConfig().getString("Bossbar.LobbyBossbar.color4") + ",text5=" + getConfig().getString("Bossbar.LobbyBossbar.text5") + ";color5=" + getConfig().getString("Bossbar.LobbyBossbar.color5") + "]");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[UltimaLobby] " + ChatColor.YELLOW + "Loading [Chat:Everywhere:text1=" + getConfig().getString("Chat.Everywhere.text1") + ";decoration1=" + getConfig().getString("Chat.Everywhere.decoration1") + ",text2=" + getConfig().getString("Chat.Everywhere.text2") + ";decoration2=" + getConfig().getString("Chat.Everywhere.decoration2") + ",text3=" + getConfig().getString("Chat.Everywhere.text3") + ";decoration3=" + getConfig().getString("Chat.Everywhere.decoration3") + ",text4=" + getConfig().getString("Chat.Everywhere.text4") + ";decoration4=" + getConfig().getString("Chat.Everywhere.decoration4") + ",text5=" + getConfig().getString("Chat.Everywhere.text5") + ";decoration5=" + getConfig().getString("Chat.Everywhere.decoration5") + "]");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[UltimaLobby] " + ChatColor.GOLD + "Plugin has started successfully.");		
		
		//load commands
		getCommand("ultimalobby").setExecutor(new UltimaLobbyCommand());
		
		// load classes
		getServer().getPluginManager().registerEvents(new joinLeave(this), this); // = join/leave hub/server
		getServer().getPluginManager().registerEvents(new lobbyProtection(this), this);
		getServer().getPluginManager().registerEvents(new UltimaScoreboards(this), this);
		getServer().getPluginManager().registerEvents(new lobbyItems(this), this);
		getServer().getPluginManager().registerEvents(new UltimaBossbars(this), this);
		getServer().getPluginManager().registerEvents(new ServerMOTD(this), this);
		
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new UltimaActionbars(this), 7 * 20L, 7 * 20L);
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new UltimaChatMessages(this), 0L, 123 * 20L);
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new UltimaActionbars(this), 7 * 20L, 7 * 20L);
		
		
	}
	
	@Override
	public void onDisable() {
		UltimaBossbars.hubBossbar.removeAll();
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[UltimaLobby] " + ChatColor.GOLD + "Disabling UltimaLobby");
		plugin = null;
	}
	
	public int ABi = 1; // UltimaActionbars.java
	
	public boolean loadConfig() {
		if(!new File(getDataFolder() + File.separator + "config.yml").exists()) {
			saveDefaultConfig();
		}
		try {
			new YamlConfiguration().load(new File(getDataFolder() + File.separator + "config.yml"));
		} catch(Exception e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[UltimaLobby] " + ChatColor.RED + "Error while loading config.yml");
			Bukkit.getConsoleSender().sendMessage("Please check error dump below.");
			Bukkit.getConsoleSender().sendMessage(" ");
		    e.printStackTrace();
		    Bukkit.getPluginManager().disablePlugin(this);
		      
		    return false;
		}
		reloadConfig();
		return true;
	}
	
	public File getFile() {
		return super.getFile();
	}
	
}