package com.maboesanman.plugins.Bending;

import org.bukkit.event.player.PlayerInteractEvent;

public class NonBender implements Element{

	@Override
	public void leftAttack(Bender who, PlayerInteractEvent event) {
	}

	@Override
	public void rightAttack(Bender who, PlayerInteractEvent event) {
	}

	@Override
	public void leftDefend(Bender who, PlayerInteractEvent event) {
	}

	@Override
	public void rightDefend(Bender who, PlayerInteractEvent event) {
	}

	@Override
	public String getElementString() {
		return "nonbender";
	}

}
