package com.maboesanman.plugins.Bending;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class EarthBender implements Element {

	Bending myPlugin;
	
	public EarthBender(Bending p){
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
		return "earthbender";
	}
}
