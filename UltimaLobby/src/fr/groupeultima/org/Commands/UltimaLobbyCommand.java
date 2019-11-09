package fr.groupeultima.org.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.groupeultima.org.UltimaLobby;
import net.md_5.bungee.api.ChatColor;

public class UltimaLobbyCommand implements CommandExecutor {
	
	UltimaLobby UltimaLobby;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("UltimaLobby")) {
			if(args.length == 0) {
				sender.sendMessage(" ");
				sender.sendMessage(ChatColor.DARK_GRAY + "\\__________________/" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "UltimaLobby" + ChatColor.RESET + "" + ChatColor.DARK_GRAY + "\\__________________/");
				sender.sendMessage(" ");
				sender.sendMessage(ChatColor.DARK_AQUA + "      → Commands:");
				sender.sendMessage(ChatColor.AQUA + "               - /ultimalobby reload → Reload .yml files");
				sender.sendMessage(" ");
				sender.sendMessage(ChatColor.DARK_GRAY + "\\___________________________________________________/");
				sender.sendMessage(" ");
			}
			else if(args.length == 1) {
				if(args[0].equalsIgnoreCase("reload")) {
					sender.sendMessage(ChatColor.YELLOW + "[UltimaLobby] Reload .yml files...");
					try {
						UltimaLobby.reloadConfig();
						sender.sendMessage(ChatColor.GREEN + "[UltimaLobby] Succefully reloaded .yml files.");
					} catch(Exception e) {
						sender.sendMessage(ChatColor.DARK_RED + "[UltimaLobby] An error occured while reloading .yml files, please check them.");
						sender.sendMessage(ChatColor.RED + "[UltimaLobby] A detailled error has been parsed in console.");
						e.printStackTrace();
					}
				}
			}
			else {
				sender.sendMessage(ChatColor.RED + "[UltimaLobby] Too many arguments. Please execute /ultimalobby for help.");
			}
		}
	return false;
	}
}
