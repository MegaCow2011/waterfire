package io.github.megacow2011.waterfire;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import org.bukkit.Bukkit;

public class Main extends JavaPlugin implements Listener{
	FileConfiguration config = getConfig();

    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	loadConfiguration();
        System.out.print("[WaterFire] Config Loaded!");
    }
    public boolean isAFK;
    
    	public void loadConfiguration(){
    	     //See "Creating you're defaults"
    		String youAreAwesome = "youAreAwesome" ; 
    		getConfig().addDefault(youAreAwesome, true);
    	    getConfig().options().copyDefaults(true);
    	    saveConfig();
    	    getConfig().options().copyDefaults(true); // NOTE: You do not have to use "plugin." if the class extends the java plugin
    	     //Save the config whenever you manipulate it
    	     saveConfig();
    	    reloadConfig();
    	}
    	    public void onPlayerJoin(PlayerJoinEvent event) {
    	        Player player = event.getPlayer();

    	        if (config.getBoolean("youAreAwesome")) {
    	            player.sendMessage("You are awesome!");
    	        } else {
    	            player.sendMessage("You are not awesome...");
    	        }

        }

    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	System.out.println("[WaterFire] is now disabled!");
   	
    }
    	  @Override
    	    public boolean onCommand(CommandSender sender,
    	            Command command,
    	            String label,
    	            String[] args) {
    	        if (command.getName().equalsIgnoreCase("saucy")) {
    	            sender.sendMessage("Andy Ren created this plugin XD");
    	            return true;
    	        }
    	        return false;
    	  }
    	          
  public boolean onCommand2(CommandSender sender, Command cmd, String label, String[] args){
	  	Player player = (Player) sender;
      if(cmd.getName().equalsIgnoreCase("afk")){
              isAFK = true;
              Bukkit.broadcastMessage(player.getDisplayName() + " §6ist is now AFK");
      }
     
      if(cmd.getName().equalsIgnoreCase("unafk")){
              if(isAFK){
                      isAFK = false;
                      Bukkit.broadcastMessage(player.getDisplayName() + " §6ist no longer AFK");
              } else {
                      player.sendMessage("§cDu is no longer AFK!");
              }	    		
           	    		
    	    	}
      return false;
  }
    	        
      @EventHandler
      public void onAFKMove(PlayerMoveEvent e){
              Player player = e.getPlayer();
              if(isAFK){
                      isAFK = false;
                      Bukkit.broadcastMessage(player.getDisplayName() + " §6ist now AFK");
              } else {
             }
      }
     
      @EventHandler
      public void onAFKInteract(PlayerInteractEvent e){
              Player player = e.getPlayer();
              if(isAFK){
                      isAFK = false;
                      Bukkit.broadcastMessage(player.getDisplayName() + " §6ist is no longer AFK");
              } else {
            
              }

    }
}