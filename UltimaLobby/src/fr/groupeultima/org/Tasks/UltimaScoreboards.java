package fr.groupeultima.org.Tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
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
			    	        Score score5 = objective.getScore(ChatColor.AQUA + "→ Crédits: " + "0" + " CR"); // INSERT CREDITS METHOD INSERT CREDITS METHOD
			    	        score5.setScore(6);
			    	        Score score6 = objective.getScore("    ");
			    	        score6.setScore(5);
			    	        Score score7 = objective.getScore(ChatColor.GOLD + "→ Tokens: " + "0" + " ⛁"); // INSERT TOKENS METHOD INSERT TOKENS METHOD
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
			else if(e.getPlayer().getWorld() == Bukkit.getServer().getWorld("rushffaOriginal")) {
				new BukkitRunnable() {
		    		@Override
		            public void run() {
		    			if(e.getPlayer().getWorld() == Bukkit.getServer().getWorld("rushffaOriginal")) {
			    			ScoreboardManager amanager = Bukkit.getScoreboardManager();
			    	        final Scoreboard rfaO = amanager.getNewScoreboard();
			    	        final Objective aobjective = rfaO.registerNewObjective("rfaO", "rfaO", "rfaO");
			    	        aobjective.setDisplaySlot(DisplaySlot.SIDEBAR);
			    	        aobjective.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RushFFA" + ChatColor.RESET + "" + ChatColor.ITALIC + " Original");
			    	        Score ascore = aobjective.getScore(" ");
			    	        ascore.setScore(8);
			    	        Score ascore1 = aobjective.getScore(ChatColor.AQUA + "→ Kills: " + "0"); // INSERT KILLS METHOD INSERT KILLS METHOD
			    	        ascore1.setScore(7);
			    	        Score ascore2 = aobjective.getScore(ChatColor.AQUA + "→ Killstreak: " + "0"); // INSERT KILLSTREAK METHOD INSERT KILLSTREAK METHOD
			    	        ascore2.setScore(6);
			    	        Score ascore3 = aobjective.getScore(ChatColor.AQUA + "→ Morts: " + "0"); // INSERT DEATHS METHOD INSERT DEATH METHOD
			    	        ascore3.setScore(5);
			    	        Score ascore4 = aobjective.getScore(ChatColor.AQUA + "→ Ratio: " + "0" + " K/M"); // INSERT RATIO METHOD INSERT RATIO METHOD
			    	        ascore4.setScore(4);
			    	        Score ascore5 = aobjective.getScore("  ");
			    	        ascore5.setScore(3);
			    	        int ping = ((CraftPlayer) e.getPlayer()).getHandle().ping;
			    	        Score ascore6 = aobjective.getScore(ChatColor.GOLD + "→ Ping: " + ping + " ms");
			    	        ascore6.setScore(2);
			    	        Score ascore7 = aobjective.getScore("   ");
			    	        ascore7.setScore(1);
			    	        Score ascore8 = aobjective.getScore(ChatColor.BLUE + "" + "     " + ChatColor.UNDERLINE + "ultima.net");
			    	        ascore8.setScore(0);
			    	        e.getPlayer().setScoreboard(rfaO);
		    			}
		    			else { return; }
		            }
		    	}.runTaskTimer(UltimaLobby, 0, 40);
			}
			else if(e.getPlayer().getWorld() == Bukkit.getServer().getWorld("rushffaDeluxe")) {
				new BukkitRunnable() {
		    		@Override
		            public void run() {
		    			if(e.getPlayer().getWorld() == Bukkit.getServer().getWorld("rushffaDeluxe")) {
			    			ScoreboardManager bmanager = Bukkit.getScoreboardManager();
			    	        final Scoreboard rfaD = bmanager.getNewScoreboard();
			    	        final Objective bobjective = rfaD.registerNewObjective("rfaD", "rfaD", "rfaD");
			    	        bobjective.setDisplaySlot(DisplaySlot.SIDEBAR);
			    	        bobjective.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "RushFFA" + ChatColor.RESET + "" + ChatColor.GOLD+ "" + ChatColor.ITALIC + " Deluxe");
			    	        Score bscore = bobjective.getScore(" ");
			    	        bscore.setScore(8);
			    	        Score bscore1 = bobjective.getScore(ChatColor.AQUA + "→ Kills: " + "0"); // INSERT KILLS METHOD INSERT KILLS METHOD
			    	        bscore1.setScore(7);
			    	        Score bscore2 = bobjective.getScore(ChatColor.AQUA + "→ Killstreak: " + "0"); // INSERT KILLSTREAK METHOD INSERT KILLSTREAK METHOD
			    	        bscore2.setScore(6);
			    	        Score bscore3 = bobjective.getScore(ChatColor.AQUA + "→ Morts: " + "0"); // INSERT DEATHS METHOD INSERT DEATH METHOD
			    	        bscore3.setScore(5);
			    	        Score bscore4 = bobjective.getScore(ChatColor.AQUA + "→ Ratio: " + "0" + " K/M"); // INSERT RATIO METHOD INSERT RATIO METHOD
			    	        bscore4.setScore(4);
			    	        Score bscore5 = bobjective.getScore("  ");
			    	        bscore5.setScore(3);
			    	        int ping = ((CraftPlayer) e.getPlayer()).getHandle().ping;
			    	        Score bscore6 = bobjective.getScore(ChatColor.GOLD + "→ Ping: " + ping + " ms");
			    	        bscore6.setScore(2);
			    	        Score bscore7 = bobjective.getScore("   ");
			    	        bscore7.setScore(1);
			    	        Score bscore8 = bobjective.getScore(ChatColor.BLUE + "" + "     " + ChatColor.UNDERLINE + "ultima.net");
			    	        bscore8.setScore(0);
			    	        e.getPlayer().setScoreboard(rfaD);
		    			}
		    			else { return; }
		            }
		    	}.runTaskTimer(UltimaLobby, 0, 40);
			}
			else {
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				final Scoreboard noSidebar = manager.getNewScoreboard();
		        final Objective objectiveN = noSidebar.registerNewObjective("noSidebar", "noSidebar", "noSidebar");
		        objectiveN.setDisplaySlot(DisplaySlot.SIDEBAR);
				e.getPlayer().setScoreboard(noSidebar);
			}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		new BukkitRunnable() {
    		@Override
            public void run() {
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
	    	        Score score5 = objective.getScore(ChatColor.AQUA + "→ Crédits: " + "0" + " CR"); // INSERT CREDITS METHOD INSERT CREDITS METHOD
	    	        score5.setScore(6);
	    	        Score score6 = objective.getScore("    ");
	    	        score6.setScore(5);
	    	        Score score7 = objective.getScore(ChatColor.GOLD + "→ Tokens: " + "0" + " ⛁"); // INSERT TOKENS METHOD INSERT TOKENS METHOD
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
