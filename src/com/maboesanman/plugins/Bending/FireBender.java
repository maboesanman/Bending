package com.maboesanman.plugins.Bending;

import org.bukkit.event.player.PlayerInteractEvent;

public class FireBender implements Element {

	@Override
	public void leftAttack(Bender who, PlayerInteractEvent event) {
		event.getPlayer().sendMessage("you're a firebender!");
	}

	@Override
	public void rightAttack(Bender who, PlayerInteractEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void leftDefend(Bender who, PlayerInteractEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightDefend(Bender who, PlayerInteractEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getElementString() {
		return "firebender";
	}

}
