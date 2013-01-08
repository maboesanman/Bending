package com.maboesanman.plugins.Bending;

import org.bukkit.Location;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class FireBender implements Element {

	Bending myPlugin;
	
	public FireBender(Bending p){
		myPlugin = p;
	}
	
	@Override
	public void leftAttack(Bender who, PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(AttributeRetriever.canPlayerAttack(player, myPlugin)){
			Location loc = player.getEyeLocation().toVector().add(player.getLocation().getDirection().multiply(2)).toLocation(player.getWorld(), player.getLocation().getYaw(), player.getLocation().getPitch());
			event.getPlayer().getWorld().spawn(loc, Fireball.class);
			AttributeRetriever.setPlayerAttackWaitTime(player, Long.valueOf(0), myPlugin);
		} else {
			player.sendMessage("cooling down");
		}
	}

	@Override
	public void rightAttack(Bender who, PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(AttributeRetriever.canPlayerAttack(player, myPlugin)){
			// TODO fill in action
			AttributeRetriever.setPlayerAttackWaitTime(player, Long.valueOf(0), myPlugin);
		} else {
			player.sendMessage("cooling down");
		}
	}

	@Override
	public void leftDefend(Bender who, PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(AttributeRetriever.canPlayerAttack(player, myPlugin)){
			// TODO fill in action
			AttributeRetriever.setPlayerAttackWaitTime(player, Long.valueOf(0), myPlugin);
		} else {
			player.sendMessage("cooling down");
		}
	}

	@Override
	public void rightDefend(Bender who, PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(AttributeRetriever.canPlayerAttack(player, myPlugin)){
			// TODO fill in action
			AttributeRetriever.setPlayerAttackWaitTime(player, Long.valueOf(0), myPlugin);
		} else {
			player.sendMessage("cooling down");
		}
	}

	@Override
	public String getElementString() {
		return "firebender";
	}

}
