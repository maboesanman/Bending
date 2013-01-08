package com.maboesanman.plugins.Bending;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class EarthBender implements Element {

	Plugin myPlugin;
	
	public EarthBender(Plugin p){
		myPlugin = p;
	}
	
	@Override
	public void leftAttack(Bender who, PlayerInteractEvent event) {
		event.getPlayer().sendMessage("you're an earthbender!");
	}

	@Override
	public void rightAttack(Bender who, PlayerInteractEvent event) {
		Block block = event.getClickedBlock();
		BlockState state = block.getState();
		block.setTypeId(0);
		World w = state.getWorld();
		
		if(event.getBlockFace() == BlockFace.UP){
			state.getLocation().add(0,2,0).getBlock().setTypeIdAndData(state.getTypeId(), state.getRawData(), false);
		} else {
			FallingBlock projectile = (FallingBlock)w.spawnFallingBlock(state.getLocation(), state.getType(), state.getRawData());
			Vector v = event.getPlayer().getLocation().getDirection();
			projectile.setVelocity(v);
			BlockTracker bt = new BlockTracker(projectile, state.getLocation(), (Bending)myPlugin);
			BukkitTask task = Bukkit.getScheduler().runTaskTimerAsynchronously(myPlugin, bt, 2L, 3L);
			bt.setId(task);
		}
		

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
		return "earthbender";
	}
}
