package com.maboesanman.plugins.Bending;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class AirBender implements Element {

	Bending myPlugin;
	
	public AirBender(Bending p) {
		myPlugin = p;
	}

	@Override
	public void leftAttack(Bender who, PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(AttributeRetriever.canPlayerAttack(player, myPlugin)){
			// TODO fill in action
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
		return "airbender";
		
	}
}
