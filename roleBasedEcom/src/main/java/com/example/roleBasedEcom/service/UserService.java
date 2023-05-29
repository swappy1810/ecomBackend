package com.example.roleBasedEcom.service;

import com.example.roleBasedEcom.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

     User registerNewUser(User user);

     void initRolesAndUsers();

}
