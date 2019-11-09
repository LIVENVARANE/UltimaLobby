package fr.groupeultima.org.Tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.groupeultima.org.UltimaLobby;

public class UltimaChatMessages implements Runnable {

	UltimaLobby UltimaLobby;

	public UltimaChatMessages(UltimaLobby instance) {
		UltimaLobby = instance;
	}

	int i = 0;

	@Override
	public void run() {
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			if (i == 0) { // 1
				if (UltimaLobby.getConfig().getString("Chat.Everywhere.text1") != null
						&& !UltimaLobby.getConfig().getString("Chat.Everywhere.text1").equals("-1")) {
					String chatText1 = UltimaLobby.getConfig().getString("Chat.Everywhere.text1").replaceAll("&", "§");
					if (UltimaLobby.getConfig().getString("Chat.Everywhere.decoration1") != null
							&& UltimaLobby.getConfig().getString("Chat.Everywhere.decoration1").equals("1")) {
						p.sendMessage(" ");
						p.sendMessage(ChatColor.DARK_GRAY + "\\____________________________________________/");
						p.sendMessage(" ");
						p.sendMessage(chatText1);
						p.sendMessage(ChatColor.DARK_GRAY + "\\____________________________________________/");
						p.sendMessage(" ");
					} else {
						p.sendMessage(" ");
						p.sendMessage(chatText1);
						p.sendMessage(" ");
					}
				}
				i++;
				return;
			}
			if (i == 1) { // 2
				if (UltimaLobby.getConfig().getString("Chat.Everywhere.text2") != null
						&& !UltimaLobby.getConfig().getString("Chat.Everywhere.text2").equals("-1")) {
					String chatText2 = UltimaLobby.getConfig().getString("Chat.Everywhere.text2").replaceAll("&", "§");
					if (UltimaLobby.getConfig().getString("Chat.Everywhere.decoration2") != null
							&& UltimaLobby.getConfig().getString("Chat.Everywhere.decoration2").equals("1")) {
						p.sendMessage(" ");
						p.sendMessage(ChatColor.DARK_GRAY + "\\____________________________________________/");
						p.sendMessage(" ");
						p.sendMessage(chatText2);
						p.sendMessage(ChatColor.DARK_GRAY + "\\____________________________________________/");
						p.sendMessage(" ");
					} else {
						p.sendMessage(" ");
						p.sendMessage(chatText2);
						p.sendMessage(" ");
					}
				}
				i++;
				return;
			}
			if (i == 2) { // 3
				if (UltimaLobby.getConfig().getString("Chat.Everywhere.text3") != null
						&& !UltimaLobby.getConfig().getString("Chat.Everywhere.text3").equals("-1")) {
					String chatText3 = UltimaLobby.getConfig().getString("Chat.Everywhere.text3").replaceAll("&", "§");
					if (UltimaLobby.getConfig().getString("Chat.Everywhere.decoration3") != null
							&& UltimaLobby.getConfig().getString("Chat.Everywhere.decoration3").equals("1")) {
						p.sendMessage(" ");
						p.sendMessage(ChatColor.DARK_GRAY + "\\____________________________________________/");
						p.sendMessage(" ");
						p.sendMessage(chatText3);
						p.sendMessage(ChatColor.DARK_GRAY + "\\____________________________________________/");
						p.sendMessage(" ");
					} else {
						p.sendMessage(" ");
						p.sendMessage(chatText3);
						p.sendMessage(" ");
					}
				}
				i++;
				return;
			}
			if (i == 3) { // 4
				if (UltimaLobby.getConfig().getString("Chat.Everywhere.text4") != null
						&& !UltimaLobby.getConfig().getString("Chat.Everywhere.text4").equals("-1")) {
					String chatText4 = UltimaLobby.getConfig().getString("Chat.Everywhere.text4").replaceAll("&", "§");
					if (UltimaLobby.getConfig().getString("Chat.Everywhere.decoration4") != null
							&& UltimaLobby.getConfig().getString("Chat.Everywhere.decoration4").equals("1")) {
						p.sendMessage(" ");
						p.sendMessage(ChatColor.DARK_GRAY + "\\____________________________________________/");
						p.sendMessage(" ");
						p.sendMessage(chatText4);
						p.sendMessage(ChatColor.DARK_GRAY + "\\____________________________________________/");
						p.sendMessage(" ");
					} else {
						p.sendMessage(" ");
						p.sendMessage(chatText4);
						p.sendMessage(" ");
					}
				}
				i++;
				return;
			}
			if (i == 4) { // 5
				if (UltimaLobby.getConfig().getString("Chat.Everywhere.text5") != null
						&& !UltimaLobby.getConfig().getString("Chat.Everywhere.text5").equals("-1")) {
					String chatText5 = UltimaLobby.getConfig().getString("Chat.Everywhere.text5").replaceAll("&", "§");
					if (UltimaLobby.getConfig().getString("Chat.Everywhere.decoration5") != null
							&& UltimaLobby.getConfig().getString("Chat.Everywhere.decoration5").equals("1")) {
						p.sendMessage(" ");
						p.sendMessage(ChatColor.DARK_GRAY + "\\____________________________________________/");
						p.sendMessage(" ");
						p.sendMessage(chatText5);
						p.sendMessage(ChatColor.DARK_GRAY + "\\____________________________________________/");
						p.sendMessage(" ");
					} else {
						p.sendMessage(" ");
						p.sendMessage(chatText5);
						p.sendMessage(" ");
					}
				}
				i = 0;
				return;
			}
		}
	}
}