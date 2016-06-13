package by.epamlab.beans.user;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -464141511194688141L;
	
	private String name;
	private Role role;
	
	public User() {
		this("", Role.VISITOR.name());
	}
	
	public User(String name) {
		this(name, Role.USER.name());
	}
	
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = Role.valueOf(role);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
