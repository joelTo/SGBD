package fr.ihm;

import java.util.Map;
import java.util.TreeMap;

import fr.ihm.action.ActionClient;

public class MainMenuClient {
	private Map<Integer, ActionClient> map = new TreeMap<Integer, ActionClient>();
	private IhmUtilClient ihmUtilClient;
	
	public MainMenuClient (IhmUtilClient ihmUtilClient) {
		this.ihmUtilClient=ihmUtilClient;
		
		map.put(1, null);
		
	}
	
	
	
}

