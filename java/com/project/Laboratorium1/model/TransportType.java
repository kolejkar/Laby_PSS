package com.project.Laboratorium1.model;

import lombok.Getter;
import lombok.Setter;

public enum TransportType {
	AUTO("Auto"),
	TRAIN("Pociąg"),
	BUS("Autobus");
	
	@Getter
	@Setter
	private String name;
	
	private TransportType(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
}
