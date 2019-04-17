package dmit2015.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class LoginGroup implements Serializable {

	private static final long serialVersionUID = 1L;
@Id
@Column(name="groupid",nullable=false)
private Long id;
@Column(length=64, unique=true, nullable=false)
private String groupname;
@ManyToMany(mappedBy="groups")
private List<LoginUser> users;
// getters, setters, constructors
public Long getId() {
	return id;
}
public LoginGroup() {

}
public void setId(Long id) {
	this.id = id;
}
public String getGroupname() {
	return groupname;
}
public void setGroupname(String groupname) {
	this.groupname = groupname;
}
public List<LoginUser> getUsers() {
	return users;
}
public void setUsers(List<LoginUser> users) {
	this.users = users;
}


}