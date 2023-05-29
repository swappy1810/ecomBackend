package com.example.roleBasedEcom.serviceImpl;

import com.example.roleBasedEcom.dao.RoleDao;
import com.example.roleBasedEcom.entity.Role;
import com.example.roleBasedEcom.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
