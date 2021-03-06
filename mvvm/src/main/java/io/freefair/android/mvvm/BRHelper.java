package io.freefair.android.mvvm;

import android.support.annotation.AnyRes;

import java.util.ArrayList;
import java.util.List;

import io.freefair.android.util.Logger;

/**
 * Created by Dennis on 18.06.2015.
 */
public class BRHelper
{
	private static List<Class<?>> brClasses = new ArrayList<>();

	@AnyRes
	public static int getBrByName(String name){
		for (Class<?> brClass :
				brClasses) {
			try {
				return (Integer) brClass.getDeclaredField(name).get(null);
			}catch (Exception ex){
				Logger.error(BRHelper.class, "Error while getDeclaredField: ", ex);
			}
		}
		return -1;
	}

	public static void addBrClass(Class<?> brClass){
		if(!brClasses.contains(brClass))
			brClasses.add(brClass);
	}
}
