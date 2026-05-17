package fr.astth.ms.service;

import java.util.HashMap;

public class ServiceRegister {

	private HashMap<String, Class<?>> services = new HashMap<>();

	public void registerService(String name, Class<?> service) {
		this.services.put(name, service);
	}

	public Class<?> getService(String name) {
		return this.services.get(name);
	}

}
