package com.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import liteprotocol.ClientCommunicator;
import liteprotocol.GroupState;
import liteprotocol.LightBoolean;
import liteprotocol.LightState;
import liteprotocol.LiteColor;
import liteprotocol.Toggle;
import liteprotocol.interfaces.*;

import com.model.interfaces.Light;
import com.model.interfaces.Group;
import com.model.interfaces.LightProtocolAdapter;

public class ConcreteLightProtocolAdapter implements LightProtocolAdapter {
	private Client client;

	public ConcreteLightProtocolAdapter(){
		client = new ClientCommunicator();
	}

	public Set<Light> getAllLights() {
		Collection<Integer> lightIds = client.getAllLightIds();
		if(lightIds == null) {
			return null;
		}
		Set<Light> lights = new HashSet<Light>();
		for(Integer i : lightIds) {
			lights.add(createLight(i.intValue()));
		}
		return lights;
	}

	public Set<Group> getAllGroups() {
		Collection<Integer> groupIds = client.getAllGroupIds();
		if(groupIds == null) {
			return null;
		}
		Set<Group> groups = new HashSet<Group>();
		for(Integer i : groupIds) {
			groups.add(createLightGroup(i.intValue()));
		}
		return groups;
	}

	public boolean createGroup(List<Integer> lightIds) {
		try {
			Collection<Integer> groupIds = client.getAllGroupIds();
			Integer max = Integer.valueOf(0);
			for(Integer i : groupIds) {
				Integer temp = i;
				if(max.compareTo(temp) < 0)
					max = temp;
			}
			Set<Light> lights = new HashSet<Light>();
			for(Integer i : lightIds) {
				lights.add(createLight(i));
			}
			Group group = new ConcreteGroup(max.intValue() + 1, lights);
			this.updateGroup(group);			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Group getGroup(int groupId) {
		return createLightGroup(groupId);
	}

	public boolean updateGroup(Group group) {
		try {
			Set<Light> lights = group.getLights();
			for(Light l : lights) {
				Light temp = l;
				try {
					client.setLightGroup(temp.getID(), group.getID());
				} catch (Exception e) {
					return false;
				}
			}
			client.setGroupColor(group.getID(), new LiteColor(new LightBoolean(group.isOn()), group.getColor().getRed(), group.getColor().getGreen(), group.getColor().getBlue()));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateLight(Light light) {
		try {
			client.setLightGroup(light.getID(), light.getGroupID());
			client.setLightColor(light.getID(), new LiteColor(new LightBoolean(light.isOn()), light.getColor().getRed(), light.getColor().getGreen(), light.getColor().getBlue()));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Light getLight(int lightId) {
		return createLight(lightId);
	}

	private Light createLight(int lightId) {
		LightState state = client.getLightState(lightId);		
		Collection<Toggle> toggles = client.getLightToggles(lightId);
		Set<ScheduledToggle> stoggles = new HashSet<ScheduledToggle>();
		for(Toggle t : toggles) {
			stoggles.add(new ScheduledToggle(t.getId(), t.getOn(), t.getOff(), new Color(t.getColor().getRed(), t.getColor().getGreen(), t.getColor().getBlue()), t.getFrequency().getValue(), false));
		}
		return new ConcreteLight(state.getLightId(), new Color(state.getColor().getRed(), state.getColor().getGreen(), state.getColor().getBlue()), state.getColor().getOn().getValue(), stoggles);
	}

	private Group createLightGroup(int groupId) {
		GroupState state = client.getGroup(groupId);
		Set<Light> lights = new HashSet<Light>();
		Collection<Integer> lightIds = state.getLightIds();
		Collection<Toggle> toggles = client.getGroupToggles(groupId);
		Set<ScheduledToggle> sToggles = new HashSet<ScheduledToggle>();
		for(Integer i : lightIds) {
			lights.add(createLight(i.intValue()));
		}
		for(Toggle t : toggles) {
			sToggles.add(new ScheduledToggle(t.getId(), t.getOn(), t.getOff(), new Color(t.getColor().getRed(), t.getColor().getGreen(), t.getColor().getBlue()), t.getFrequency().getValue(), true));
		}
		return new ConcreteGroup(state.getGroupID(), new Color(state.getColor().getRed(), state.getColor().getGreen(), state.getColor().getBlue()), state.getColor().getOn().getValue(), lights, sToggles);
	}

	public boolean removeGroup(Group group) {
		try {
			Set<ScheduledToggle> toggles = group.getScheduledToggles();
			Collection<Integer> toggleIds = new HashSet<Integer>();
			for(ScheduledToggle s : toggles) {
				toggleIds.add(Integer.valueOf(s.getId()));
			}
			client.removeAllGroupToggles(group.getID());
			Set<Light> lights = group.getLights();
			for(Light l : lights) {
				client.setLightGroup(l.getID(), 0);
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public boolean enableScheduling() {
		try {
			Collection<Integer> lightIds = client.getAllLightIds();
			for(Integer i : lightIds) {
				client.setLightEnableToggles(i, true);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean disableScheduling() {
		try {
			Collection<Integer> lightIds = client.getAllLightIds();
			for(Integer i : lightIds) {
				client.setLightEnableToggles(i, false);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
