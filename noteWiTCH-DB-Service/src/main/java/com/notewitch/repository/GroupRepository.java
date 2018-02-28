package com.notewitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notewitch.entity.Group;

public interface GroupRepository extends JpaRepository<Group, String> {

}
