package fr.groupeultima.org.Tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.groupeultima.org.UltimaLobby;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class UltimaActionbars implements Runnable {

	UltimaLobby UltimaLobby;

	public UltimaActionbars(UltimaLobby instance) {
		UltimaLobby = instance;
	}

	public void run() {
		for(Player e : Bukkit.getServer().getWorld("hub").getPlayers()) {
			if (UltimaLobby.ABi == 1) {
				e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,
						TextComponent.fromLegacyText("§b§lUtilisez la boussole pour acceder au menu principal!"));
				UltimaLobby.ABi++;
				return;
			}
			if (UltimaLobby.ABi == 2) {
				e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,
						TextComponent.fromLegacyText("§b§lFaites /regles pour lire les règles!"));
				UltimaLobby.ABi++;
				return;
			}
			if (UltimaLobby.ABi == 3) {
				e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,
						TextComponent.fromLegacyText("§b§lFaites /ping pour voir votre ping!"));
				UltimaLobby.ABi++;
				return;
			}
			if (UltimaLobby.ABi == 4) {
				e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,
						TextComponent.fromLegacyText("§3§lPROMO OUVERTURE: -50% sur TOUTE la boutique!"));
				UltimaLobby.ABi = 1;
				return;
			}
		}
	}
}
