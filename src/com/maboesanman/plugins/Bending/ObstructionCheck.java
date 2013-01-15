package com.maboesanman.plugins.Bending;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Location;

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
		double[] xyzValues = new double[] {0.0,1.0} + xValues + yValues + zValues;
		
//		int[] array1and2 = new int[array1.length + array2.length];
//		System.arraycopy(array1, 0, array1and2, 0, array1.length);
//		System.arraycopy(array2, 0, array1and2, array1.length, array2.length);
	}
}
