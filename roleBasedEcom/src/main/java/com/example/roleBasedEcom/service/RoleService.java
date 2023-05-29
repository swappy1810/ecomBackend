package com.example.roleBasedEcom.service;

import com.example.roleBasedEcom.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

     Role createNewRole(Role role);

}
