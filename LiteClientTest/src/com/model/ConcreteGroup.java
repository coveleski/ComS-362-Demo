/**
 * 
 */
package com.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.model.interfaces.Light;
import com.model.interfaces.Group;

/**
 * @author Carl, David, Qian
 *
 */
public class ConcreteGroup implements Group {
	private int groupId;
	private Set<Light> lights;
	private HashMap<Integer, Light> lightmap;
	private HashMap<Integer, ScheduledToggle> toggles;
	private boolean on;
	private Color color;
	
	public ConcreteGroup(int groupId, Set<Light> lights) {
		this.groupId = groupId;
		this.lights = lights;
		this.on = false;
		this.color = new Color((byte)255, (byte)255, (byte)255);
		lightmap = new HashMap<Integer, Light>();
		
		for(Light l : lights) {
			lightmap.put(Integer.valueOf(l.getID()), l);
		}
	}
	
	public ConcreteGroup(int groupId, Color color, boolean on, Set<Light> lights, Set<ScheduledToggle> sToggle) {
		this.groupId = groupId;
		this.lights = lights;
		this.on = false;
		this.color = new Color((byte)255, (byte)255, (byte)255);
		lightmap = new HashMap<Integer, Light>();
		toggles = new HashMap<Integer, ScheduledToggle>();
		for(Light l : lights) {
			lightmap.put(Integer.valueOf(l.getID()), l);
		}
		for(ScheduledToggle s : sToggle) {
			toggles.put(Integer.valueOf(s.getId()), s);
		}
	}
	
	public ConcreteGroup(int id, Color color, boolean on, Set<Light> lights){
		this.groupId = id;
		this.color = color;
		this.on = on;
		this.lights = lights;
		lightmap = new HashMap<Integer, Light>();
		
		for(Light l : lights) {
			lightmap.put(Integer.valueOf(l.getID()), l);
		}
	}
	
	public Set<Light> getLights() {
		return lights;
	}

	/* (non-Javadoc)
	 * @see com.model.LightGroup#addLight(com.model.Light)
	 */
	public boolean addLight(Light light) {
		return lights.add(light);	
	}

	/* (non-Javadoc)
	 * @see com.model.LightGroup#turnOn()
	 */
	public boolean turnOn() {
		on = true;
		for (Light light : lights){
			if (!light.turnOn()){
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.model.LightGroup#turnOff()
	 */
	public boolean turnOff() {
		on = false;
		for (Light light : lights){
			if (!light.turnOff()){
				return false;
			}
		}
		return true;
		
	}

	public int getID() {
		return this.groupId;
	}

	public boolean isOn() {
		return this.on;
	}

	public Color getColor() {
		return this.color;
	}
	
	public boolean changeColor(Color color) {
		this.color = color;
		return true;
	}
	
	public boolean addScheduledToggle(ScheduledToggle schedule) {
		Integer max = Integer.valueOf(0);
		Set<Integer> keys = this.toggles.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()) {
			Integer temp = it.next();
			if(max.compareTo(temp) < 0)
				max = temp;
		}
		schedule.setId(max.intValue() + 1);
		this.toggles.put(Integer.valueOf(schedule.getId()), schedule);
		return true;
	}

	public boolean removeScheduledToggle(int scheduleId) {
		return this.toggles.remove(Integer.valueOf(scheduleId)) != null;
	}

	public boolean removeLight(int lightId) {
		Light l = this.lightmap.remove(Integer.valueOf(lightId));
		return this.lights.remove(l);
	}
	
	public Set<ScheduledToggle> getScheduledToggles() {
		Set<ScheduledToggle> ret = new HashSet<ScheduledToggle>();
		ret.addAll(this.toggles.values());
		return ret;
	}
}
