package com.example.roleBasedEcom.dao;

import com.example.roleBasedEcom.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,String> {
}
