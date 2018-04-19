package com.ilumos.adapter;

import java.util.List;

import com.ilumos.entity.Role;

public class MyRole {

	private String key;
	private List<Role> value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<Role> getValue() {
		return value;
	}
	public void setValue(List<Role> value) {
		this.value = value;
	}
	
}
