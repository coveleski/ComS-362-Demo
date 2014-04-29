/**
 * 
 */
package com.server;

import java.util.Collection;
import java.util.LinkedList;

import liteprotocol.*;
import liteprotocol.interfaces.Server;
import liteprotocol.interfaces.ServerListener;

/**
 * @author Carl
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Usagee ServerTest <id> <port>");
			System.exit(0);
		}
		final Server server = new ServerCommunicator(Integer.valueOf(args[0]).intValue(), Integer.valueOf(args[1]).intValue());
		server.addServerListener(new ServerListener() {

			LiteColor color = new LiteColor(new LightBoolean(false), (byte)255, (byte)255, (byte)255);
			Collection<Toggle> groupToggles = new LinkedList<Toggle>();
			Collection<Toggle> lightToggles = new LinkedList<Toggle>();
			//boolean togglesEnabled = true;
			
			public void setGroup(int groupId) {
				server.setGroupId(groupId);
			}

			public void setColor(LiteColor color) {
				this.color = color;				
			}

			public void setToggles(Collection<Toggle> toggle, boolean group) {
				if(group)
					groupToggles = toggle;
				else
					lightToggles = toggle;				
			}

			public void setEnabledToggles(boolean enabled) {
				//togglesEnabled = enabled;
			}

			public void requestForColor(Recipient r) {
				server.sendColor(r, color);
			}

			public void requestToggles(Recipient r, boolean group) {
				if(group)
					server.sendToggles(r, groupToggles);
				else
					server.sendToggles(r, lightToggles);
			}});
		server.start();
	}

}
