/**
 * 
 */
package com.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.model.interfaces.Light;
import com.model.interfaces.Group;
import com.model.interfaces.LightProtocolAdapter;
import com.model.interfaces.LightSwitchBank;

/**
 * @author Carl, David, Qian
 *
 */
public class ConcreteLightSwitchBank implements LightSwitchBank {

	private LightProtocolAdapter adapter;
	
	public ConcreteLightSwitchBank() {
		this.adapter = new ConcreteLightProtocolAdapter();
	}
	
	/* (non-Javadoc)
	 * @see com.model.LightSwitchBank#getAllLights()
	 */
	public Set<Light> getAllLights() {
		return this.adapter.getAllLights();
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchBank#createGroup(java.util.List)
	 */
	public boolean createGroup(List<Integer> lightIds) {
		return this.adapter.createGroup(lightIds);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchBank#addLightToGroup(int, int)
	 */
	public boolean addLightToGroup(int lightId, int groupId) {
		Group group = this.adapter.getGroup(groupId);
		Light light = this.adapter.getLight(lightId);
		group.addLight(light);
		return this.adapter.updateGroup(group);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchBank#getAllGroups()
	 */
	public Set<Group> getAllGroups() {
		return this.adapter.getAllGroups();
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchBank#turnLightOn(int)
	 */
	public boolean turnLightOn(int lightId) {
		Light light = this.adapter.getLight(lightId);
		light.turnOn();
		return this.adapter.updateLight(light);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchBank#turnGroupOn(int)
	 */
	public boolean turnGroupOn(int groupId) {
		Group group = (ConcreteGroup) this.adapter.getGroup(groupId);
		group.turnOn();
		return this.adapter.updateGroup(group);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchBank#turnLightOff(int)
	 */
	public boolean turnLightOff(int lightId) {
		Light light = this.adapter.getLight(lightId);
		light.turnOff();
		return this.adapter.updateLight(light);
		
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchBank#turnGroupOff(int)
	 */
	public boolean turnGroupOff(int groupId) {
		Group group = (ConcreteGroup) this.adapter.getGroup(groupId);
		group.turnOff();
		return this.adapter.updateGroup(group);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchBank#changeLightColor(int, com.model.Color)
	 */
	public boolean changeLightColor(int lightId, Color color) {
		Light light =  this.adapter.getLight(lightId);
		light.changeColor(color);
		return this.adapter.updateLight(light);
	}

	public boolean createScheduledLightToggle(int lightId, Date on, Date off, Color color, int frequency) {
		ScheduledToggle t = new ScheduledToggle(on, off, color, frequency, false);
		Light l = this.adapter.getLight(lightId);
		if(l == null)
			return false;
		if(!l.addScheduledToggle(t))
			return false;
		return this.adapter.updateLight(l);
	}

	public boolean createScheduledGroupToggle(int groupId, Date on, Date off, Color color, int frequency) {
		ScheduledToggle t = new ScheduledToggle(on, off, color, frequency, false);
		Group g = this.adapter.getGroup(groupId);
		if(g == null)
			return false;
		if(!g.addScheduledToggle(t))
			return false;
		return this.adapter.updateGroup(g);
	}

	public boolean removeScheduledLightToggle(int lightId, int scheduleId) {
		Light l = this.adapter.getLight(lightId);
		if(l == null)
			return false;
		if(!l.removeScheduledToggle(scheduleId))
			return false;
		return this.adapter.updateLight(l);
	}

	public boolean removeScheduledGroupToggle(int groupId, int scheduleId) {
		Group g = this.adapter.getGroup(groupId);
		if(g == null)
			return false;
		if(!g.removeScheduledToggle(scheduleId))
			return false;
		return this.adapter.updateGroup(g);
	}

	public boolean removeLightFromGroup(int groupId, int lightId) {
		Group g = this.adapter.getGroup(groupId);
		if(g == null)
			return false;
		if(!g.removeLight(lightId))
			return false;
		return this.adapter.updateGroup(g);
	}

	public boolean removeGroup(int groupId) {
		Group g = this.adapter.getGroup(groupId);
		if(g == null)
			return false;
		return this.adapter.updateGroup(g);
	}

	public boolean enableScheduling() {
		return this.adapter.enableScheduling();
	}

	public boolean disableScheduling() {
		return this.adapter.disableScheduling();
	}

	public Set<ScheduledToggle> getAllScheduledToggles(int lightId) {
		Light l = this.adapter.getLight(lightId);
		if(l == null)
			return null;
		return l.getAllScheduledToggles();
	}

	public Set<ScheduledToggle> getAllScheduledTogglesFromGroup(int groupId) {
		return this.adapter.getGroup(groupId).getScheduledToggles();
	}

	public boolean changeGroupColor(int groupId, Color color) {
		Group group = this.adapter.getGroup(groupId);
		group.changeColor(color);
		return this.adapter.updateGroup(group);
	}

	public Light findLight(int lightId) {
		return this.adapter.getLight(lightId);
	}

	public Group findGroup(int groupId) {
		// TODO Auto-generated method stub
		return this.adapter.getGroup(groupId);
	}

	public Set<Light> getAllLightsInGroup(int groupId) {
		return this.adapter.getGroup(groupId).getLights();
	}

	public boolean addScheduledLightColorChange(int lightId, Date on, Date off, int frequency, Color color) {
		return this.adapter.getLight(lightId).addScheduledToggle(new ScheduledToggle(on, off, color, frequency, false));
	}

	public boolean addScheduledGroupColorChange(int groupId, Date on, Date off, int frequency, Color color) {
		return this.adapter.getGroup(groupId).addScheduledToggle(new ScheduledToggle(on, off, color, frequency, true));
	}
}
