package com.softworkshub.userservice.repo;

import com.softworkshub.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
