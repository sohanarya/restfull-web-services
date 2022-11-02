package com.einfochips.rest.webservices.restfullwebservices.post;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.einfochips.rest.webservices.restfullwebservices.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	@Size(min=2,message = "Name has minimum 2 character")
	private String post;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	public Post() {
		super();
	}
	public Post(Long id, @Size(min = 2, message = "Name has minimum 2 character") String post) {
		super();
		this.id = id;
		this.post = post;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", post=" + post + "]";
	}
}
