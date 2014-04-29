package com.model.interfaces;

import java.util.Set;
import com.model.Color;
import com.model.ScheduledToggle;

public interface Light {
	public boolean turnOn();
	public boolean turnOff();
	public boolean changeColor(Color color);
	
	public int getID();
	public int getGroupID();
	public Color getColor();
	public boolean isOn();
	public boolean addScheduledToggle(ScheduledToggle schedule);
	public boolean removeScheduledToggle(int scheduleId);
	public Set<ScheduledToggle> getAllScheduledToggles();
}
