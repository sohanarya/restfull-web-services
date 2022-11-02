package com.einfochips.rest.webservices.restfullwebservices.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.einfochips.rest.webservices.restfullwebservices.exception.UserNotFoundException;
import com.einfochips.rest.webservices.restfullwebservices.post.Post;

@RestController
public class UserController {

	private UserDaoService service;

	public UserController(UserDaoService service) {
		this.service = service;
	}

	// GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// GET /users
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable long id) {
		Optional<User> user = service.findOne(id);
		EntityModel<User> entityModels = null;
		if (user.isPresent())
			entityModels = EntityModel.of(user.get());
		else
			throw new UserNotFoundException("Id " + id + " is Not Present");

		return entityModels;
	}

	// Create User
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
		User savedUser = service.saveUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable long id) {
		service.deleteUser(id);
	}

	@GetMapping("/users/{id}/post")
	public List<Post> retrieveAllPostforUser(@PathVariable long id) {
		Optional<User> user = service.findOne(id);

		if (user.isPresent())
			return user.get().getPosts();
		else
			throw new UserNotFoundException("Id " + id + " is Not Present");
	}
	
	// Create Post
		@PostMapping("/posts")
		public ResponseEntity<User> createPost(@Validated @RequestBody Post post) {
			Post savedpost = service.savePost(post);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedpost.getId())
					.toUri();
			return ResponseEntity.created(uri).build();
		}
}
