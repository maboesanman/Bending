package com.maboesanman.plugins.Bending;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;

public class BendingListener implements Listener{

	Bending myPlugin;
	
	public BendingListener(Bending b){
		myPlugin = b;
	}
	
	@EventHandler(ignoreCancelled = false)
	public void onClick(PlayerInteractEvent event){
		Player p = event.getPlayer();
		Bender bender = new Bender(p, AttributeRetriever.getPlayerElement(p, myPlugin));
		if(p.isSneaking()){
			if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK){
				bender.leftDefend(event);
			}
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
				bender.rightDefend(event);
			}
		} else {
			if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK){
				bender.leftAttack(event);
			}
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
				bender.rightAttack(event);
			}
		}
	}
	
	@EventHandler
	public void onPlaceBlock(BlockPlaceEvent event){
		if(!(AttributeRetriever.getPlayerElement(event.getPlayer(), myPlugin).getElementString() == "nonbender")){
			event.setCancelled(true);
		}
	}
	@EventHandler
	public void onBreakBlock(BlockBreakEvent event){
		if(!(AttributeRetriever.getPlayerElement(event.getPlayer(), myPlugin).getElementString() == "nonbender")){
			event.setCancelled(true);
		}
	}
}