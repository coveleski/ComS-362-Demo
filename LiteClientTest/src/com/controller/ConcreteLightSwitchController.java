/**
 * 
 */
package com.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.controller.interfaces.LightSwitchController;
import com.model.interfaces.*;
import com.model.*;

/**
 * @author Carl, Qian
 *
 */
public class ConcreteLightSwitchController implements LightSwitchController {

	private LightSwitchBank lightSwitchBank;
	
	public ConcreteLightSwitchController() {
		this.lightSwitchBank = new ConcreteLightSwitchBank();
	}
	
	/* (non-Javadoc)
	 * @see com.model.LightSwitchController#getAllLights()
	 */
	public Set<Light> getAllLights() {
		return this.lightSwitchBank.getAllLights();
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchController#createGroup(java.util.List)
	 */
	@Override
	public boolean createGroup(List<Integer> lightIds) {
		return this.lightSwitchBank.createGroup(lightIds);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchController#addLightToGroup(int, int)
	 */
	public boolean addLightToGroup(int lightId, int groupId) {
		return this.lightSwitchBank.addLightToGroup(lightId, groupId);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchController#getAllGroups()
	 */
	public Set<Group> getAllGroups() {
		return this.lightSwitchBank.getAllGroups();
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchController#turnLightOn(int)
	 */
	public boolean turnLightOn(int lightId) {
		return this.lightSwitchBank.turnLightOn(lightId);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchController#turnGroupOn(int)
	 */
	public boolean turnGroupOn(int groupId) {
		return this.lightSwitchBank.turnGroupOn(groupId);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchController#turnLightOff(int)
	 */
	public boolean turnLightOff(int lightId) {
		return this.lightSwitchBank.turnLightOff(lightId);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchController#turnGroupOff(int)
	 */
	public boolean turnGroupOff(int groupId) {
		return this.lightSwitchBank.turnGroupOff(groupId);
	}

	/* (non-Javadoc)
	 * @see com.model.LightSwitchController#changeLightColor(int, com.model.Color)
	 */
	public boolean changeLightColor(int lightId, Color color) {
		return this.lightSwitchBank.changeLightColor(lightId, color);
	}

	public boolean createScheduledLightToggle(int lightId, Date on, Date off, Color color, int frequency) {
		return this.lightSwitchBank.createScheduledLightToggle(lightId, on, off, color, frequency);
	}

	public boolean createScheduledGroupToggle(int groupId, Date on, Date off, Color color, int frequency) {
		return this.lightSwitchBank.createScheduledGroupToggle(groupId, on, off, color, frequency);
	}

	public boolean removeScheduledLightToggle(int lightId, int scheduleId) {
		return this.lightSwitchBank.removeScheduledLightToggle(lightId, scheduleId);
	}

	public boolean removeScheduledGroupToggle(int groupId, int scheduleId) {
		return this.lightSwitchBank.removeScheduledGroupToggle(groupId, scheduleId);
	}

	public boolean removeLightFromGroup(int groupId, int lightId) {
		return this.lightSwitchBank.removeLightFromGroup(groupId, lightId);
	}

	public boolean removeGroup(int groupId) {
		return this.lightSwitchBank.removeGroup(groupId);
	}

	public boolean enableScheduling() {
		return this.lightSwitchBank.enableScheduling();
	}

	public boolean disableScheduling() {
		return this.lightSwitchBank.disableScheduling();
	}

	public Set<ScheduledToggle> getAllScheduledToggles(int lightId) {
		return this.lightSwitchBank.getAllScheduledToggles(lightId);
	}

	public Set<ScheduledToggle> getAllScheduledTogglesFromGroup(int groupId) {
		return this.lightSwitchBank.getAllScheduledTogglesFromGroup(groupId);
	}

	public boolean changeGroupColor(int groupId, Color color) {
		return this.lightSwitchBank.changeGroupColor(groupId, color);
	}

	public Light findLight(int lightId) {
		return this.lightSwitchBank.findLight(lightId);
	}

	public Group findGroup(int groupId) {
		return this.lightSwitchBank.findGroup(groupId);
	}

	public Set<Light> getAllLightsInGroup(int groupId) {
		return this.lightSwitchBank.getAllLightsInGroup(groupId);
	}

	public boolean addScheduledLightColorChange(int lightId, Date on, Date off, int frequency, Color color) {
		return this.lightSwitchBank.addScheduledLightColorChange(lightId, on, off, frequency, color);
	}

	public boolean addScheduledGroupColorChange(int groupId, Date on, Date off, int frequency, Color color) {
		return this.lightSwitchBank.addScheduledGroupColorChange(groupId, on, off, frequency, color);
	}

}
