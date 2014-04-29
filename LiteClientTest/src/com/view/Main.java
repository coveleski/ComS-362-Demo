/**
 * 
 */
package com.view;

import java.util.Set;

import com.controller.interfaces.*;
import com.controller.*;
import com.model.interfaces.Light;

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

		while(true) {
			
			Set<Light> lights = controller.getAllLights();
			if(lights != null) {
				for(Light l : lights) {
					System.out.print("[Light Id=" + l.getID() + ", Group=" + l.getGroupID() + ", On=" + l.isOn() + 
							", Color=[Color r=" + l.getColor().getRed() + ", g=" + l.getColor().getGreen() + ", b=" + l.getColor().getBlue() + "]]" );
				}
			}
		}
	}

}
