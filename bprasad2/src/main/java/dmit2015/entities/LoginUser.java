package dmit2015.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class LoginUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginUser() {
		
	}
	@Id
	@Column(name="userid",nullable=false)
	private Long id;
	@Column(length=64, unique=true, nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public List<LoginGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<LoginGroup> groups) {
		this.groups = groups;
	}
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="LoginUserGroup", joinColumns={@JoinColumn(name="userid")},
	inverseJoinColumns={@JoinColumn(name="groupid")})
	private List<LoginGroup> groups = new ArrayList<>();
	// getters, setters, constructors
}
