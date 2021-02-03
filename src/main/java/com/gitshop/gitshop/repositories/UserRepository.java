package com.gitshop.gitshop.repositories;


import org.springframework.data.repository.CrudRepository;
import com.gitshop.gitshop.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String firstName);

	Optional<User> findById(Long id);
}