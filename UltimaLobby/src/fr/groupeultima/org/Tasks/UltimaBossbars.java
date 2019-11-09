package fr.groupeultima.org.Tasks;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.scheduler.BukkitRunnable;

import fr.groupeultima.org.UltimaLobby;

public class UltimaBossbars implements Listener {
	
	UltimaLobby UltimaLobby;
	
	public UltimaBossbars(UltimaLobby instance)
	{
		UltimaLobby = instance;
	}
	

	public static BossBar hubBossbar = Bukkit.createBossBar("[Ultima] Chargement..", BarColor.BLUE, BarStyle.SOLID);
	
	@EventHandler
	public void onPluginEnable(PluginEnableEvent e) {
		new BukkitRunnable() {
			int i = 0;
			@Override
			public void run() {
				if(i == 0) { // 1
					if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color1") != null && !UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.text1").equals("-1")) {
						if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color1").equals("BLUE") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color1").equals("GREEN") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color1").equals("PURPLE") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color1").equals("RED") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color1").equals("PINK") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color1").equals("YELLOW") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color1").equals("WHITE")) {
							if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style1") != null && UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style1").equals("SOLID") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style1").equals("SEGMENTED_10") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style1").equals("SEGMENTED_12") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style1").equals("SEGMENTED_6") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style1").equals("SEGMENTED_20")) {
								hubBossbar.setColor(BarColor.valueOf(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color1")));
								hubBossbar.setStyle(BarStyle.valueOf(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style1")));
								String hubBossbarText1 = UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.text1").replaceAll("&", "§");
								hubBossbar.setTitle(hubBossbarText1);
							}
							else {
								hubBossbar.setColor(BarColor.RED);
								hubBossbar.setStyle(BarStyle.SOLID);
								hubBossbar.setTitle("§3[Ultima] §4Error on style, please check yml.");
							}
						}
						else {
							hubBossbar.setColor(BarColor.RED);
							hubBossbar.setStyle(BarStyle.SOLID);
							hubBossbar.setTitle("§3[Ultima] §4Error on color, please check yml.");
						}
					}
					i++;
					return;
				}
				if(i == 1) { // 2
					if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color2") != null && !UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.text2").equals("-1")) {
						if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color2").equals("BLUE") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color2").equals("GREEN") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color2").equals("PURPLE") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color2").equals("RED") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color2").equals("PINK") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color2").equals("YELLOW") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color2").equals("WHITE")) {
							if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style2") != null && UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style2").equals("SOLID") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style2").equals("SEGMENTED_10") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style2").equals("SEGMENTED_12") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style2").equals("SEGMENTED_6") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style2").equals("SEGMENTED_20")) {
								hubBossbar.setColor(BarColor.valueOf(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color2")));
								hubBossbar.setStyle(BarStyle.valueOf(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style2")));
								String hubBossbarText2 = UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.text2").replaceAll("&", "§");
								hubBossbar.setTitle(hubBossbarText2);
							}
							else {
								hubBossbar.setColor(BarColor.RED);
								hubBossbar.setStyle(BarStyle.SOLID);
								hubBossbar.setTitle("§3[Ultima] §4Error on style, please check yml.");
							}
							
						}
						else {
							hubBossbar.setColor(BarColor.RED);
							hubBossbar.setStyle(BarStyle.SOLID);
							hubBossbar.setTitle("§3[Ultima] §4Error on color, please check yml.");
						}
					}
					i++;
					return;
				}
				if(i == 2) { // 3
					if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color3") != null && !UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.text3").equals("-1")) {
						if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color3").equals("BLUE") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color3").equals("GREEN") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color3").equals("PURPLE") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color3").equals("RED") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color3").equals("PINK") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color3").equals("YELLOW") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color3").equals("WHITE")) {
							if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style3") != null && UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style3").equals("SOLID") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style3").equals("SEGMENTED_10") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style3").equals("SEGMENTED_12") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style3").equals("SEGMENTED_6") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style3").equals("SEGMENTED_20")) {
								hubBossbar.setColor(BarColor.valueOf(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color3")));
								hubBossbar.setStyle(BarStyle.valueOf(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style3")));
								String hubBossbarText3 = UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.text3").replaceAll("&", "§");
								hubBossbar.setTitle(hubBossbarText3);
							}
							else {
								hubBossbar.setColor(BarColor.RED);
								hubBossbar.setStyle(BarStyle.SOLID);
								hubBossbar.setTitle("§3[Ultima] §4Error on style, please check yml.");
							}
							
						}
						else {
							hubBossbar.setColor(BarColor.RED);
							hubBossbar.setStyle(BarStyle.SOLID);
							hubBossbar.setTitle("§3[Ultima] §4Error on color, please check yml.");
						}
					}
					i++;
					return;
				}
				if(i == 3) { // 4
					if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color4") != null && !UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.text4").equals("-1")) {
						if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color4").equals("BLUE") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color4").equals("GREEN") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color4").equals("PURPLE") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color4").equals("RED") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color4").equals("PINK") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color4").equals("YELLOW") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color4").equals("WHITE")) {
							if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style4") != null && UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style4").equals("SOLID") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style4").equals("SEGMENTED_10") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style4").equals("SEGMENTED_12") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style4").equals("SEGMENTED_6") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style4").equals("SEGMENTED_20")) {
								hubBossbar.setColor(BarColor.valueOf(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color4")));
								hubBossbar.setStyle(BarStyle.valueOf(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style4")));
								String hubBossbarText4 = UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.text4").replaceAll("&", "§");
								hubBossbar.setTitle(hubBossbarText4);
							}
							else {
								hubBossbar.setColor(BarColor.RED);
								hubBossbar.setStyle(BarStyle.SOLID);
								hubBossbar.setTitle("§3[Ultima] §4Error on style, please check yml.");
							}
							
						}
						else {
							hubBossbar.setColor(BarColor.RED);
							hubBossbar.setStyle(BarStyle.SOLID);
							hubBossbar.setTitle("§3[Ultima] §4Error on color, please check yml.");
						}
					}
					i++;
					return;
				}
				if(i == 4) { // 5
					if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color5") != null && !UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.text5").equals("-1")) {
						if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color5").equals("BLUE") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color5").equals("GREEN") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color5").equals("PURPLE") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color5").equals("RED") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color5").equals("PINK") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color5").equals("YELLOW") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color5").equals("WHITE")) {
							if(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style5") != null && UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style5").equals("SOLID") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style5").equals("SEGMENTED_10") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style5").equals("SEGMENTED_12") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style5").equals("SEGMENTED_6") || UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style5").equals("SEGMENTED_20")) {
								hubBossbar.setColor(BarColor.valueOf(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.color5")));
								hubBossbar.setStyle(BarStyle.valueOf(UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.style5")));
								String hubBossbarText5 = UltimaLobby.getConfig().getString("Bossbar.LobbyBossbar.text5").replaceAll("&", "§");
								hubBossbar.setTitle(hubBossbarText5);
							}
							else {
								hubBossbar.setColor(BarColor.RED);
								hubBossbar.setStyle(BarStyle.SOLID);
								hubBossbar.setTitle("§3[Ultima] §4Error on style, please check yml.");
							}
							
						}
						else {
							hubBossbar.setColor(BarColor.RED);
							hubBossbar.setStyle(BarStyle.SOLID);
							hubBossbar.setTitle("§3[Ultima] §4Error on color, please check yml.");
						}
					}
				}
				i = 0;
				return;
			}
		}.runTaskTimer(UltimaLobby, 0, 100);
		
		new BukkitRunnable() {
			double i = 0.0;
			@Override
			public void run() {
				if(i == 0.0) {
					hubBossbar.setProgress(0.0);
					i = 0.1;
					return;
				}
				if(i == 0.1) {
					hubBossbar.setProgress(0.1);
					i = 0.2;
					return;
				}
				if(i == 0.2) {
					hubBossbar.setProgress(0.2);
					i = 0.3;
					return;
				}
				if(i == 0.3) {
					hubBossbar.setProgress(0.3);
					i = 0.4;
					return;
				}
				if(i == 0.4) {
					hubBossbar.setProgress(0.4);
					i = 0.5;
					return;
				}
				if(i == 0.5) {
					hubBossbar.setProgress(0.5);
					i = 0.6;
					return;
				}
				if(i == 0.6) {
					hubBossbar.setProgress(0.6);
					i = 0.7;
					return;
				}
				if(i == 0.7) {
					hubBossbar.setProgress(0.7);
					i = 0.8;
					return;
				}
				if(i == 0.8) {
					hubBossbar.setProgress(0.8);
					i = 0.9;
					return;
				}
				if(i == 0.9) {
					hubBossbar.setProgress(0.9);
					i = 1.0;
					return;
				}
				if(i == 1.0) {
					hubBossbar.setProgress(1.0);
					i = 0.91;
					return;
				}
				if(i == 0.91) {
					hubBossbar.setProgress(0.9);
					i = 0.81;
					return;
				}
				if(i == 0.81) {
					hubBossbar.setProgress(0.8);
					i = 0.71;
					return;
				}
				if(i == 0.71) {
					hubBossbar.setProgress(0.7);
					i = 0.61;
					return;
				}
				if(i == 0.61) {
					hubBossbar.setProgress(0.6);
					i = 0.51;
					return;
				}
				if(i == 0.51) {
					hubBossbar.setProgress(0.5);
					i = 0.41;
					return;
				}
				if(i == 0.41) {
					hubBossbar.setProgress(0.4);
					i = 0.31;
					return;
				}
				if(i == 0.31) {
					hubBossbar.setProgress(0.3);
					i = 0.21;
					return;
				}
				if(i == 0.21) {
					hubBossbar.setProgress(0.2);
					i = 0.11;
					return;
				}
				if(i == 0.11) {
					hubBossbar.setProgress(0.1);
					i = 0.0;
					return;
				}
			}
		}.runTaskTimer(UltimaLobby, 0, 10);
	}
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent e) {
		if(e.getPlayer().getWorld() == Bukkit.getServer().getWorld("hub")) {
			hubBossbar.removePlayer(e.getPlayer());
			hubBossbar.setProgress(1.0);
			hubBossbar.addPlayer(e.getPlayer());
		}
		else {
			hubBossbar.removePlayer(e.getPlayer());
			hubBossbar.removePlayer(e.getPlayer());
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		hubBossbar.addPlayer(e.getPlayer());
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		hubBossbar.removePlayer(e.getPlayer());
	}
}
