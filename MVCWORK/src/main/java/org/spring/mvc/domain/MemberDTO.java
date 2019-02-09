package org.spring.mvc.domain;


public class MemberDTO {
	
	private String email;
	private String password;
	private String name;
	private String photo;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [email=" + email + ", password=" + password + ", name=" + name + ", photo=" + photo + "]";
	}
	
	
	
	
	
	
	
}
