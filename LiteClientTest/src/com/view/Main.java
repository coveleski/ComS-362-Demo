/**
 * 
 */
package com.view;

import java.util.Set;

import com.controller.interfaces.*;
import com.controller.*;
import com.model.Color;
import com.model.interfaces.*;

/**
 * @author Carl
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LightSwitchController controller  = new ConcreteLightSwitchController();
		if(args.length < 1)
			System.exit(0);

		if(args[0].toLowerCase() == "alllights") {
			System.out.println("Collecting Data");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
			}
			Set<Light> lights = controller.getAllLights();
			if(lights != null) {
				for(Light l : lights) {
					System.out.print("[Light Id=" + l.getID() + ", Group=" + l.getGroupID() + ", On=" + l.isOn() + 
							", Color=[Color r=" + l.getColor().getRed() + ", g=" + l.getColor().getGreen() + ", b=" + l.getColor().getBlue() + "]]" );
				}
			}
			else
				System.out.println("No Lights Found.");
		}
		else if(args[0].toLowerCase() == "allgroups") {
			System.out.println("Collecting Data");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
			}
			Set<Group> groups = controller.getAllGroups();
			if(groups != null) {
				for(Group g : groups) {
					System.out.println("[Group id=" + g.getID() + ", isOn=" + g.isOn() + ", Color=[Color r=" + g.getColor().getRed()+ ", g=" + g.getColor().getGreen() + ", b=" + g.getColor().getBlue() + "]]");
					for(Light l : g.getLights()) {
						System.out.print("\t[Light Id=" + l.getID() + ", Group=" + l.getGroupID() + ", On=" + l.isOn() + 
								", Color=[Color r=" + l.getColor().getRed() + ", g=" + l.getColor().getGreen() + ", b=" + l.getColor().getBlue() + "]]" );
					}
				}
			}
			else
				System.out.println("No groups Found.");
		}
		else if(args[0].toLowerCase() == "turnonlight") {
			if(args.length < 2)
				System.out.println("enter group id");
			int id = Integer.valueOf(args[1]);
			System.out.println("Collecting Data");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
			}
			if(controller.findLight(id).turnOn())
				System.out.println("Success");
			else
				System.out.println("Failure");	
		}
		else if(args[0].toLowerCase() == "turnofflight") {
			if(args.length < 2)
				System.out.println("enter group id");
			int id = Integer.valueOf(args[1]);
			System.out.println("Collecting Data");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
			}
			if(controller.findLight(id).turnOff())
				System.out.println("Success");
			else
				System.out.println("Failure");

		}
		else if(args[0].toLowerCase() == "removegroup") {
			if(args.length < 2)
				System.out.println("enter group id");
			int id = Integer.valueOf(args[1]);
			System.out.println("Collecting Data");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
			}
			if(controller.removeGroup(id))
				System.out.println("Success");
			else
				System.out.println("Failure");
		}
		else if(args[0].toLowerCase() == "findlight") {
			if(args.length < 2)
				System.out.println("enter group id");
			int id = Integer.valueOf(args[1]);
			System.out.println("Collecting Data");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
			}
			Light l = controller.findLight(id);
			if(l != null)
				System.out.print("\t[Light Id=" + l.getID() + ", Group=" + l.getGroupID() + ", On=" + l.isOn() + 
						", Color=[Color r=" + l.getColor().getRed() + ", g=" + l.getColor().getGreen() + ", b=" + l.getColor().getBlue() + "]]" );
			else
				System.out.println("Failure");
		}
		else if(args[0].toLowerCase() == "findgroup") {
			if(args.length < 2)
				System.out.println("enter group id");
			int id = Integer.valueOf(args[1]);
			System.out.println("Collecting Data");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
			}
			Group g = controller.findGroup(id);
			if(g!= null) {
				System.out.println("[Group id=" + g.getID() + ", isOn=" + g.isOn() + ", Color=[Color r=" + g.getColor().getRed()+ ", g=" + g.getColor().getGreen() + ", b=" + g.getColor().getBlue() + "]]");
				for(Light l : g.getLights()) {
					System.out.print("\t[Light Id=" + l.getID() + ", Group=" + l.getGroupID() + ", On=" + l.isOn() + 
							", Color=[Color r=" + l.getColor().getRed() + ", g=" + l.getColor().getGreen() + ", b=" + l.getColor().getBlue() + "]]" );
				}
			}
			else
				System.out.println("Failure");
		}
		else if(args[0].toLowerCase() == "changelightcolor") {
			if(args.length < 5)
				System.out.println("enter group id");
			int id = Integer.valueOf(args[1]);
			System.out.println("Collecting Data");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
			}
			if(controller.changeLightColor(id, new Color(Byte.valueOf(args[5]).byteValue(), Byte.valueOf(args[4]).byteValue(), Byte.valueOf(args[5]).byteValue())))
				System.out.println("Success");
			else
				System.out.println("Failure");
		}
		else {
			System.out.println("unsupported method");
			System.exit(0);
		}



	}

}
