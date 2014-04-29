/**
 * 
 */
package com.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.model.interfaces.Light;

/**
 * @author Carl
 *
 */
public class ConcreteLight implements Light {

	private int deviceId;
	private int groupId;
	private Color color;
	private boolean on;
	private Map<Integer, ScheduledToggle> scheduledToggles;
	
	/**
	 * @param ip 
	 * @param port 
	 * @param deviceId 
	 * @param groupId 
	 * @param color 
	 */
	protected ConcreteLight(int deviceId, Color color, boolean on) {
		this.deviceId = deviceId;
		this.color = color;
		this.on = on;
	}
	
	protected ConcreteLight(int deviceId, Color color, boolean on, Set<ScheduledToggle> toggles) {
		this.deviceId = deviceId;
		this.color = color;
		this.on = on;
		scheduledToggles = new HashMap<Integer, ScheduledToggle>();
		for(ScheduledToggle s : toggles) {
			scheduledToggles.put(Integer.valueOf(s.getId()), s);
		}
	}

	/* (non-Javadoc)
	 * @see com.model.Light#turnOn()
	 */
	public boolean turnOn() {
		on = true;
		return true;
	}

	/* (non-Javadoc)
	 * @see com.model.Light#turnOff()
	 */
	public boolean turnOff() {
		on = false;
		return true;
	}

	/* (non-Javadoc)
	 * @see com.model.Light#changeColor()
	 */
	public boolean changeColor(Color color) {
		this.color = color;
		return true;
	}
	
	public int getID() {
		return this.deviceId;
	}
	
	public int getGroupID() {
		return this.groupId;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public boolean isOn() {
		return this.on;
	}

	public boolean addScheduledToggle(ScheduledToggle schedule) {
		Integer max = Integer.valueOf(0);
		Set<Integer> keys = this.scheduledToggles.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()) {
			Integer temp = it.next();
			if(temp.compareTo(max) < 0)				
				max = temp;
		}
		schedule.setId(max.intValue() + 1);
		this.scheduledToggles.put(Integer.valueOf(schedule.getId()), schedule);	
		return true; 	
	}

	public boolean removeScheduledToggle(int scheduleId) {
		Integer key = Integer.valueOf(scheduleId);
		if(this.scheduledToggles.containsKey(key)) {
			this.scheduledToggles.remove(key);
			return true;
		}
		return false;
	}

	public Set<ScheduledToggle> getAllScheduledToggles() {
		Collection<ScheduledToggle> c = this.scheduledToggles.values();
		Iterator<ScheduledToggle> it = c.iterator();
		Set<ScheduledToggle> ret = new HashSet<ScheduledToggle>();
		while(it.hasNext()) {
			ret.add(it.next());
		}
		return ret;
	}
}
