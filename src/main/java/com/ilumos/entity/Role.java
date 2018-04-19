package com.ilumos.entity;

/**
 * 角色实体类
 * @author liwei
 *
 */
public class Role {
	
	private Integer id;
	private String roleName;//角色名称
	
	public Role(){
		super();
	}

	public Role(Integer id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}
