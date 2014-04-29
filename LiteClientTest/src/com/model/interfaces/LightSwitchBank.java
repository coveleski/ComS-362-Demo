package com.model.interfaces;

import java.util.*;
import com.model.Color;
import com.model.ScheduledToggle;

public interface LightSwitchBank {
	public Set<Light> getAllLights();
	public boolean createGroup(List<Integer> lightIds);
	public boolean addLightToGroup(int lightId, int groupId);
	public Set<Group> getAllGroups();
	public boolean turnLightOn(int lightId);
	public boolean turnGroupOn(int groupId);
	public boolean turnLightOff(int lightId);
	public boolean turnGroupOff(int groupId);
	public boolean changeLightColor(int lightId, Color color);
	
	public boolean createScheduledLightToggle (int lightId, Date on, Date off, Color color, int frequency);
	public boolean createScheduledGroupToggle (int groupId, Date on, Date off, Color color, int frequency);
	public boolean removeScheduledLightToggle (int lightId, int scheduleId);
	public boolean removeScheduledGroupToggle (int groupId, int scheduleId);
	public boolean removeLightFromGroup (int groupId, int lightId);
	public boolean removeGroup (int groupId);
	public boolean enableScheduling ();
	public boolean disableScheduling();
	public Set<ScheduledToggle> getAllScheduledToggles (int lightId);
	
	public Set<ScheduledToggle> getAllScheduledTogglesFromGroup(int groupId);
	public boolean changeGroupColor(int groupId, Color color);
	public Light findLight(int lightId);
	public Group findGroup(int groupId);
	public Set<Light> getAllLightsInGroup(int groupId);
	public boolean addScheduledLightColorChange(int lightId, Date on, Date off, int frequency, Color color);
	public boolean addScheduledGroupColorChange(int groupId, Date on, Date off, int frequency, Color color);
}
