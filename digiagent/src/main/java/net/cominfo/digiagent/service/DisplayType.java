package net.cominfo.digiagent.service;

import java.util.ArrayList;
import java.util.List;

public enum DisplayType {

	Navigation("1", "3", "5", "7"), Promotion("4", "5", "6", "7"), SecondHand(
			"2", "3", "6", "7");

	private List<String> value;

	public List<String> getValue() {
		return value;
	}

	private DisplayType(String... values) {
		List<String> v = new ArrayList<String>();
		for (String value : values) {
			v.add(value);
		}
		this.value = v;
	}

}
