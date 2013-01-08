package com.maboesanman.plugins.Bending;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MyCommandExecutor implements CommandExecutor {

	public Bending myPlugin;
	
	public MyCommandExecutor(Bending plugin) {
		myPlugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setelement")) {
			FileConfiguration fileConfig = myPlugin.getConfig();
			if(args.length == 2){
				if(myPlugin.getServer().getPlayer(args[0]) == null){
					sender.sendMessage("player non found");
					return false;
				} else {
					if(args[1].equalsIgnoreCase("waterbender")){
						fileConfig.set(args[0]+".element", "waterbender");
						return true;
					}
					if(args[1].equalsIgnoreCase("earthbender")){
						fileConfig.set(args[0]+".element", "earthbender");
						return true;
					}
					if(args[1].equalsIgnoreCase("firebender")){
						fileConfig.set(args[0]+".element", "firebender");
						return true;
					}
					if(args[1].equalsIgnoreCase("airbender")){
						fileConfig.set(args[0]+".element", "airbender");
						return true;
					}
					if(args[1].equalsIgnoreCase("nonbender")){
						fileConfig.set(args[0]+".element", "nonbender");
						return true;
					}
				}
				sender.sendMessage("incorrect use!! example: /setelement notch waterbender");
				return false;
			}
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				return false;
			} else {
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("waterbender")){
						AttributeRetriever.setPlayerElement((Player) sender, new WaterBender(myPlugin), myPlugin);
						sender.sendMessage("you are now a "+ChatColor.BLUE+"waterbender");
						return true;
					}
					if(args[0].equalsIgnoreCase("earthbender")){
						AttributeRetriever.setPlayerElement((Player) sender, new EarthBender(myPlugin), myPlugin);
						sender.sendMessage("you are now an "+ChatColor.GREEN+"earthbender");
						return true;
					}
					if(args[0].equalsIgnoreCase("firebender")){
						AttributeRetriever.setPlayerElement((Player) sender, new FireBender(myPlugin), myPlugin);
						sender.sendMessage("you are now a "+ChatColor.RED+"firebender");
						return true;
					}
					if(args[0].equalsIgnoreCase("airbender")){
						AttributeRetriever.setPlayerElement((Player) sender, new AirBender(myPlugin), myPlugin);
						sender.sendMessage("you are now an "+ChatColor.GRAY+"airbender");
						return true;
					}
					if(args[0].equalsIgnoreCase("nonbender")){
						AttributeRetriever.setPlayerElement((Player) sender, new NonBender(), myPlugin);
						sender.sendMessage("you are now a nonbender");
						return true;
					}
					
				} else {
					sender.sendMessage("incorrect use!! example: /setelement waterbender");
					return false;
				}
			}
		}
		return false;
	}
}

