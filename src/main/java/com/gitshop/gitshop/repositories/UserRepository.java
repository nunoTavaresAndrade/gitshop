package com.gitshop.gitshop.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.gitshop.gitshop.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String firstName);

	User findById(long id);
}