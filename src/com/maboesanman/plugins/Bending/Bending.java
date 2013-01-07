package com.maboesanman.plugins.Bending;

import org.bukkit.plugin.java.JavaPlugin;

public class Bending extends JavaPlugin{

	@Override
	public void onEnable(){
		getCommand("setelement").setExecutor(new MyCommandExecutor(this));
		getServer().getPluginManager().registerEvents(new BendingListener(this),this);
	}
}
