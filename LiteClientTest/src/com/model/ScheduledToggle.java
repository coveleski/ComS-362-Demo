/**
 * 
 */
package com.model;

import java.util.Date;

/**
 * @author Carl, Qian
 *
 */
public class ScheduledToggle {
	private int id;
	private Date on;
	private Date off;
	private Color color;
	private int frequency;
	private boolean group;
	
	/**
	 * @param on
	 * @param off
	 * @param color
	 * @param group
	 */
	public ScheduledToggle(Date on, Date off, Color color, int frequency, boolean group) {
		this.id = 0;
		this.on = on;
		this.off = off;
		this.color = color;
		this.frequency = frequency;
		this.group = group;
	}
	/**
	 * @param on
	 * @param off
	 * @param color
	 * @param group
	 */
	public ScheduledToggle(int id, Date on, Date off, Color color, int frequency, boolean group) {
		this.id = id;
		this.on = on;
		this.off = off;
		this.color = color;
		this.frequency = frequency;
		this.group = group;
	}
	
	/**
	 * @return the on
	 */
	public Date getOn() {
		return on;
	}
	
	/**
	 * @return the off
	 */
	public Date getOff() {
		return off;
	}
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * 
	 * @return the frequency
	 */
	public int getFrequency() {
		return this.frequency;
	}
	
	/**
	 * @return the group
	 */
	public boolean isGroup() {
		return group;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
}
