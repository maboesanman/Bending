package com.maboesanman.plugins.Bending;

import org.bukkit.Location;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class FireBender implements Element {

	@Override
	public void leftAttack(Bender who, PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Location loc = player.getEyeLocation().toVector().add(player.getLocation().getDirection().multiply(2)).toLocation(player.getWorld(), player.getLocation().getYaw(), player.getLocation().getPitch());
		event.getPlayer().getWorld().spawn(loc, Fireball.class);
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
