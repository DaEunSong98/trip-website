package com.ssafy.enjoytrip.repository;

import com.ssafy.enjoytrip.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
