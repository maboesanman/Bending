package com.maboesanman.plugins.Bending;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class AttributeRetriever {

	public static Element getPlayerElement(Player p, Bending myPlugin){
		String elementString = (String) myPlugin.getConfig().get(p.getName()+".element", "nonbender");
		Element e;
		switch (elementString) {
			case "nonbender":
				e = new NonBender();
				break;
			case "waterbender":
				e = new WaterBender();
				break;
			case "earthbender":
				e = new EarthBender(myPlugin);
				break;
			case "firebender":
				e = new FireBender();
				break;
			case "airbender":
				e = new AirBender();
				break;
			default:
				e = new NonBender();
				break;
		 }
		myPlugin.saveConfig();
		return e;
	}
	public static void setPlayerElement(Player p, Element e, Bending myPlugin){
		FileConfiguration fileConfig = myPlugin.getConfig();
		fileConfig.set(p.getName()+".element", e.getElementString());
	}
}
