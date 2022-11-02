package com.einfochips.rest.webservices.restfullwebservices.users;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.einfochips.rest.webservices.restfullwebservices.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "user_details")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	@Size(min = 2, message = "Name has minimum 2 character")
	private String name;
	@PastOrPresent(message = "Please provide preset or Past birthDate")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;

	public User() {
		super();
	}

	public User(Long id, @Size(min = 2, message = "Name has minimum 2 character") String name,
			@PastOrPresent(message = "Please provide preset or Past birthDate") LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", posts=" + posts + "]";
	}

}
