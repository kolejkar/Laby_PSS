package com.pss_lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss_lab.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
