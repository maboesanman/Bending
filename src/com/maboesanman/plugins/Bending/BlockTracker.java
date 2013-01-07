package com.maboesanman.plugins.Bending;

import org.bukkit.Location;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class BlockTracker implements Runnable {

	private BukkitTask id;
	private FallingBlock myBlock;
	private Bending myPlugin;
	private Location originalLocation;
	
	public BlockTracker(FallingBlock fallingBlock, Location originalLocation, Bending plugin){
		myBlock = fallingBlock;
		myPlugin = plugin;
		this.originalLocation = originalLocation;
	}
	
	public void setId(BukkitTask task){
		id = task;
	}
	
	public void checkCollision() {
		Player[] players = myPlugin.getServer().getOnlinePlayers();
        for (int i = 0; i < players.length; i++) {
        	if(players[i].getEyeLocation().distanceSquared(myBlock.getLocation()) <= .25){
        		Vector vec = myBlock.getLocation().subtract(originalLocation).toVector().multiply(.25);
        		vec.setY(.25);
        		players[i].setVelocity(vec);
        		players[i].damage(7);
        	}
        }
	}
	@Override
	public void run() {
		while(myBlock.isValid()){
			checkCollision();
		}
		id.cancel();
	}
}