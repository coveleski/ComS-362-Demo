package com.model.interfaces;

import java.util.Set;
import com.model.Color;
import com.model.ScheduledToggle;

public interface Group {
	public boolean addLight(Light light);
	public boolean turnOn();
	public boolean turnOff();
	
	public int getID();
	public Set<Light> getLights();
	public boolean isOn();
	public Color getColor();
	public boolean addScheduledToggle(ScheduledToggle schedule);
	
	public boolean removeScheduledToggle(int scheduleId);
	public boolean removeLight(int lightId);
	public Set<ScheduledToggle> getScheduledToggles();
	public boolean changeColor(Color color);
}
