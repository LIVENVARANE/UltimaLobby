package fr.groupeultima.org.Tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.groupeultima.library.identitycard.Identity;
import fr.groupeultima.org.UltimaLobby;

public class UltimaScoreboards implements Listener {
	
	UltimaLobby UltimaLobby;
	
	public UltimaScoreboards(UltimaLobby instance)
	{
		UltimaLobby = instance;
	}
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent e) {
		if(e.getPlayer().getWorld() == null) {
			return;
		}
		else {
			if(e.getPlayer().getWorld() == Bukkit.getServer().getWorld("hub")) {
				new BukkitRunnable() {
		    		@Override
		            public void run() {
		    			if(e.getPlayer().getWorld() == Bukkit.getServer().getWorld("hub")) {
		    				Identity player_info = new Identity();
			    			ScoreboardManager manager = Bukkit.getScoreboardManager();
			    	        final Scoreboard hubBoard = manager.getNewScoreboard();
			    	        final Objective objective = hubBoard.registerNewObjective("hubBoard", "hubBoard", "hubBoard");
			    	        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			    	        objective.setDisplayName(ChatColor.GOLD + "« " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Ultima" + ChatColor.RESET + "" + ChatColor.GOLD + " »");
			    	        Score score = objective.getScore("  ");
			    	        score.setScore(11);
			    	        Score score1 = objective.getScore(ChatColor.AQUA + "→ " + e.getPlayer().getName());
			    	        score1.setScore(10);
			    	        Score score2 = objective.getScore(" ");
			    	        score2.setScore(9);
			    	        if(Bukkit.getOnlinePlayers().size() == 1) {
			    	            Score score3 = objective.getScore(ChatColor.AQUA + "→ Connectés: " + Bukkit.getOnlinePlayers().size() + " joueur");
			    	            score3.setScore(8);
			    	        }
			    	        else {
			    	            Score score3 = objective.getScore(ChatColor.AQUA + "→ Connectés: " + Bukkit.getOnlinePlayers().size() + " joueurs");
			    	            score3.setScore(8);
			    	        }
			    	        Score score4 = objective.getScore("   ");
			    	        score4.setScore(7);
			    	        Score score5 = objective.getScore(ChatColor.AQUA + "→ Crédits: " + player_info.getCredit(e.getPlayer().getUniqueId()) + " CR");
			    	        score5.setScore(6);
			    	        Score score6 = objective.getScore("    ");
			    	        score6.setScore(5);
			    	        Score score7 = objective.getScore(ChatColor.GOLD + "→ Tokens: " + player_info.getToken(e.getPlayer().getUniqueId()) + " ⛁");
			    	        score7.setScore(4);
			    	        Score score8 = objective.getScore("      ");
			    	        score8.setScore(3);
			    	        int ping = ((CraftPlayer) e.getPlayer()).getHandle().ping;
			    	        Score score9 = objective.getScore(ChatColor.AQUA + "→ Ping: " + ping + " ms");
			    	        score9.setScore(2);
			    	        Score score10 = objective.getScore("     ");
			    	        score10.setScore(1);
			    	        Score score11 = objective.getScore(ChatColor.BLUE + "" + "           " + ChatColor.UNDERLINE + "ultima.net");
			    	        score11.setScore(0);
			    	        e.getPlayer().setScoreboard(hubBoard);
		    			}
		    			else { return; }
		            }
		    	}.runTaskTimer(UltimaLobby, 0, 40);
			}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		new BukkitRunnable() {
    		@Override
            public void run() {
    			Identity player_info = new Identity();
    			if(e.getPlayer().getWorld() == Bukkit.getServer().getWorld("hub")) {
	    			ScoreboardManager manager = Bukkit.getScoreboardManager();
	    	        final Scoreboard hubBoard = manager.getNewScoreboard();
	    	        final Objective objective = hubBoard.registerNewObjective("hubBoard", "hubBoard", "hubBoard");
	    	        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    	        objective.setDisplayName(ChatColor.GOLD + "« " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Ultima" + ChatColor.RESET + "" + ChatColor.GOLD + " »");
	    	        Score score = objective.getScore("  ");
	    	        score.setScore(11);
	    	        Score score1 = objective.getScore(ChatColor.AQUA + "→ " + e.getPlayer().getName());
	    	        score1.setScore(10);
	    	        Score score2 = objective.getScore(" ");
	    	        score2.setScore(9);
	    	        if(Bukkit.getOnlinePlayers().size() == 1) {
	    	            Score score3 = objective.getScore(ChatColor.AQUA + "→ Connectés: " + Bukkit.getOnlinePlayers().size() + " joueur");
	    	            score3.setScore(8);
	    	        }
	    	        else {
	    	            Score score3 = objective.getScore(ChatColor.AQUA + "→ Connectés: " + Bukkit.getOnlinePlayers().size() + " joueurs");
	    	            score3.setScore(8);
	    	        }
	    	        Score score4 = objective.getScore("   ");
	    	        score4.setScore(7);
	    	        Score score5 = objective.getScore(ChatColor.AQUA + "→ Crédits: " + player_info.getCredit(e.getPlayer().getUniqueId()) + " CR");
	    	        score5.setScore(6);
	    	        Score score6 = objective.getScore("    ");
	    	        score6.setScore(5);
	    	        Score score7 = objective.getScore(ChatColor.GOLD + "→ Tokens: " + player_info.getToken(e.getPlayer().getUniqueId()) + " ⛁"); // INSERT TOKENS METHOD INSERT TOKENS METHOD
	    	        score7.setScore(4);
	    	        Score score8 = objective.getScore("      ");
	    	        score8.setScore(3);
	    	        int ping = ((CraftPlayer) e.getPlayer()).getHandle().ping;
	    	        Score score9 = objective.getScore(ChatColor.AQUA + "→ Ping: " + ping + " ms");
	    	        score9.setScore(2);
	    	        Score score10 = objective.getScore("     ");
	    	        score10.setScore(1);
	    	        Score score11 = objective.getScore(ChatColor.BLUE + "" + "           " + ChatColor.UNDERLINE + "ultima.net");
	    	        score11.setScore(0);
	    	        e.getPlayer().setScoreboard(hubBoard);
    			}
    			else { return; }
            }
    	}.runTaskTimer(UltimaLobby, 0, 40);
	}
}
