package com.example.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Credentials {

    @Id
    @Indexed(unique=true)
    private String username;
	private String password;
    private String role;


	public Credentials() {
        // Default constructor
    }
    
    public Credentials(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    public String getRole() {
		return role;
	}

	public void setRoles(String role) {
		this.role = role;
	}
    
}

