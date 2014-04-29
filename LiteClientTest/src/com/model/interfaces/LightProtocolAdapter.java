package com.model.interfaces;

import java.util.*;

public interface LightProtocolAdapter {
	public Set<Light> getAllLights();
	public Set<Group> getAllGroups();
	public Group getGroup(int groupId);
	public boolean updateGroup(Group group);
	public boolean createGroup(List<Integer> lightIds);
	public Light getLight(int lightId);
	public boolean updateLight(Light light);
	public boolean removeGroup(Group group);
	public boolean enableScheduling();
	public boolean disableScheduling();
}
