package com.maboesanman.plugins.Bending;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class Bender {
	Player me;
	Element myElement;
	
	public Bender(Player p, Element e){
		me = p;
		myElement = e;
	}
	
	public void leftAttack(PlayerInteractEvent event){
		myElement.leftAttack(this, event);
	}
	public void rightAttack(PlayerInteractEvent event){
		myElement.rightAttack(this, event);
	}
	public void leftDefend(PlayerInteractEvent event){
		myElement.leftDefend(this, event);
	}
	public void rightDefend(PlayerInteractEvent event){
		myElement.rightDefend(this, event);
	}
	public Player getPlayer(){
		return me;
	}
}
