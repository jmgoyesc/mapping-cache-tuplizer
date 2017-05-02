package com.personal.hiberante.model;

/**
 * Event entity
 * Created by juan.goyes on 2017-05-02.
 */
public class Event {
	private String id;
	private String name;

	public Event() {
	}

	public Event(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
