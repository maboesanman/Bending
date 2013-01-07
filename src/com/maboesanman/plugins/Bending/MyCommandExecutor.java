package com.maboesanman.plugins.Bending;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyCommandExecutor implements CommandExecutor {

	public Bending myPlugin;
	
	public MyCommandExecutor(Bending plugin) {
		myPlugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setelement")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				return false;
			} else {
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("waterbender")){
						AttributeRetriever.setPlayerElement((Player) sender, new WaterBender(), myPlugin);
						return true;
					}
					if(args[0].equalsIgnoreCase("earthbender")){
						AttributeRetriever.setPlayerElement((Player) sender, new EarthBender(myPlugin), myPlugin);
						return true;
					}
					if(args[0].equalsIgnoreCase("firebender")){
						AttributeRetriever.setPlayerElement((Player) sender, new FireBender(), myPlugin);
						return true;
					}
					if(args[0].equalsIgnoreCase("airbender")){
						AttributeRetriever.setPlayerElement((Player) sender, new AirBender(), myPlugin);
						return true;
					}
					if(args[0].equalsIgnoreCase("nonbender")){
						AttributeRetriever.setPlayerElement((Player) sender, new NonBender(), myPlugin);
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

