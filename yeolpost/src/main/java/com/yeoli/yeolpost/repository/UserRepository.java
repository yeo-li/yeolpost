package com.yeoli.yeolpost.repository;

import com.yeoli.yeolpost.model.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

  Optional<User> findByUserName(String userName);
}
