package fr.groupeultima.org.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import fr.groupeultima.org.UltimaLobby;

public class ServerMOTD implements Listener {

	UltimaLobby UltimaLobby;
	
	public ServerMOTD(UltimaLobby instance)
	{
		UltimaLobby = instance;
	}
	
	@EventHandler
	public void onServerPing(ServerListPingEvent e) {
		String MOTD = UltimaLobby.getConfig().getString("ServerMOTD.text").replaceAll("&", "§");
		e.setMotd(MOTD);
	}
	
}
