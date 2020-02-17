package com.pegadaian.exercise.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pegadaian.exercise.model.User;

public interface UserRepository  extends JpaRepository<User, String>{
	@Query(value = "SELECT email FROM user", nativeQuery = true)
	List<Object[]> findByEmail(@Param("email") String tanggal);
}
