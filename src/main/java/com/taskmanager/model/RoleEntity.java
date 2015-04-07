package com.taskmanager.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class RoleEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String roleName;
	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users;
	
	public RoleEntity(){
	}

	public RoleEntity(int id, String roleName, List<UserEntity> users) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	};

}
