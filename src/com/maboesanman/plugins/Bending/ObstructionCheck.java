package com.maboesanman.plugins.Bending;

import org.bukkit.Location;

public class ObstructionCheck {

	public static boolean canSee(Location loc1, Location loc2){
		double x1 = loc1.getX();
		double x2 = loc2.getX();
		double y1 = loc1.getY();
		double y2 = loc2.getY();
		double z1 = loc1.getZ();
		double z2 = loc2.getZ();
		if(x1 < x2){
			int a = (int) (Math.floor(x2)-Math.floor(x1)+1);
			double[] xValues = new double[a];
			float b = (float) (Math.ceil(x1)-x1);
			for(int i = 0; i<a;i++){
				xValues[i] = ((b+i)/(x2-x1));
			}
		} else {
			int a = (int) (Math.floor(x2)-Math.floor(x1)+1);
			double[] xValues = new double[a];
			float b = (float) (Math.ceil(x1)-x1);
			for(int i = 0; i<a;i++){
				xValues[i] = ((b+i)/(x2-x1));
			}
		}
		
	}
	
}
