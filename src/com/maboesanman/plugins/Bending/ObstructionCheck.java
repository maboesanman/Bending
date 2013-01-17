// there's an out of bounds error somewhere in here...

package com.maboesanman.plugins.Bending;

import java.util.Arrays;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ObstructionCheck {

	public static boolean canSee(Location loc1, Location loc2){
		double x1 = loc1.getX();
		double x2 = loc2.getX();
		double[] xValues;
		double y1 = loc1.getY();
		double y2 = loc2.getY();
		double[] yValues;
		double z1 = loc1.getZ();
		double z2 = loc2.getZ();
		double[] zValues;
		if(x1 < x2){
			int a = (int) (Math.floor(x2)-Math.floor(x1)+1);
			double c = x2-x1;
			xValues = new double[a];
			float b = (float) (Math.ceil(x1)-x1);
			for(int i = 0; i<a;i++){
				xValues[i] = ((b+i)/(c));
			}
		} else {
			int a = (int) (Math.floor(x1)-Math.floor(x2)+1);
			double c = x1-x2;
			xValues = new double[a];
			float b = (float) (Math.ceil(x2)-x2);
			for(int i = 0; i<a;i++){
				xValues[i] = ((b+i)/(c));
			}
		}
		if(y1 < y2){
			int a = (int) (Math.floor(y2)-Math.floor(y1)+1);
			double c = y2-y1;
			yValues = new double[a];
			float b = (float) (Math.ceil(y1)-y1);
			for(int i = 0; i<a;i++){
				yValues[i] = ((b+i)/(c));
			}
		} else {
			int a = (int) (Math.floor(y1)-Math.floor(y2)+1);
			double c = y1-y2;
			yValues = new double[a];
			float b = (float) (Math.ceil(y2)-y2);
			for(int i = 0; i<a;i++){
				yValues[i] = ((b+i)/(c));
			}
		}
		if(z1 < z2){
			int a = (int) (Math.floor(z2)-Math.floor(z1)+1);
			double c = z2-z1;
			zValues = new double[a];
			float b = (float) (Math.ceil(z1)-z1);
			for(int i = 0; i<a;i++){
				zValues[i] = ((b+i)/(c));
			}
		} else {
			int a = (int) (Math.floor(z1)-Math.floor(z2)+1);
			double c = z1-z2;
			zValues = new double[a];
			float b = (float) (Math.ceil(z2)-z2);
			for(int i = 0; i<a;i++){
				zValues[i] = ((b+i)/(c));
			}
		}
		
		double[] xyzValues = new double[xValues.length + yValues.length + zValues.length + 2];
		System.arraycopy(xValues, 0, xyzValues, 0, xValues.length);
		System.arraycopy(yValues, 0, xyzValues, xValues.length, yValues.length);
		System.arraycopy(zValues, 0, xyzValues, xValues.length + yValues.length, zValues.length);
		int l = xyzValues.length;
		xyzValues[l-2] = 0;
		xyzValues[l-1] = 1;
		Arrays.sort(xyzValues);
		Vector vec = loc2.toVector().subtract(loc1.toVector());
		for(int i=0; 1<l-1;i++){
			if((loc1.add(vec.multiply((xyzValues[i]+xyzValues[i+1])/2))).getBlock().getTypeId()!=0){
				return false;
			}
		}
		return true;
	}
}
