package com.einfochips.rest.webservices.restfullwebservices.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositry extends JpaRepository<User, Long> {

}
