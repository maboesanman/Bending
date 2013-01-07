package com.maboesanman.plugins.Bending;

import org.bukkit.event.player.PlayerInteractEvent;

public interface Element {
	public String getElementString();
	public void leftAttack(Bender who, PlayerInteractEvent event);
	public void rightAttack(Bender who, PlayerInteractEvent event);
	public void leftDefend(Bender who, PlayerInteractEvent event);
	public void rightDefend(Bender who, PlayerInteractEvent event);
	
}
